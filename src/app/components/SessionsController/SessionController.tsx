import Button from '../Button/Button';
import * as SC from './SessionController.styles'
import Icon from '@mdi/react';
import { mdiAccount } from '@mdi/js';

export interface SessionControllerProps {
    nome: string;
    description: string;
    onLogout?: ()=>any;
}

function SessionController (props: SessionControllerProps){
    return <SC.Wrapper>
            <SC.Avatar>
                    <Icon path={mdiAccount}/>
            </SC.Avatar>
           
                <SC.Name>
                    {props.nome}
                </SC.Name>
                <SC.Description>
            { props.description }
            </SC.Description>
            <Button variant="danger" label="Logout" onClick={props.onLogout} />

    </SC.Wrapper>
}

export default SessionController