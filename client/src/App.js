import logo from './logo.svg';
import Main from "./components/dashboard/Main";
import './App.css';
import Router from './pages/Router';
import Footer from './components/Footer';
import { BrowserRouter } from 'react-router-dom';
import Header from './components/header';

import Router from "./pages/Router";
import Footer from "./components/Footer";
import { BrowserRouter } from "react-router-dom";
import Registration from "./pages/faculty/Registration";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Header></Header>
        <Router></Router>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
