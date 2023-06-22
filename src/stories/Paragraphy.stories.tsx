import type { Meta, StoryObj } from '@storybook/react';

import Paragraphy, {ParagraphProps} from '../app/components/Typography/Paragraphy';


const meta = {
  title: 'Typography/Paragraphy',
  component: Paragraphy,
  tags: ['autodocs'],
  
} satisfies Meta<typeof Paragraphy>;

export default meta;



type Story = StoryObj<typeof meta>;


export const Default: Story = {
  args: {
        size: 'default',
        children: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit ut aliquam, purus sit amet luctus venenatis, lectus magna fringilla urna, porttitor rhoncus dolor purus non enim praesent elementum facilisis leo, vel'
      
  },
};

export const Small: Story = {
  args: {
    size: 'small',
    children: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit ut aliquam, purus sit amet luctus venenatis, lectus magna fringilla urna, porttitor rhoncus dolor purus non enim praesent elementum facilisis leo, vel'

  },
};


