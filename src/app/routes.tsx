import { Route, Routes } from "react-router-dom";
import LocalidadeView from "./views/Localidade.view";
import LocalidadeEdtion from "./views/LocalidadeEdition.view";
import { notification } from 'antd';
import UsuarioView from "./views/User.View";
import UserEdtion from "./views/UsuarioEdition.view";
import NotFound404 from "./views/NotFound404.view";
import { useEffect } from 'react';
import AuthService from "../auth/Authorization.service";
import { useNavigate } from 'react-router-dom';


export default function Routex() {
 
 const navigate = useNavigate();
 
  useEffect(() => {
    
     async function identify () {
     
     
      const isInAuthorizationRoute = window.location.pathname === '/authorize'
      const code = new URLSearchParams(window.location.search).get('code')
      
      
      const codeVerifier = AuthService.getCodeVerifier()
      const accessToken = AuthService.getAccessToken()
      
    

      if (!accessToken && !isInAuthorizationRoute) {
        
      
        
       AuthService.imperativelySendToLoginScreen()
      
    }

    
    

     
     
      if (isInAuthorizationRoute) {
            
        if (!code) {
           
                notification.error({
                  message: 'Código não foi informado'
                })
                return;
              }

              
              if (!codeVerifier) {
                
                // necessario fazer logout
                return;
              }
        
            
            
        const { access_token, refresh_token } = await AuthService.getFirstAccessToken({
         
          code,
          codeVerifier,
          redirectUri: `http://127.0.0.1:3000/authorize`,
          state:'abdef'

          
        })
       
        console.log("4")  
        
        AuthService.setAccessToken(access_token)
      
        AuthService.setRefreshToken(refresh_token)

        console.log("10")  
        
        navigate('/');
       
      }
      
    }
    
    identify()
  }, [])
    
  
    
    return (<Routes>
    <Route path="/" element={<LocalidadeView/>} />
    <Route path="/localidade-edição" element={<LocalidadeEdtion/>} />
    <Route path="/usuarios" element={<UsuarioView/>} />
    <Route path="/usuarios-edição" element={<UserEdtion/>} />
    <Route path='*' element={<NotFound404/>} />
    </Routes>
    );  

    
}


