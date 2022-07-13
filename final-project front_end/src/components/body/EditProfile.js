import React, { useContext, useState } from 'react'
import { UserContext } from '../../context/context'
import { Link } from "react-router-dom";
import axios from "axios";

import { useNavigate } from "react-router";

export const EditProfile = () => {
    //const {user, setUser}=  useContext(UserContext)
    const store = useContext(UserContext);

    const user= store.state

    const initialState = {
        fname: user.fname,
        lname: user.lname,
        street: user.street,
        city: user.city,
        state: user.state,
        zipCode: user.zipCode,

    
    email: user.email,
    password: user.password,
    confirmPassword: user.confirmPassword,
    role: user.role,
    major: user.major,
    
        
      };
    const navigate=useNavigate();
    
      const [savePersonState, setSavePersonState] = useState(initialState);
    
      const [formError, setformError] = useState({});
    
      const [isSubmit, setIsSubmit] = useState(false);
    
      // const onChangeField=(event)=>{
      //     const copyState ={... savePersonState}
      //     copyState [event.target.name]=event.target.value;
      //     setSavePersonState(copyState);
      // }
      const onChangeField = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        let copyState = Object.assign(savePersonState);
        copyState[name] = value;
        setSavePersonState(copyState);
      };
      const saveUserApi = (data) => {
        console.log(user.id)
        axios
          .put("http://localhost:8000/signups/"+user.id, data)
          .then(() => {
            //setUser(data)
            store.dispatch({type :"CHANGESTATE", payload: data})

            setSavePersonState(data)
            alert("user info updated!");

        
        })
          .catch(err=> console.log(err))
          ;
      };
    
      const onClicked = (e) => {
    
        
        const err= (validate(savePersonState))
        setformError(err);
         //setformError(err);
        //  if(!err.password&&! err.email){

        if(!err.fname&& !err.lname&&!err.confirmPassword&&!err.password){


            savePersonState.id= user.id
            saveUserApi(savePersonState)
          //navigate( "/siginup/register-sucess")
         }else{ 
  
          setIsSubmit(false)
         }     
    };
      const validate = (value) => {
        const error = {};
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
        if(!value.fname){
          error.fname="first name is requried"
        }
        if(!value.lname){
          error.lname="last name is required"
        }
        
        
        
       
        return error;
      };
    
      
    
      return (
        <div>
          <div className="container">
            <div className="holder">
              <h1 className="login">Edit Student Profile</h1>
                <div className="form-group col-md-6">
                  <label>FirstName</label>
                  <input
                    type="text"
                    className="form-control"
                    name="fname"
                    placeholder="First Name"
                    defaultValue={savePersonState.fname}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.fname}</p>
                </div>
                <div className="form-group col-md-6">
                  <label>Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="lname"
                    placeholder="Last Name"
                    defaultValue={savePersonState.lname}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.lname}</p>
                </div>
    
    
              

              <div className="form-group col-md-6">
                <label> Role </label>
                <br></br>
                <select
                  defaultValue={'Student'}
                  onChange={(event) => onChangeField(event)}
                  name="role"
                >
                  <option value="Student">Student</option>
                  <option value="Faculty">Faculty</option>
                </select>
              </div>
    
              <br></br>
    

    
        
    
                <div className="form-group col-md-6">
                  <label>Street</label>
                  <input
                    type="text"
                    className="form-control"
                    name="street"
                    placeholder="street"
                    defaultValue={savePersonState.street}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.street}</p>
                </div>
                <br></br>
    
    
                <div className="form-group col-md-6">
                  <label>City</label>
                  <input
                    type="text"
                    className="form-control"
                    name="city"
                    placeholder="city"
                    defaultValue={savePersonState.city}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.city}</p>
                </div>
                <br></br>
    
                <div className="form-group col-md-6">
                  <label>State</label>
                  <input
                    type="text"
                    className="form-control"
                    name="state"
                    placeholder="state"
                    defaultValue={savePersonState.state}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.state}</p>
                </div>
                <br></br>
    
                <div className="form-group col-md-6">
                  <label>Zip Code</label>
                  <input
                    type="text"
                    className="form-control"
                    name="zipCode"
                    placeholder="zipCode"
                    defaultValue={savePersonState.zipCode}
                    onChange={(event) => onChangeField(event)}
                  ></input>
                   <p className="validation">{formError.zipCode}</p>
                </div>
              <br></br>
              <button className="btn btn-primary" onClick={(e)=> onClicked(e)}>
                Edit
              </button>
            
    
              <br></br>
            </div>
          </div>
        </div>
      );
}
