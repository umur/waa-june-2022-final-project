import { BrowserRouter } from 'react-router-dom';
import './App.css';
import HomePage from './pages/dashboard/HomePage';
import Header from './pages/dashboard/Header';
import RouteApp from './setup/routes-manager/RouteApp';

function App() {
  return (
    <BrowserRouter>
      {/* <RouteApp></RouteApp> */}
      <HomePage></HomePage>
    </BrowserRouter>
  );
}

export default App;
