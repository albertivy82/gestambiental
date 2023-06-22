import usePageTitle from "../../core/hooks/usePageTitle"
import DefaultLayout from "../layouts/Default/Default.layout"

export default function UserEdtion(){
    usePageTitle('Usuários')
    return <DefaultLayout>
        <h1>Inserir/Editar Usuários</h1>      
        </DefaultLayout>
}