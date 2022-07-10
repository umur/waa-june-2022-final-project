import React, { useState, useEffect } from "react";
import { Button, Container, Typography } from "@material-ui/core";
import { useParams } from "react-router";
import Paper from "@mui/material/Paper";
import { getRequest } from "../../setup/fetch-manager/FetchGateway";
import { Link } from "react-router-dom";
// import Pdf from "../../job-description/sample-job-description.pdf";

const JobDetails = () => {
  const { id } = useParams();
  const [jobDetailsState, setJobDetailsState] = useState();

  let fetchData = async () => {
    let response = await getRequest("/jobs/" + id);
    setJobDetailsState(response);
    console.log("Job Details " + response);
  };
  useEffect(() => {
    fetchData();
  }, []);
  handleClick = () => {};

  return (
    <>
      <Container maxWidth="sm">
        <div className="details-information">
          {jobDetailsState != null ? (
            <div>
              <Typography variant="h4" component="h2">
                {jobDetailsState.jobTitle}
              </Typography>

              <Button
                variant="contained"
                className="apply-button"
                color="primary"
                onClick={handleClick}
              >
                Apply Now
              </Button>
              <div className="job-details">
                <Typography variant="h5" component="h2">
                  Job Details
                </Typography>
                <div className="salaryDetails">
                  <label>Company Name</label>
                  <br />
                  <label>{jobDetailsState.companyName}</label>
                </div>
                <div className="salaryDetails">
                  <label>Company Size</label>
                  <br />
                  <label>{jobDetailsState.companySize}</label>
                </div>

                <div className="salaryDetails">
                  <label>Job Type</label>
                  <br />
                  <label>{jobDetailsState.jobType}</label>
                </div>
                <div className="salaryDetails">
                  <label>Salary</label>
                  <br />
                  <label>{jobDetailsState.paymentAmount}</label>
                </div>

                <div className="salaryDetails">
                  <label>Company Size</label>
                  <br />
                  <label>{jobDetailsState.companySize}</label>
                </div>
              </div>
              <div className="job-description job-details">
                <Typography variant="h5" component="h2">
                  Full Job Description
                </Typography>
                <div className="salaryDetails">
                  <label>{jobDetailsState.jobDesc}</label>
                </div>
                <div className="salaryDetails">
                  <label>Hiring Insights</label>
                  <br />
                  <label>{jobDetailsState.numOpening}</label>
                </div>
                <div className="salaryDetails">
                  <label>Posted on</label>
                  <br />
                  <label>{jobDetailsState.publishDate}</label>
                </div>

                <div className="additional-benefits">
                  <Typography variant="h6" component="h2">
                    Additional Benefits
                  </Typography>
                  <div>
                    <label>{jobDetailsState.addBenefit}</label>
                  </div>
                </div>
                {/* for external files */}
                <div>
                  <a
                    href={require("../../job-description/sample-job-description.pdf")}
                    target="_blank"
                  >
                    See Additional Documents
                  </a>
                </div>
              </div>
            </div>
          ) : (
            <label>Job Details Not found </label>
          )}
        </div>
      </Container>
    </>
  );
};

export default JobDetails;
