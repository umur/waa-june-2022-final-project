import React, { useState } from "react";


export function RoleBasePermission() {
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

export function CurentLoggedUser() {
    let [loggedUser, setLoggedUser] = useState(1);
    return loggedUser;
}