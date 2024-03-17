// Import the necessary modules
import React from 'react';
import { MemoryRouter } from 'react-router-dom';
import { mount } from '@cypress/react';
import Landingpage from '../Landingpage';

describe('<Landingpage />', () => {
  it('renders', () => {
    // Wrap the component in a MemoryRouter
    mount(
      <MemoryRouter>
        <Landingpage />
      </MemoryRouter>
    );
  });
});
