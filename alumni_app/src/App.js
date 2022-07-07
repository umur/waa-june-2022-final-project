import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import RouteApp from './setup/routes-manager/RouteApp';
import Navbar from './common/Navbar';

function App() {
  return (
    <BrowserRouter>
      <Navbar></Navbar>
      <div className='body-custom'>
        <RouteApp></RouteApp>
      </div>

    </BrowserRouter>
  );
}

export default App;
