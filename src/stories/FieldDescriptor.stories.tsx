import type { Meta, StoryObj } from '@storybook/react';

import FieldDescriptor, {FieldDescriptorProps} from '../app/components/FieldDecriptor/FieldDescriptor';


const meta = {
  title: 'Example/FieldDescriptor',
  component: FieldDescriptor,
  tags: ['autodocs'],
  
} satisfies Meta<typeof FieldDescriptor>;

export default meta;



type Story = StoryObj<typeof meta>;

export const Default: Story = {
    args: {
      field: 'Data de Nascimento',
      value: '04 de setembro de 1982 (40 anos)',
    },
  };
