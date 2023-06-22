import type { Meta, StoryObj } from '@storybook/react';

import Confirm, { ConfirmProps } from '../app/components/Confirm/Confirm';


const meta = {
  title: 'Example/Confirm ',
  component: Confirm,
  tags: ['autodocs'],
  
} satisfies Meta<typeof Confirm >;

export default meta;



type Story = StoryObj<typeof meta>;

export const Default: Story = {
    args: {
      title: 'Você tem certeza?',
    },
  };
