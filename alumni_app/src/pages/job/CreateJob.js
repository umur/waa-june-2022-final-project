import React, { useState } from "react";
import Grid from "@mui/material/Grid";
import Typography from "@mui/material/Typography";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Button from "@material-ui/core/Button";
import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useParams } from "react-router";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";
import AutoCompleteSelect from "../../common/AutoCompleteSelect";
import Alert from "@mui/material/Alert";
import { useNavigate } from "react-router";
import FileUpload from "../../common/FileUpload";

const initialValues = {
  firstName: "",
  lastName: "",
  phoneNo: "",
  emailAddress: "",
  companyName: "",
  companySize: "",
  jobTitle: "",
  numOpening: "",
  jobType: "",
  paymentAmount: "",
  jobDesc: "",
  addBenefit: "",
  jobTag: "",
};

export default function CreateJob() {
  const navigate = useNavigate();
  const [selectValue, setSelectValue] = useState();

  const setValue = (value) => {
    let tagvalues = "";
    value.map((x) => {
      tagvalues += x.title + ",";
    });
    setValues({
      ...values,
      jobTag: tagvalues,
    });
  };

  const { id } = useParams();

  const postData = async () => {
    let params = "/jobs/newJob";
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

  const handleReset = (e) => {
    setValues(initialValues);
  };

  const getUrl=(e)=>{
    debugger
  }

  //const [companySize, setCompanySize] = React.useState('');
  //
  //  const handleChangeCompanySize = (event) => {
  //    setCompanySize(event.target.value);
  //  };
  //
  //  const [jobType, setJobType] = React.useState('');
  //
  //    const handleChangeJobType = (event) => {
  //      setJobType(event.target.value);
  //    };
  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Create New Job Post
      </Typography>
      <Grid container spacing={3}>
        {/*
//        <Grid item xs={12} sm={6}>
//          <TextField
//            required
//            id="firstName"
//            name="firstName"
//            label="First name"
//            fullWidth
//            autoComplete="given-name"
//            variant="standard"
//            value={values.firstName}
//            onChange={handleInputChange}
//          />
//        </Grid>
//        <Grid item xs={12} sm={6}>
//          <TextField
//            required
//            id="lastName"
//            name="lastName"
//            label="Last name"
//            fullWidth
//            autoComplete="family-name"
//            variant="standard"
//            value={values.lastName}
//            onChange={handleInputChange}
//          />
//        </Grid>
//        <Grid item xs={6}>
//                  <TextField
//                    id="phoneNo"
//                    name="phoneNo"
//                    label="Phone Number"
//                    fullWidth
//                    autoComplete="phone-number"
//                    variant="standard"
//                    value={values.phoneNo}
//                    onChange={handleInputChange}
//                  />
//                </Grid>
//        <Grid item xs={6}>
//                  <TextField
//                    required
//                    id="emailAddress"
//                    name="emailAddress"
//                    label="Email Address"
//                    fullWidth
//                    autoComplete="email-address"
//                    variant="standard"
//                    value={values.emailAddress}
//                    onChange={handleInputChange}
//                  />
//                 </Grid>
*/}
        <Grid item xs={6}>
          <TextField
            required
            id="companyName"
            name="companyName"
            label="Company Name"
            fullWidth
            autoComplete="company-name"
            variant="standard"
            value={values.companyName}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={6}>
          <FormControl fullWidth>
            <InputLabel id="companySize">Company Size</InputLabel>
            <Select
              labelId="companySize"
              id="companySize"
              label="Company Size"
              name="companySize"
              value={values.companySize}
              onChange={handleInputChange}
            >
              <MenuItem value="0- less than 100">0- less than 100</MenuItem>
              <MenuItem value="100-1000">100-1000</MenuItem>
              <MenuItem value="more than 1000">more than 1000</MenuItem>
            </Select>
          </FormControl>
        </Grid>
        <Grid item xs={6}>
          <TextField
            id="jobTitle"
            name="jobTitle"
            label="Job Title"
            required
            fullWidth
            autoComplete="Job Title"
            variant="standard"
            value={values.jobTitle}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={6}>
          <TextField
            id="numOpening"
            name="numOpening"
            label="Number of Opening"
            required
            fullWidth
            autoComplete="Number Opening"
            variant="standard"
            value={values.numOpening}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={6}>
          <FormControl fullWidth>
            <InputLabel id="jobType">Job Type</InputLabel>
            <Select
              labelId="jobType"
              id="jobType"
              label="Job Type"
              name="jobType"
              value={values.jobType}
              onChange={handleInputChange}
            >
              <MenuItem value="Full-Time">Full-Time</MenuItem>
              <MenuItem value="Part-Time">Part-Time</MenuItem>
              <MenuItem value="Contract">Contract</MenuItem>
            </Select>
          </FormControl>
        </Grid>
        <Grid item xs={6}>
          <TextField
            id="paymentAmount"
            name="paymentAmount"
            label="Pay Amount($)"
            required
            fullWidth
            autoComplete="Payment Amount"
            variant="standard"
            value={values.paymentAmount}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={12}>
          <>
            < AutoCompleteSelect
              name="jobTag"
              onChange={value => setValue(value)}
              isMultiSelect={true}
              label={"Job Tag"}
              placeholder={"Eg. C#, Java, JavaScript"}
              dataUrl='/tags' ></AutoCompleteSelect >
          </>
        </Grid>
        <Grid item xs={12}>
          <TextField
            id="jobDesc"
            name="jobDesc"
            label="Job Description(JD)"
            required
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
          <TextField
            id="addBenefit"
            name="addBenefit"
            label="Additional Benefits"
            fullWidth
            autoComplete="Additional Benefit"
            variant="outlined"
            multiline
            rows={4}
            value={values.addBenefit}
            onChange={handleInputChange}
          />
        </Grid>
        <Grid item xs={12}>
          <>
            <InputLabel id="jobDetailsDoc">
              Upload Job details document
            </InputLabel>
            <br />
            <FileUpload folderName="Job" id={1} getUrl={getUrl.bind(this)}></FileUpload>
          </>
        </Grid>
        <Grid item xs={12}>
          <div
            style={{
              width: "200px",
              display: "flex",
              flexDirection: "row",
              justifyContent: "space-between",
            }}
          >
            <Button variant="contained" type="reset" onClick={handleReset}>
              Reset
            </Button>
            <Button
              width="50px"
              margin-left="10px"
              onClick={postData}
              variant="contained"
              color="primary"
            >
              Add Job
            </Button>
          </div>
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
