import * as React from "react";
import { Button, Grid, TextField, Stack, Avatar, Box } from "@mui/material";
import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import KeyCloakService from "../security/KeycloakService.tsx";
import axios from "axios";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';

// import { useFormik } from "formik";
// import * as yup from "yup";

export default function AddExperiance() {
  const [state, setState] = useState({});

  const initialExperience=[{
    companyName:"",
    startDate:"",
    finishDate:"",
    description:""
  }]
  const[experience,setExperience]=useState(initialExperience);

  const fetchExperience=async ()=>{

    await axios({
      method:'get',
      url:`http://localhost:8080/students/experience`,
      withCredentials: false,
      params: {
        "access_token": KeyCloakService.GetToken()
      }
    }).then(result=>{
      console.log(JSON.stringify(result))
      setExperience(result.data);
    });
  }
  
  useEffect(()=>{
    fetchExperience();
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
    <Box
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <div>
        <TextField
          required
          id="outlined-required"
          label="Company Name"
          //   defaultValue="company name"
          onChange={(e) => setState({ ...state, companyName: e.target.value })}
        />
        <TextField
          required
          id="outlined-required"
          //label="Start Date"
          type="date"
          //   value={state.lastName}
          onChange={(e) => setState({ ...state, startDate: e.target.value })}
        />
        <TextField
          required
          id="outlined-required"
          //   label="finishDate"
          type="date"
          //   value={state.email}
          onChange={(e) => setState({ ...state, finishDate: e.target.value })}
        />
        <TextField
          required
          id="outlined-required"
          label="description"
          //   value={state.username}

          onChange={(e) => setState({ ...state, description: e.target.value })}
        />
      </div>
      <Button
        variant="text"
        onClick={() => {
          axios({
            method: "Post",
            url: "http://localhost:8080/students/add-experience",
            headers: {
              "Content-Type": "application/json",
            },
            params: {
              access_token: KeyCloakService.GetToken(),
            },
            data: JSON.stringify(state),
            withCredentials: false,
          }).then(result=>{
            fetchExperience();
          });
        }}
      >
        Add Experience
      </Button>


      <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Company</TableCell>
            <TableCell>Start</TableCell>
            <TableCell>End</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Action</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>

          {
          
          experience?.map((row) => (
            <TableRow
              key={row.name}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell>{row.companyName}</TableCell>
              <TableCell>{row.startDate}</TableCell>
              <TableCell>{row.finishDate}</TableCell>
              <TableCell>{row.description}</TableCell>
              <TableCell>
              <TableCell><Button onClick={()=>{
                  axios({
                    method: "Delete",
                    url: `http://localhost:8080/students/delete-experience/?experienceId=${row.id}`,
                    params: {
                      access_token: KeyCloakService.GetToken()
                    },
                    withCredentials: false,
                  }).then(result=>{
                    handleClick();
                    fetchExperience();
                  });
              }}>Delete</Button></TableCell>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
        <Alert onClose={handleClose} severity="error" sx={{ width: '100%' }}>
          Experience Deleted!!!
        </Alert>
      </Snackbar>
    </Box>
  );
}