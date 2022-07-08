import React from "react";
import { Container, TextField, Box, Grid } from "@material-ui/core";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";

const ChangePassword = () => {
  return (
    <>
      <Container maxWidth="sm">
        <Paper elevation={3} className="profile-paper">
          <TextField
            required
            id="currentPassword"
            type="password"
            label="Current Password"
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
            id="newPassword"
            type="password"
            label="New Password"
            fullWidth
          />

          <TextField
            required
            id="confirmPasword"
            label="Confirm Password"
            fullWidth
          />

          <Button variant="contained" fullWidth>
            Reset Password
          </Button>
        </Paper>
      </Container>
    </>
  );
};

export default ChangePassword;
