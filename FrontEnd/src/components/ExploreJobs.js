import React from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState } from 'react';
import KeyCloakService from '../security/KeycloakService.tsx';
import axios from 'axios';
import { useEffect } from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { Box } from '@mui/system';
import {Button} from '@mui/material';
import { TextField } from '@mui/material';
import { Link } from 'react-router-dom';

export default function ExploreJobs() {

    const initialState=[];
    const [state,setState]=useState(initialState);
    const initialAddress=[];
 const [addressState,setAddressState]=useState(initialAddress);
const [searchString,setSearchString]=useState("");


 const url = "http://localhost:8080/jobs/filter";

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
 useEffect(()=>{
  },[state]);

 const [filter, setFilter] = React.useState('');

 const handleChange = (event) => {
   setFilter(event.target.value);
 };

 return (
<Box>
<FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">Filter:</InputLabel>
        <Select width="10%"
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          label="Filter"
          onChange={(e)=>setFilter({...filter,criteria:e.target.value})}
        >
          <MenuItem value={"City"}>City</MenuItem>
          <MenuItem value={"State"}>State</MenuItem>
          <MenuItem value={"caompany"}>Company</MenuItem>
          <MenuItem value={"Tag"}>Tags</MenuItem>
        </Select>
      </FormControl>
      <TextField
        required
        id="outlined-required"
        // label="Surname"
        defaultValue=""
        onBlur={(e)=>setSearchString({...searchString,searchValue:e.target.value})}
      />
      <Button width="50%"  variant="text" onClick={()=>{
    console.log(searchString)
    console.log(filter)
      delete state.address;
      state.address=addressState;
  axios({
    method: 'get',
    url:`http://localhost:8080/jobs/filter/?${filter.criteria}=${searchString.searchValue}`,
    headers: {
      'Content-Type': 'application/json'
    },
    params: {
      "access_token": KeyCloakService.GetToken()
      
    },
   data:JSON.stringify(state),
   withCredentials: false
 }).then(result=>{
    setState(result.data)
 })
}}>Submit</Button>
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell>Company</TableCell>
            <TableCell>Benefits</TableCell>
            <TableCell>Address</TableCell>
            <TableCell>Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>

          {
          
          state?.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell>{row.description}</TableCell>
              <TableCell>{row.companyName}</TableCell>
              <TableCell>{row.benefits}</TableCell>
              <TableCell>{row.address.state}</TableCell>
              <TableCell><Link to={`/JobDetails?job-id=${row.id}`}> Detials</Link></TableCell>
            </TableRow>
          ))}
          
        </TableBody>
      </Table>
    </TableContainer>
    </Box>
  );
}