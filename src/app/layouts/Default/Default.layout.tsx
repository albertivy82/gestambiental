import Logo from '../../components/Logo'
import NavBar from '../../components/NavBar'
import SessionController from '../../components/SessionsController/SessionController'
import * as DL from './Default.layout.styles'

interface DefaultLayoutProps {
    children: React.ReactNode
}

function DefaultLayout (props: DefaultLayoutProps) {
    return <DL.Warapper>
            <DL.Header>
                <Logo />
            </DL.Header>

            <DL.main>

                <DL.Navigation>
                    <NavBar/>
                </DL.Navigation>
                
                <DL.FeaturedContent>
                    {props.children}
                </DL.FeaturedContent>
               
                <DL.Aside>
                    <SessionController

                    nome='Albert Pereira'
                    description='perfil'
                    
                    />
                </DL.Aside>

            </DL.main>



    </DL.Warapper>
}

export default DefaultLayout