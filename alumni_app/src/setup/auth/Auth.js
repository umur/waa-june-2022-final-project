import React, { useState } from "react";


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

export function isAuthorized() {
    let [isAuthorized, setIsAuthorized] = useState(false);
    return isAuthorized;
}