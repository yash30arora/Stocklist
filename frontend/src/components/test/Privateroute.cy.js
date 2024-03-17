import React from 'react';
import { MemoryRouter } from 'react-router-dom'; // Import MemoryRouter
import { mount } from '@cypress/react';
import Privateroute from '../Privateroute';

describe('<Privateroute />', () => {
  it('renders', () => {
    // Wrap the component in a MemoryRouter
    mount(
      <MemoryRouter>
        <Privateroute />
      </MemoryRouter>
    );
  });
});
