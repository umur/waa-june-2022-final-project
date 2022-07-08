import logo from './logo.svg';
import './App.css';
import Router from './pages/Router';
import Footer from './components/Footer';
import { BrowserRouter } from 'react-router-dom';
import Header from './components/header';


function App() {
  return (
    <div className="container">
      <BrowserRouter>
        <Header></Header>
        <Router></Router>
        <Footer></Footer>
      </BrowserRouter>
    </div>
  );
}

export default App;
