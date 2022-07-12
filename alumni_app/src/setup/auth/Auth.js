import React, { useState } from "react";
import Cookies from 'js-cookie';

export function roleBasePermission() {
    let [userRole, setUserRole] = useState('Admin')
    switch (userRole) {
        case 'Admin':
            return 1;
        case 'Faculty':
            return 2;
        case 'Student':
            return 3;
    }
    return 0;
}

export function curentLoggedUser() {
    let [loggedUser, setLoggedUser] = useState(1);
    return loggedUser;
}

export function isAuthorized(token) {
    let [isAuthorized, setIsAuthorized] = useState(false);
    const cookies = Cookies.get('token');
    if (cookies == token) {
        setIsAuthorized(true);
    }
    else{
        setIsAuthorized(false);
    }
    return isAuthorized;
}