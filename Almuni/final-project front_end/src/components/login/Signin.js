import React, { useState, useEffect, useContext } from "react";
import { Link } from "react-router-dom";
import axios from 'axios'
import { useNavigate } from "react-router";
import { UserContext } from "../../context/context";

const Signin =  () => {
  const initialState = { email: "", password: "" };
  const [savePersonState, setSavePersonState] = useState(initialState);

  const state = useContext(UserContext);

  const [formError, setformError]= useState({})
  const [isSubmit, setIsSubmit]= useState()
  const [users, setUsers]= useState({})

  const {setUser}= useContext(UserContext)

const navigate = useNavigate();

  const fieldChanged = (event) => {
    const copyState = { ...savePersonState };
    copyState[event.target.name] = event.target.value;
    setSavePersonState(copyState);
  };


  // const onClicked = (e) => {
  //   e.preventDefault();
  //   if (savePersonState.email !== "" && savePersonState.password !== "") {
  //   console.log(savePersonState);
  //   setformError(validate(formError));
  //   setIsSubmit(true);
  //     } else {
  //     setformError("please fill all the fields");
  //   }
  // };

  const getUserApi= async ()=>{
    await axios.get('http://localhost:8000/signups')
    .then(d=>{
     
      d.data.forEach(d => {
        
        if(d.email === savePersonState.email){
          state.dispatch({type :"CHANGESTATE", payload: d})
          setUsers(d);
          if(d.role === 'Student'){
            navigate("/siginup/student")
          }

          else if(d.role === 'Faculty'){
            navigate("/siginup/faculty")
          }
        }
        else return 'Unauthorized user'
        return;
      });
      // setUsers(d.data)
      // console.log(users);
    })
  }
  useEffect(()=>{
    getUserApi()
  },[])

  const getUsers=()=>{
    
  }
  const onClicked = (e) => {
    console.log(savePersonState)
    // console.log(users)

    // for(let i=0;i< users.length; i++){
    //   let user= users[i]
    //   if (user.email==savePersonState.email && user.password==savePersonState.password){
    //     alert('succefull log in')

    //     setUser(user)

    //     if(user.role=='Student') {
    //       navigate('/siginup/student')
    //     }
    //     else if(user.role=='Faculty'){
    //       navigate('/siginup/faculty')
    //     }
    //     else return 'Unauthorized user'
    //     return;
    //   }

    // }
   getUserApi();
    
      // alert('Invalid credential')
  


  };
  
  useEffect(() => {
    console.log(formError);
    if (Object.keys(formError).length === 0 && isSubmit) {
      console.log(savePersonState);
    }
  }, [formError]);

  const validate = (value) => {
    const error = {};
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;
    if (!value.email) {
      error.email = "email is requried";
    } else if (!regex.test(value.email)) {
      error.email = "This is not a valid email format!";
    }

     if (!value.password) {
       error.password = "password is requried";
     }
    // } else if (value.password.length < 4) {
    //   error.password = "password must be more than 4 characters!";
    // } else if (value.password.length > 10) {
    //   error.password = "password can't exceed more than 10 characters!";
    // }
    return error;
  };

  return (
    <div className="container">
      <div className="holder">
        {Object.keys(formError).length === 0 && isSubmit ? (
          <div className="ui">Signed in successfully</div>
        ) : (
          <div className="ui"></div>
          // <pre>{JSON.stringify(savePersonState,undefined,2)}</pre>
        )}
        <h1 className="login">Login</h1>

        <div className="form-row">
          <div className="form-group col-md-6">
            <label>Email</label>
            <input
              // type="email"
              defaultValue={savePersonState.email}
              name="email"
              onChange={(event) => {
                fieldChanged(event);
              }}
              className="form-control"
              id="inputEmail4"
              placeholder="Email"
            ></input>
          </div>
          <p className="validation">{formError.email}</p>
          <div className="form-group col-md-6">
            <label>Password</label>
            <input
              type="password"
              name="password"
              defaultValue={savePersonState.password}
              onChange={(event) => {
                fieldChanged(event);
              }}
              className="form-control"
              id="inputPassword4"
              placeholder="Password"
            ></input>
          </div>
         {/* /// {formError&&<div>{formError}</div>} */}
          <p className="validation">{formError.password}</p>
          
          <div>
            <Link to="/sigin/forgot-password">ForgotPassword?</Link>
          </div>
        </div>

        <br></br>
        <button className="btn btn-primary" onClick={onClicked}>
          Sign in
        </button>
        <div className="value">
          Don't have an account? SignUp
          <Link to="/home/signup">here</Link>
        </div>
      </div>
      <br></br>
    </div>
  );
};

export default Signin;
