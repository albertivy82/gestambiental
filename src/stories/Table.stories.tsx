import { mdiOpenInNew } from '@mdi/js';
import Icon from '@mdi/react';
import { Meta } from '@storybook/react';
import { useMemo } from 'react';
import { Column, useTable } from 'react-table';
import Table from '../app/components/Table/Table';
import Button from '../app/components/Button/Button';

export default {
  title: 'Example/Table',
  component: Table,
} as Meta;

type Post = {
  
  Localidade: string
  Nada: String
  
}

export function Default () {
  const data = useMemo<Post[]>(
    () => [
      {
        Localidade: "Nossa Senhora de Curuá-Una",
        Nada: 'Editar',
        
      },
    
    ],
    []
  )

  const columns = useMemo<Column<Post>[]>(
    () => [
      
      {
        Header: () => <div style={{ textAlign: 'left' }}>Localidade</div>,
        accessor: 'Localidade',
        width: 320,
        Cell: (props) => <div style={{ textAlign: 'left', display: 'flex', gap: 8, alignItems: 'center' }}>
          {props.value}
        </div>
      },
           
      {
        Header: '',
        accessor: 'Nada', // accessor is the "key" in the data
        Cell: () => <Button label='Editar' variant='primary'/>
      },
    ],
    []
  )

  const insntace = useTable<Post>({ data, columns })

  return <Table<Post> instance={insntace} />
}



export function WithoutData () {
  const data = useMemo<Post[]>(
    () => [],
    []
  )

  const columns = useMemo<Column<Post>[]>(

    () => [
      
      {
        Header: () => <div style={{ textAlign: 'left' }}>Localidade</div>,
        accessor: 'Localidade',
        width: 320,
        Cell: (props) => <div style={{ textAlign: 'left', display: 'flex', gap: 8, alignItems: 'center' }}>
          {props.value}
        </div>
      },
           
      {
        Header: '',
        accessor: 'Nada', // accessor is the "key" in the data
        Cell: () => <Button label='Editar' variant='primary'/>
      },
    ],
    []
    
  )

  const insntace = useTable<Post>({ data, columns })

  return <Table<Post> instance={insntace} />
}