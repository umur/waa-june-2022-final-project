import axios from "axios";
import JobListing from "./Last10JobAppliedList";
import { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";

const Last10Appliedjobs = (props) => {
  const [jobs, setJobState] = useState([]);
  const url =
    "http://localhost:8080/v1/api/job-applications/last10-job-application";
  const get10Jobs = async () => {
    const res = await axios.get(url);
    console.log(res.data);
    setJobState(res.data);
  };
  useEffect(() => {
    get10Jobs();
  }, []);

  return (
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
              id={job.jobAdvertisement.id}
              title={job.jobAdvertisement.title}
              benefits={job.jobAdvertisement.benefits}
              description={job.jobAdvertisement.description}
              address={job.jobAdvertisement.address}
            />
          );
        })}
      </tbody>
    </Table>
  );

  // return (
  //   <>
  //     {jobs.map((job) => {
  //       return (
  //         <JobListing
  //           key={job.id}
  //           id={job.id}
  //           title={job.title}
  //           benefits={job.benefits}
  //           description={job.description}
  //           address={job.address}
  //         />
  //       );
  //     })}
  //   </>
  // );
};

export default Last10Appliedjobs;
