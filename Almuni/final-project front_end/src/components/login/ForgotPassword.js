import React,{useState} from 'react'
import { useNavigate } from 'react-router';


const ForgotPassword = () => {
 
    const  initialState ={email:''}
    const [savePassword,setSavePassword]=useState(initialState);

const fieldChanged=(event)=>{
    const copyState ={...savePassword}
    copyState[event.target.name] = event.target.value
    setSavePassword(copyState);
}
const navigate = useNavigate();
const onclicked=()=>{
    console.log(savePassword)
    navigate("/home/forget-password-reset");
}
    return(

        <div className='container'>
      <h2 className='text'>Enter your email password</h2>

      <div className="form-row">
          <div className="form-group col-md-6">
            <label >Email</label>
            <input
              // type="email"
              defaultValue={savePassword.email}
              name='email'
              onChange={(event)=>{fieldChanged(event)}}
              className="form-control"
              id="inputEmail4"
              placeholder="password"
            ></input>
        </div>
      
            <br></br>
        <button type="submit" className="btn btn-primary" onClick={ onclicked}>
          Submit
        </button>
        
        </div>
        <br></br>
        </div>
  )
}

export default ForgotPassword