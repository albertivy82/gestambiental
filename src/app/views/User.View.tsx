import { useParams } from "react-router-dom"
import usePageTitle from "../../core/hooks/usePageTitle"
import DefaultLayout from "../layouts/Default/Default.layout"

export default function UsuarioView(){
    usePageTitle('Usuários')
    return <DefaultLayout>
        <h1>USUÁRIOS</h1>      
        </DefaultLayout>
}