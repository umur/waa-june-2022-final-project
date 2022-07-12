import axios from "axios";
import JobListing from "./Last10JobAppliedList";
import { useEffect, useState } from "react";
const Last10Appliedjobs = () => {
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
    <>
      {jobs.map((job) => {
        console.log(job);
        <JobListing
          key={job.id}
          id={job.id}
          title={job.title}
          benefits={job.benefits}
          description={job.description}
          address={job.address}
        />;
      })}
    </>
  );
};

export default Last10Appliedjobs;
