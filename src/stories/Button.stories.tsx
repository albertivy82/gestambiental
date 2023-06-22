import type { Meta, StoryObj } from '@storybook/react';

import Button, {ButtonProps} from '../app/components/Button/Button';


const meta = {
  title: 'Example/Button',
  component: Button,
  tags: ['autodocs'],
  
} satisfies Meta<typeof Button>;

export default meta;



type Story = StoryObj<typeof meta>;



export const Primary: Story = {
  args: {
    variant: 'primary',
    label: 'Button',
  },
};

export const Danger: Story = {
  args: {
    variant: 'danger',
    label: 'Button',
  },
};

export const Disable: Story = {
  args: {
    variant: 'primary',
    disabled: true,
    label: 'resetar senha',
  },
};


