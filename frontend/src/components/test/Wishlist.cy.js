import React from 'react';
import { MemoryRouter } from 'react-router-dom'; // Import MemoryRouter
import { mount } from '@cypress/react';
import Wishlist from '../Wishlist';

describe('<Wishlist />', () => {
  it('renders', () => {
    // Wrap the component in a MemoryRouter
    mount(
      <MemoryRouter>
        <Wishlist />
      </MemoryRouter>
    );
  });
});
