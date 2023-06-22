import { useMemo } from 'react';
import { Column, useTable } from 'react-table';
import Button from '../components/Button/Button';
import Table from '../components/Table/Table';

type Post = {
  
    Localidade: string
    Button: String
    
  }


  export default function LocalidadeList () {
    const data = useMemo<Post[]>(
      () => [
        {
          Localidade: "Nossa Senhora de Curuá-Una",
          Button: 'Editar'
          
        }
      ],
      []
    )
  
    const columns = useMemo<Column<Post>[]>(
      () => [
        
        {
          accessor: 'Localidade',
          Cell: (props) => <div style={{ textAlign: 'left', display: 'flex', gap: 8, alignItems: 'center' }}>
            {props.value}
          </div>
        },
             
        {
         
          accessor: 'Button', // accessor is the "key" in the data
          Cell: (props) =>  <Button label='Editar' variant='primary'/>
        }
      ],
      []
    )
  
    const instance = useTable<Post>({ data, columns })

    return <Table
      instance={instance}
    />
  }
  

