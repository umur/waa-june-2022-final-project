import axios from "axios";
import { useState } from "react";
import JobListing from "../job/ListingTop10";
import { useEffect } from "react";
import Table from "react-bootstrap/Table";

const Last10JobAdvertisement = () => {
  const [jobs, tenJobs] = useState([]);
  const url =
    "http://localhost:8080/v1/api/job-advertisements/last10Advertisements";

  const get10Jobs = async (props) => {
    const res = await axios.get(url);

    tenJobs(res.data);
  };
  useEffect(() => {
    get10Jobs();
  }, []);

  return (
    <>
      <h3>Last 10 Job Advertisement</h3>
      <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>Job Id</th>
            <th>Job Title</th>
            <th>Address</th>
          </tr>
        </thead>
        <tbody>
          {jobs.map((job) => {
            return (
              <JobListing
                key={job.id}
                id={job.id}
                title={job.title}
                benefits={job.benefits}
                description={job.description}
                address={job.address}
              />
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default Last10JobAdvertisement;
