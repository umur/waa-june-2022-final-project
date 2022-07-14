import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router";

const SignUp = () => {
  const initialState = {
    fname: "",
    lname: "",
    email: "",
    password: "",
    confirmPassword: "",
    role: "",
    major: "",
    street: "",
    city: "",
    state: "",
    zipCode: "",
  };
  const navigate = useNavigate();

  const [savePersonState, setSavePersonState] = useState(initialState);

  const [formError, setformError] = useState({});

  const [isSubmit, setIsSubmit] = useState(false);

  const onChangeField = (event) => {
    const copyState = { ...savePersonState };
    copyState[event.target.name] = event.target.value;
    setSavePersonState(copyState);
  };
  // const onChangeField = (event) => {
  //   let name = event.target.name;
  //   let value = event.target.value;
  //   let copyState = Object.assign(savePersonState);
  //   copyState[name] = value;
  //   setSavePersonState(copyState);
  // };
  const saveUserApi = (data) => {
    axios
      .post("http://localhost:8000/signups", data)
      .then(() => alert("user added"));
  };

  const onClicked = (e) => {
    console.log(savePersonState);

    const err = validate(savePersonState);
    setformError(err);
    //setformError(err);
    //  if(!err.password&&! err.email){
    if (!err.fname && !err.lname && !err.confirmPassword && !err.password) {
      saveUserApi(savePersonState);
      navigate("/siginup/register-sucess");
    } else {
      setIsSubmit(false);
    }
  };
  const validate = (value) => {
    const error = {};
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    if (!value.fname) {
      error.fname = "first name is requried";
    }
    if (!value.lname) {
      error.lname = "last name is required";
    }
    if (!value.email) {
      error.email = "email is requried";
    } else if (!regex.test(value.email)) {
      error.email = "This is not a valid email format!";
    }
    if (!value.password) {
      error.password = "password is requried";
    } else if (value.password.length < 4) {
      error.password = "password must be more than 4 characters!";
    } else if (value.password.length > 10) {
      error.password = "password must be more than 4 characters!";
    }
    // } if (!value.confirmPassword) {
    //   error.confirmPassword = "password is requried";
    // }
    else if (value.password !== value.confirmPassword) {
      // error.password="password should be the same"
      error.confirmPassword = "password don't match";
    } else if (
      value.password.length > 10 &&
      value.confirmPassword.length > 10
    ) {
      error.password = "password can't exceed more than 10 characters!";
    }
    return error;
  };

  // const onClicked = (e) => {
  //   e.preventDefault();
  //   if (
  //     savePersonState.fname !== "" &&
  //     savePersonState.lname !== "" &&
  //     savePersonState.email !== "" &&
  //     savePersonState.password !== "" &&
  //     savePersonState.confirmPassword !== ""
  //   ) {
  //     if (savePersonState.confirmPassword === savePersonState.password) {
  //       saveUserApi(savePersonState);
  //       console.log(savePersonState);
  //     } else {
  //       setformError("password shold be the same");
  //     }
  //   } else {
  //     setformError('please fill all the fields')
  //   }
  // };

  return (
    <div>
      SignUp
      <div className="container">
        <div className="holder">
          <h1 className="login">Registration Form</h1>
          <div className="form-row">
            <div className="form-group col-md-6 inputToleft">
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
            <div className="form-group col-md-6 inputToleft">
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

            <div className="form-group col-md-6 inputToleft">
              <label>Email</label>
              <input
                type="email"
                className="form-control"
                id="inputEmail4"
                placeholder="Email"
                name="email"
                defaultValue={savePersonState.email}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.email}</p>
            </div>
            <div className="form-group col-md-6 inputToleft">
              <label> Role </label>
              <br></br>
              <select
                defaultValue={"Student"}
                onChange={(event) => onChangeField(event)}
                name="role"
              >
                <option value="ROLE_STUDENT" selected>
                  Student
                </option>
                <option value="ROLE_FACULTY">Faculty</option>
                <option value="ROLE_ADMIN">Admin</option>
              </select>
            </div>
            <div className="form-group col-md-6 inputToleft">
              <label>Password</label>
              <input
                type="password"
                className="form-control"
                id="inputPassword4"
                placeholder="Password"
                name="password"
                defaultValue={savePersonState.password}
                onChange={(event) => onChangeField(event)}
              ></input>
              {/* {formError&&<div className="validation">{formError}</div>} */}
              <p className="validation">{formError.password}</p>
            </div>
            <div className="form-group col-md-6 inputToleft">
              <label>Confirm Password</label>
              <input
                type="password"
                className="form-control"
                name="confirmPassword"
                placeholder="Password"
                defaultValue={savePersonState.confirmPassword}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.confirmPassword}</p>
              {/* {formError&&<div className="validation">{formError}</div>} */}
            </div>
          </div>

          <br></br>
          <div className="input-group mb 3">
            <div className="form-group col-md-6  ">
              <label>Major</label>
              <input
                type="text"
                className="form-control"
                name="major"
                placeholder="Department"
                //defaultValue={savePersonState.fname}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.major}</p>
            </div>

            <br></br>

            <div className="form-group col-md-6 ">
              <label>Street</label>
              <input
                type="text"
                className="form-control"
                name="street"
                placeholder="street"
                //defaultValue={savePersonState.fname}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.street}</p>
            </div>
            <br></br>

            <div className="form-group col-md-6 inputToleft">
              <label>City</label>
              <input
                type="text"
                className="form-control"
                name="city"
                placeholder="city"
                //defaultValue={savePersonState.fname}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.city}</p>
            </div>
            <br></br>

            
            <div className="col-md-6 inputToleft">
              <label for="inputState" className="form-label">
                State
              </label>
              <select
              
               id="inputState" 
               className="form-select"
               name="state"
               onChange={(event) => onChangeField(event)}
               >
                <option selected>Choose State</option>
                <option>...</option>
              </select>
            </div>
            <br></br>

            <div className="form-group col-md-6">
              <label>Zip Code</label>
              <input
                type="text"
                className="form-control"
                name="zipCode"
                placeholder="zipCode"
                //defaultValue={savePersonState.fname}
                onChange={(event) => onChangeField(event)}
              ></input>
              <p className="validation">{formError.zipCode}</p>
            </div>
          </div>
          <br></br>
          <button className="btn btn-primary" onClick={onClicked}>
            SignUp
          </button>
          <div className="value">
            Already have an account? SignIn
            <Link to="/home/signin">here</Link>
          </div>
        </div>
        <br></br>
      </div>
    </div>
  );
};

export default SignUp;
