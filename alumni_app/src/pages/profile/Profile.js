import React from "react";
import { Container, TextField, Box, Grid } from "@material-ui/core";
import Avatar from "@mui/material/Avatar";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";

import "./style.css";

import axios from "axios";
import { useState, useEffect } from "react";

const Profile = () => {
  let initialState = {
    user: {
      firstName: "Sudip",
      lastName: "Adhikari",
      email: "sudip@test.com",
      gpa: 3.5,
      lastLoggedInAt: "2022/6/17",
      active: true,
    },
  };

  const [userState, setUserState] = useState(initialState);

  const fetchData = async () => {
    let response = await axios.get("/todo");
    setUserState((initialState.user = response.data));
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleInputChange = () => {
    console.log("form changed");
  };

  return (
    <>
      <Container maxWidth="sm">
        <Paper elevation={3} className="profile-paper">
          <Grid item xs={12} alignContent="center" className="profile-img">
            <Avatar
              alt="User Profile"
              src="/images/profile-imagejpg.jpg"
              sx={{ width: 200, height: 200 }}
            />
          </Grid>

          <TextField
            required
            id="firstname"
            label="First Name"
            defaultValue={userState.user.firstName}
            fullWidth
          />

          {/* <TextField
            id="outlined-password-input"
            label="Password"
            type="password"
            autoComplete="current-password"
            fullWidth
          /> */}

          <TextField
            required
            id="lastname"
            label="Last Name"
            defaultValue={userState.user.lastName}
            fullWidth
          />

          <TextField
            required
            id="email"
            label="Email"
            defaultValue={userState.user.email}
            fullWidth
          />

          <TextField
            required
            id="gpa"
            label="GPA"
            type="number"
            defaultValue={userState.user.gpa}
            fullWidth
          />

          <Button variant="contained" fullWidth>
            Edit
          </Button>
        </Paper>
      </Container>
    </>
  );
};

export default Profile;
