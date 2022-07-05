import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import HomePage from './pages/dashboard/HomePage';

function App() {
  return (
    <BrowserRouter>
      {/* <RouteApp></RouteApp> */}
      <HomePage></HomePage>
    </BrowserRouter>
  );
}

export default App;
