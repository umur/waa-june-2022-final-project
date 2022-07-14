import React,{useState} from 'react'

const Forgot =()=>{
    const  initialState ={password:'',confirmPassword:''}
    const [savePassword,setSavePassword]=useState(initialState);
const fieldChanged=(event)=>{
    const copyState ={...savePassword}
    copyState[event.target.name] = event.target.value
    setSavePassword(copyState);
}
const onclicked=()=>{
    console.log(savePassword)
}
    return(

        <div className='container'>
      <h2 className='text'>Enter a new password</h2>

      <div className="form-row">
          <div className="form-group col-md-6">
            <label >Password</label>
            <input
              // type="email"
              defaultValue={savePassword.password}
              name='email'
              onChange={(event)=>{fieldChanged(event)}}
              className="form-control"
              id="inputEmail4"
              placeholder="password"
            ></input>
        </div>
        <div className="form-group col-md-6">
            <label >Confirm-Password</label>
            <input
              // type="email"
              defaultValue={savePassword.confirmPassword}
              name='password'
              onChange={(event)=>{fieldChanged(event)}}
              className="form-control"
              id="inputEmail"
              placeholder="password"
            ></input>
            <br></br>
        <button type="submit" className="btn btn-primary" onClick={ onclicked}>
          Submit
        </button>
        </div>
        </div>
        <br></br>
        </div>
    )
}
export default Forgot