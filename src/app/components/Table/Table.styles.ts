import styled from 'styled-components'
import { transparentize} from 'polished'


export const Wrapper = styled.table`
    width:100%;
    color: #274060;
    background-color: ${transparentize(8.95, '#0047AB')};
`

export const Heading = styled.thead`
    background-color: ${transparentize(0.95, '#4682B4')};
`
export const HeadingRow = styled.tr``

export const HeadingCell = styled.th`
    height: 32px;
    font-size: 14px;
    padding:0 8px;
`

export const Body = styled.body`


`

export const BodyRow = styled.tr`

` 

export const BodyCell = styled.th`

    height: 40px;
    width:100%;
    font-size: 24px;
    font-weight: 500;
    padding:0 8px;
` 