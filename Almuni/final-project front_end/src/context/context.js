import React, {createContext,  useState, useReducer} from "react";


export const UserContext = createContext();

export const intailState =  {
    id:'',
    fname: "",
    lname: "",
    email: "",
    password: "",
    confirmPassword: "",
    role: "",
    major: "",
    street: "",
    city:"",
    state: '',
    zipCode: '',
    jobAdvertisment: [],
   appliedJob: []
}

export const myReducer = (state = intailState, action) => {
    switch(action.type) {
       case "LOGIN" :
        return {...state, token: action.payload};
      case 'LOGOUT' : 
       return {...state, token: null};
      case "LNAME" : 
      return {...state, lname: action.payload};
      case 'EMAIL' :
        return {...state, email: action.payload};
      case "CHANGESTATE"  : 
        return {...state, 
            id: action.payload.id,
            fname: action.payload.fname,
            lname: action.payload.lname,
            email: action.payload.email,
            password: action.payload.password,
            role:action.payload.role,
            major:action.payload.major,
            street:action.payload.street,
            city:action.payload.city,
            state:action.payload.state,
            zipCode:action.payload.zipCode };
        case 'ROLE' :
            return {...state, role: action.payload}
    }
}

export const UserProvider = ({children}) => {
    const [state, dispatch] = useReducer(myReducer, intailState);

    return (
        <UserContext.Provider value = {{ state,  dispatch}}>
            {children}
        </UserContext.Provider>
    )
}