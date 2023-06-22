import styled from "styled-components"


export const Warapper = styled.div`

    width: 100%;
    margin: 0 auto;

    display: flex;
    flex-direction: column;
    gap: 16p;
`

export const Header = styled.header`

    display: flex;
    justify-content: center;
    align-items: center;
    background-color:#abcdf0;
    width: 100%;
    height: 64px;
`
export const main = styled.main`

    display:grid;
    grid-template-columns: 214px 1000px 214px;
    justify-content: center;
    gap:30px;
`

export const Navigation = styled.nav`
 display: flex;
  padding-right: 32px;
  justify-content: flex-end;

`

export const Aside = styled.aside`


`

export const FeaturedContent = styled.section`
  display: flex;
  flex-direction: column;
  gap: 32px;
  padding-bottom: 32px;
`