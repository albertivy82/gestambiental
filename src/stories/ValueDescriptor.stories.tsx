import type { Meta, StoryObj } from '@storybook/react';
import ValueDescriptor, { ValueDescriptorProps } from '../app/components/ValueDescriptor/ValueDescriptor';


const meta = {
  title: 'Example/ValueDescriptor',
  component: ValueDescriptor,
  tags: ['autodocs'],
  
} satisfies Meta<typeof ValueDescriptor>;

export default meta;



type Story = StoryObj<typeof meta>;


export const Default: Story = {
  args: {
    description: 'Ganhos na semana',
    value: 560322.02,
    color: 'default'
  },
};


export const DefaultCurrency: Story = {
  args: {
    description: 'Ganhos na semana',
    value: 560322.02,
    isCurrency: true,
    color: 'default'
  },
};

export const Primary: Story = {
  args: {
    description: 'Ganhos na semana',
    value: 560322.02,
    isCurrency: false,
    color: 'primary'
  },
};

export const PrimaryCurrency: Story = {
  args: {
    description: 'Ganhos na semana',
    value: 560322.02,
    isCurrency: true,
    color: 'primary'
  },
};