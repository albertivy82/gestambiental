import styled from "styled-components"
import Button from "../components/Button/Button"
import Input from "../components/Input/Input"

export default function LocalidadeForm () {
    
    return <PostFormWrapper>
      <Input
        label="Localidade"
        placeholder="e.g.: nome da localidade"
      />

      <Input
        label="Município"
        placeholder="e.g.: Município"
      />

       <Input
        label="Longitude"
        placeholder="e.g.: Longtude"
      />

       <Input
        label="Laitude"
        placeholder="e.g.: Latitude"
      />
     
      <PostFormSubmitWrapper>
        <Button variant="primary" label="Salvar post" type="submit" />
      </PostFormSubmitWrapper>
    </PostFormWrapper>
  }
  
  
  const PostFormWrapper = styled.form`
  display: flex;
  flex-direction: column;
  gap: 24px;
`

const PostFormSubmitWrapper = styled.form`
  display: flex;
  justify-content: space-between;
`