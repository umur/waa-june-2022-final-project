import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button } from '@mui/material';
import KeyCloakService from '../security/KeycloakService.tsx';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { styled } from "@mui/material/styles";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === "dark" ? "#1A2027" : "#fff",
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: "center",
  color: theme.palette.text.secondary,
}));

export default function Profile() {

  

 //the argument to useState will become the value to the state object in destruction
 const [state,setState]=useState({});
 const [addressState,setAddressState]=useState({});

 const url = "http://localhost:8080/students";

 const fetchStudent=async ()=>{

   await axios.get(url,{
     method:'get',
     withCredentials: false,
     params: {
       "access_token": KeyCloakService.GetToken(),
     }
   }).then(result=>{
     setState(result.data);//setting state
    setAddressState(result.data.address)
   });
     // {console.log("Principal: "+JSON.stringify(KeyCloakService.GetPrincipal()))}
     // {console.log("Token: "+JSON.stringify(KeyCloakService.GetToken()))}
 }

 useEffect(()=>{
   fetchStudent()
   .catch(function(error){console.log("Something went wrong, don't ask me what")});
 },[]);

 return (
  <Box
    component="form"
    sx={{
      '& .MuiTextField-root': { m: 1, width: '25ch' },
    }}
    noValidate
    autoComplete="off"
  >
    <Grid
        container
        rowSpacing={1}
        justifyContent="center"
        columnSpacing={{ xs: 1, sm: 2, md: 3 }}
      >
        <Grid item xs={6} justifyContent="center">
          <Item>
    <div>
      <TextField
        required
        id="outlined-required"
        defaultValue={state.firstName}
        value={state.firstName}
        onChange={(e)=>setState({...state,firstName:e.target.value})}
      />
      <TextField
        required
        id="outlined-required"
        // label="Surname"
        value={state.lastName}
        onChange={(e)=>setState({...state,lastName:e.target.value})}
      />
      <TextField
        required
        id="outlined-required"
        // label="Surname"
        value={state.email}
        onChange={(e)=>setState({...state,email:e.target.value})}
      />
<TextField
        required
        id="outlined-required"
        // label="Surname"
        value={state.username}
        
        //onChange={(e)=>setState({...state,username:e.target.value})}
      />

<TextField
        required
        id="outlined-required"
        // label="street"
        value={addressState.street}
        onChange={(e)=>setAddressState({...addressState,street:e.target.value})}
      />
      <TextField
        required
        id="outlined-required"
        // label="city"
        value={addressState.city}
        onChange={(e)=>setAddressState({...addressState,city:e.target.value})}
      />
      <TextField
        required
        id="outlined-required"
        // label="state"
        value={addressState.state}
        onChange={(e)=>setAddressState({...addressState,state:e.target.value})}
      />
      <TextField
        required
        id="outlined-required"
        // label="Zip"
        value={addressState.zip}
        onChange={(e)=>setAddressState({...addressState,zip:e.target.value})}
      />
    </div>
    <Button width="50%"  variant="text" onClick={()=>{
      delete state.address;
      state.address=addressState;
  axios({
    method: 'PUT',
    url:'http://localhost:8080/students/save-profile',
    headers: {
      'Content-Type': 'application/json'
    },
    params: {
      "access_token": KeyCloakService.GetToken(),
    },
   data:JSON.stringify(state),
   withCredentials: false
 })
}}>Submit</Button>
</Item>
        </Grid>
      </Grid>
  </Box>
); 
}


