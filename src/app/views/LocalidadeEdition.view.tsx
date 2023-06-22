import usePageTitle from "../../core/hooks/usePageTitle"
import LocalidadeForm from "../features/LocalidadeForm"
import DefaultLayout from "../layouts/Default/Default.layout"

export default function LocalidadeEdtion(){
    usePageTitle('Localidades')
    return <DefaultLayout>
       <LocalidadeForm/> 
        </DefaultLayout>
}