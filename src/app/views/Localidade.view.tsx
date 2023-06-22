import { Link} from "react-router-dom"
import usePageTitle from "../../core/hooks/usePageTitle"
import DefaultLayout from "../layouts/Default/Default.layout"
import Button from "../components/Button/Button"
import styled from "styled-components"


export default function LocalidadeView(){
    usePageTitle('Localidades')

    return <DefaultLayout>
                 
        <LocalidadeLista>

            <div>
                    <List>
                        <Item>
                            Nossa Senhora do Curuá-Una
                        </Item>
                    </List>
            </div>

            <Botao>
                    <Link to="/localidade-edição">
                    <Button label="Nova localidade +" variant="primary"/>
                    </Link>
            </Botao>

            <Botao>
                    <Link to="/localidade-edição">
                    <Button label="Nova localidade +" variant="primary"/>
                    </Link>
            </Botao>
        </LocalidadeLista>
        <NovaLocalidade>
            <Link to="/localidade-edição">
               <Button label="Nova localidade +" variant="primary"/>
            </Link>
        </NovaLocalidade>
    </DefaultLayout>
}


export const LocalidadeLista = styled.div`

    display:grid;
    grid-template-columns: 600px 200px 200px;
    border-bottom: 1px solid #3336e9;
    justify-content: right;
   
`

export const NovaLocalidade = styled.div`

    display:flex;
    border-bottom: #3336e9;
    justify-content: right;
    gap:30px;
`

const List = styled.ul`
        display: flex;
        flex-direction: column;
        gap: 12px;
        list-style: none;
        
`

const Item = styled.li`
        font-size: 24px;
        justify-content: left;

        a{
            text-decoration: none;
            color:  #2053c0;

                    &.active {
                    color: #09f;
    }
        }
`

const Botao = styled.div`
    display:flex;
    justify-content: right;
    gap:30px;
`
    