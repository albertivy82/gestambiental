import axios from 'axios';
import qs from 'qs';
import pkceChallenge from 'pkce-challenge';




const authServer = axios.create({
    baseURL: 'http://localhost:8080'
})

export interface OAuthAuthorizationTokenResponse {
    access_token: string;
    refresh_token: string;
    scope: string;
    token_type: 'bearer' | string;
    expires_in: number;
   [key: string]: string | number;
}


export default class AuthService {
  public static async getFirstAccessToken(conf: {
    code: string;
    codeVerifier: string;
    redirectUri: string;
    state: string;
  }) {

    console.log(12312414)
    const data = {
        grant_type: 'authorization_code',
        code: conf.code,
        redirect_uri: conf.redirectUri,
        code_verifier: conf.codeVerifier,
        state: conf.state
    }
    
    const encodedData = qs.stringify(data)

   console.log(data)

    return authServer.post<OAuthAuthorizationTokenResponse>('/oauth2/token', encodedData, {
      
     headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
     auth:{
        username:'gestambiental',
        password:'abcef'
      }
    }).then(res => res.data)
    }

   public static getLoginScreenUrl (codeChallenge: string){


      const config = qs.stringify({

            response_type: 'code',
            client_id:'gestambiental',
            state:'abdef',
            redirect_uri: 'http://127.0.0.1:3000/authorize',
            scope: 'READ WRITE',
            code_challenge: codeChallenge,
            code_challenge_method: 'S256'
           //o redirect uri é o que está registrado

        })

   
      
      return `http://127.0.0.1:8080/oauth2/authorize?${config}`

    }

    public static async imperativelySendToLoginScreen(){

        
      const { code_challenge, code_verifier } = await pkceChallenge(128);
      console.log("primeiro par => " + code_challenge + " ******* " + code_verifier)
      this.setCodeVerifier(code_verifier);
          
            
      const loginUrl = this.getLoginScreenUrl(code_challenge)
                    
     
      window.location.href = loginUrl
      
    
    }
    
      public static getAccessToken() {
        return window.localStorage.getItem('accessToken')
      }

      public static setAccessToken(token: string) {
        return window.localStorage.setItem('accessToken', token)
      }
    
      public static getRefreshToken() {
        return window.localStorage.getItem('refreshToken')
      }

      public static setRefreshToken(refreshToken: string) {
        return window.localStorage.setItem('refreshToken', refreshToken)
      }
    
      
      public static getCodeVerifier() {
        return window.localStorage.getItem('codeVerifier');
      }

      public static setCodeVerifier(codeVerifier: string) {
        
        return window.localStorage.setItem('codeVerifier', codeVerifier);
       
      }
}