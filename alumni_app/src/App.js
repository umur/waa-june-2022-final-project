import React, { createContext, useState } from 'react';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import RouteApp from './setup/routes-manager/RouteApp';
import RoutePermited from './setup/routes-manager/RoutePermited';
import Navbar from './common/Navbar';
import Cookies from 'js-cookie';

export const AUTHCONTEXT = createContext();

function App() {
  const [auth, setAuth] = useState();
  if (auth == undefined && auth != "undefined") {
    const cookies = Cookies.get('token');
    if (cookies != undefined && cookies != "undefined") {
      setAuth(true);
    }
  }
  return (
    <AUTHCONTEXT.Provider value={{ auth, setAuth }}>
      <BrowserRouter>
        {(auth == undefined ?
          <div className='body-custom'>
            <RoutePermited></RoutePermited>
          </div>
          :
          <>
            <Navbar></Navbar>
            <div className='body-custom'>
              <RouteApp></RouteApp>
            </div>
          </>
        )}
      </BrowserRouter>
    </AUTHCONTEXT.Provider>
  );
}

export default App;
