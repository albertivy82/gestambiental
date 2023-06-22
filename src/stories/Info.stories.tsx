import type { Meta, StoryObj } from '@storybook/react';

import Info, {InfoProps} from '../app/components/Info/Info';


const meta = {
  title: 'Example/Info',
  component: Info,
  tags: ['autodocs'],
  
} satisfies Meta<typeof Info>;

export default meta;



type Story = StoryObj<typeof meta>;


export const Default: Story = {
  args: {
    title: 'Post não encontrado',
  description: 'Este post não foi encontrado. Você está sendo redirecionado(a) para a lista de posts.'
  },
};