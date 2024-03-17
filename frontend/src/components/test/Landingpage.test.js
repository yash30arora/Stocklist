// Landingpage.test.js
import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'; // for additional matchers
import Landingpage from './Landingpage';


test('renders Landingpage component', () => {
  render(<Landingpage />);
  
  // Check if the text "𝑺𝑻𝑶𝑪𝑲𝑳𝑰𝑺𝑻𝑰𝑵𝑮" is present in the rendered component
  expect(screen.getByText(/𝑺𝑻𝑶𝑪𝑲𝑳𝑰𝑺𝑻𝑰𝑵𝑮/i)).toBeInTheDocument();
  
  // You can add more assertions based on your component's content
});

// Add more test cases as needed
