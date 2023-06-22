import styled from 'styled-components'
import NotFound from '../../assets/NotFound.png'
import Button from '../components/Button/Button'
import { Link } from 'react-router-dom'

export default function NotFound404 () {
    
  
    return <NotFound404Wrapper>
      <span>
        404
      </span>
      <h1>Recurso Não Encontrado</h1>
      <img src={NotFound} alt="Não encontrado" />
      <Link to="/">
         <Button  variant="primary" label="Ir para a home" />  
       </Link>
    </NotFound404Wrapper>
  }


  
  const NotFound404Wrapper = styled.div`
    min-height: 80vh;
  
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  
    gap: 32px;
  
    span {
      font-size: 72px;
    }
  
    h1 {
      font-size: 18px;
      font-weight: 400;
    }
    
  `