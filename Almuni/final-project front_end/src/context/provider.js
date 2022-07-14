import { UserProvider } from './context';
import App from "../App";
import React from 'react';

export default function Provider() {
    return (
        
        <UserProvider>
            <App/>
         </UserProvider>   
    )
}