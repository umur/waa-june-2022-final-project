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
      files: "/images/profile-imagejpg.jpg",
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

  const handleImageUpload = (event) => {
    console.log("Image is changed " + event.target.files[0]);
  };

  return (
    <>
      <Container maxWidth="sm">
        <Paper elevation={3} className="profile-paper">
          <Grid item xs={12} alignContent="center" className="profile-img">
            <Avatar
              alt="User Profile"
              src={userState.user.files}
              sx={{ width: 200, height: 200 }}
            />
            {/* onChange={} */}
          </Grid>
          <div className="file-upload">
            <Button variant="contained" component="label">
              Choose File
              <input
                type="file"
                hidden
                name="image"
                onChange={handleImageUpload}
              />
            </Button>
          </div>
          <Grid container spacing={3}>
            <Grid item xs={12} sm={12}>
              <TextField
                required
                id="firstname"
                label="First Name"
                defaultValue={userState.user.firstName}
                fullWidth
              />
            </Grid>
          </Grid>
          <Grid container spacing={3}>
            <Grid item xs={12} sm={12}>
              <TextField
                required
                className="text-field"
                id="lastname"
                label="Last Name"
                defaultValue={userState.user.lastName}
                fullWidth
              />
            </Grid>
          </Grid>

          <Grid container spacing={3}>
            <Grid item xs={12} sm={12}>
              <TextField
                required
                className="text-field"
                id="email"
                label="Email"
                defaultValue={userState.user.email}
                fullWidth
              />
            </Grid>
          </Grid>

          <Grid container spacing={3}>
            <Grid item xs={12} sm={12}>
              <TextField
                required
                className="text-field"
                id="gpa"
                label="GPA"
                type="number"
                defaultValue={userState.user.gpa}
                fullWidth
              />
            </Grid>
          </Grid>

          <Button variant="contained" fullWidth className="text-field">
            Edit
          </Button>
        </Paper>
      </Container>
    </>
  );
};

export default Profile;
