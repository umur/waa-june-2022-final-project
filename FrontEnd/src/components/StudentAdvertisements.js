import * as React from 'react';
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

export default function StudentAdvertisements() {

    const initialState=[];

    const [jobs,setJobs]=useState(initialState);

    const url = "http://localhost:8080/jobs";
   
    const fetchJobs=async ()=>{
   
      await axios.get(url,{
        method:'get',
        withCredentials: false,
        params: {
          "access_token": KeyCloakService.GetToken(),
        }
      }).then(result=>{
        
        setJobs(result.data);
        console.log(jobs)
      });
    }
   
    useEffect(()=>{
      fetchJobs()
      .catch(function(error){console.log("Something went wrong, don't ask me what")});
    },[]);

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell align="right">Company</TableCell>
            <TableCell align="right">Benefits</TableCell>
            <TableCell align="right">State</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>

          {
           
          jobs?.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.name}
              </TableCell>
              <TableCell align="right">{row.description}</TableCell>
              <TableCell align="right">{row.companyName}</TableCell>
              <TableCell align="right">{row.benefits}</TableCell>
              <TableCell align="right">{row.state}</TableCell>
            </TableRow>
          ))}
          
        </TableBody>
      </Table>
    </TableContainer>
  );
}
