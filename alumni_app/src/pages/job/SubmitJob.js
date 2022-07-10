import React, { useState } from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";
import { useNavigate } from "react-router";
import TextField from "@mui/material/TextField";
import Button from "@material-ui/core/Button";

const initialValues = {
  addComment: "",
};

export default function SubmitJob() {
  const navigate = useNavigate();

  const postData = async () => {
    let params = "/jobs/apply";
    let result = await postRequest(params, values);
    navigate("/Jobs");
  };

  const [values, setValues] = useState(initialValues);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    debugger;
    console.log(e.target);
    setValues({
      ...values,
      [name]: value,
    });
  };

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Please write additional comments and click "Submit Application" Button
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <TextField
            id="addComment"
            name="addComment"
            label="Additional Comments"
            fullWidth
            autoComplete="Job Description"
            variant="outlined"
            multiline
            rows={6}
            value={values.jobDesc}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={12}>
          <div>
            <Button variant="contained" color="primary">
              Submit Application
            </Button>
          </div>
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
