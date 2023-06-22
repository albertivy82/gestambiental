import { NavLink } from "react-router-dom";
import { Link } from "react-router-dom";
import styled from "styled-components";

export default function NavBar(){
    
      
    return <>
        <List>
            <Item><NavLink to="/">LOCALIDADES</NavLink></Item>
            <Item><NavLink to="/usuarios">USUÁRIOS</NavLink></Item>
        </List>
    </>
}

const List = styled.ul`
        display: flex;
        flex-direction: column;
        gap: 12px;
        list-style: none;
`

const Item = styled.li`
        text-transform: lowercase;
        font-size: 18px;

        a{
            text-decoration: none;
            color:  #2053c0;

                    &.active {
                    color: #09f;
    }
        }
`
