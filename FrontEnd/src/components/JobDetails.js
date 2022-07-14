import React, { useEffect, useState } from 'react'
import { Button } from '@mui/material';
import Stack from '@mui/material/Stack';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';
import { useSearchParams } from 'react-router-dom';
import KeyCloakService from '../security/KeycloakService.tsx'
import axios from 'axios';

export default function JobDetails() {
  const [searchParams, setSearchParams] = useSearchParams();

  const initialState={
    description:"",
    benefits:"",
    companyName:"",
    id:"",
    address:{
      street:"",
      city:"",
      state:"",
      zip:""
    }
  }
  const[state,setState]=useState(initialState);



  const urla=`http://localhost:8080/job-applications/apply?jobId=${searchParams.get("job-id")}`;

 const applyForJob=async ()=>{

   await axios({
     url:urla,
     method:'post',
     withCredentials: false,
     params: {
      "access_token": KeyCloakService.GetToken()
    }
   }).then(result=>{
     handleClick();
   });
 }

 const fetchJob=async ()=>{

  await axios.get(`http://localhost:8080/jobs/${searchParams.get("job-id")}`,{
    method:'get',
    withCredentials: false,
    params: {
      "access_token": KeyCloakService.GetToken()
    }
  }).then(result=>{
    console.log(JSON.stringify(result))
    setState(result.data);
  });
}

useEffect(()=>{
  fetchJob();
},[]);

const Alert = React.forwardRef(function Alert(props, ref) {
  return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});
const [open, setOpen] = React.useState(false);

const handleClick = () => {
  setOpen(true);
};

const handleClose = (event, reason) => {
  if (reason === 'clickaway') {
    return;
  }

  setOpen(false);
};



  return (
    <div>
      <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
        <Alert onClose={handleClose} severity="success" sx={{ width: '100%' }}>
          Applied successfully...
        </Alert>
      </Snackbar>

      <h2>{state.description}</h2>
      <p><b>Company: </b>{state.company}</p>
      <p><b>Benefits: </b>{state.benefits}</p>
      {/* <p><b>Tags: </b>{state.company}</p> */}
      {/* <p><b>Duty Station: </b>{state.address.street}, {state.address.city}, {state.address.state}-{state.address.zip}</p> */}
      <Button onClick={applyForJob}>Apply</Button>
    </div>
  )
}
