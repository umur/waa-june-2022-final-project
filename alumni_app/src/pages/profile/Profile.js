import React from "react";
import { Container, TextField, Box, Grid } from "@material-ui/core";
import Avatar from "@mui/material/Avatar";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import InputLabel from "@mui/material/InputLabel";
import FileUpload from "../../common/FileUpload";
import "./style.css";
import { useState, useEffect } from "react";
import { getRequest, putRequest } from "../../setup/fetch-manager/FetchGateway";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";
import { useNavigate } from "react-router";
import Cookies from "js-cookie";

const Profile = () => {
  const navigate = useNavigate();
  const id = Cookies.get("id");
  let initialValues = {
    username: "Sudip",
    image: "",
    active: true,
    files: "/images/profile-imagejpg.jpg",
  };

  const [userState, setUserState] = useState();
  const [values, setValues] = useState(initialValues);

  const fetchUser = async () => {
    let response = await getRequest("/auth/get/" + id);
    setUserState(response);
    console.log(userState);
  };

  useEffect(() => {
    fetchUser();
  }, []);

  const getUrl = (e) => {
    if (e != undefined) {
      let urlfilePath = "";
      urlfilePath = e;
      setValues({
        ...values,
        jobDescFilePath: urlfilePath,
      });
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    console.log(e.target);
    setValues({
      ...values,
      [name]: value,
    });
  };

  const postData = async () => {
    let params = "/auth/profile";
    let result = await putRequest(params, values);
    navigate("/Jobs");
  };

  const handleButtonClick = () => {
    postData();
  };

  return (
    <>
      <Container maxWidth="sm">
        <Paper elevation={3} className="profile-paper">
          {userState != null ? (
            <div>
              <Grid item xs={12} alignContent="center" className="profile-img">
                <Avatar
                  alt="User Profile"
                  src="../../../public/Profile/1/miu-group-photo.png"
                  sx={{ width: 200, height: 200 }}
                />
              </Grid>
              <Grid item xs={12} className="file-upload">
                <>
                  <InputLabel id="jobDetailsDoc">
                    Upload Profile Image
                  </InputLabel>
                  <br />
                  <FileUpload
                    folderName="Profile"
                    id={1}
                    getUrl={getUrl.bind(this)}
                  ></FileUpload>
                </>
              </Grid>
              <Grid container spacing={3}>
                <Grid item xs={12} sm={12}>
                  <TextField
                    required
                    id="username"
                    name="username"
                    label="User Name"
                    defaultValue={userState.username}
                    onChange={handleInputChange}
                    fullWidth
                  />
                </Grid>
              </Grid>
              <Grid container spacing={3}>
                <Grid item xs={12} sm={12}>
                  <TextField
                    required
                    id="password"
                    label="password"
                    name="password"
                    onChange={handleInputChange}
                    fullWidth
                  />
                </Grid>
              </Grid>

              <Grid container spacing={3}>
                <Grid item xs={12} sm={12}>
                  <TextField
                    required
                    id="confirmPassword"
                    label="Confirm Password"
                    fullWidth
                  />
                </Grid>
              </Grid>

              <Grid container spacing={3}>
                <Grid item xs={12} sm={12}>
                  <TextField
                    required
                    className="text-field"
                    id="role"
                    label="Role"
                    defaultValue={userState.role}
                    onChange={handleInputChange}
                    InputProps={{
                      readOnly: true,
                    }}
                    fullWidth
                  />
                </Grid>
              </Grid>

              <Button
                variant="contained"
                fullWidth
                className="text-field"
                onClick={handleButtonClick}
              >
                Edit
              </Button>
            </div>
          ) : (
            <lable>Not found</lable>
          )}
        </Paper>
      </Container>
    </>
  );
};

export default Profile;
