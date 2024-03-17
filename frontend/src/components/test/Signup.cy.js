import React from 'react';
import { MemoryRouter } from 'react-router-dom'; // Import MemoryRouter
import { mount } from '@cypress/react';
import Signup from '../Signup';

describe('<Signup />', () => {
  it('renders', () => {
    // Wrap the component in a MemoryRouter
    mount(
      <MemoryRouter>
        <Signup />
      </MemoryRouter>
    );
  });
});
