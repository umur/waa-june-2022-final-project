import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import HomePage from './pages/dashboard/HomePage';
import RouteApp from './setup/routes-manager/RouteApp';
import Navbar from './common/Navbar';
import { Container } from '@material-ui/core';

function App() {
  return (
    <BrowserRouter>
      <Navbar></Navbar>
      <Container>
        <RouteApp></RouteApp>
      </Container>

    </BrowserRouter>
  );
}

export default App;
