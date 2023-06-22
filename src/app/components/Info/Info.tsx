import styled from 'styled-components'
import Icon from "@mdi/react";
import { mdiInformation } from '@mdi/js'




export interface InfoProps{
    title: string
    description: string
}

export default function Info (props: InfoProps){

    return <InfoWrapper>
        <InfoInnerContent>
                <InfoIcon>
                    <Icon
                        color="#2724e9"
                        size="48px"
                        path={mdiInformation}
                   />
                </InfoIcon>

                <InfoMessages>
                    <InfoTitle>{props.title}</InfoTitle>
                    <p>{props.description}</p>
                </InfoMessages>

        </InfoInnerContent>

    </InfoWrapper>
}

const InfoWrapper = styled.div`
    padding: 24px;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f3f8fa;
    width: 373px;
`
const InfoInnerContent = styled.div`
    display: flex;
    gap: 24px;
    color: #274060;
`

export const InfoIcon = styled.div``

export const InfoMessages = styled.div`
 display: flex;
 flex-direction: column;
 gap: 24px;
 
`

export const InfoTitle = styled.h2`
    font-size: 24px;
    font-weight: 500;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    line-clamp: 1;
    overflow: hidden;
`