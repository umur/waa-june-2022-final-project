import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";
import JobFilter from "./JobFilter";
import JobListing from "./Listing";

export default function JobListings(props) {
  const dispatch = useDispatch();
  const { jobAdvertisement } = useSelector((state) => state);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  // console.log(jobAdvertisement)
  const initialState = jobAdvertisement;
  const [jobState, setJobState] = useState(initialState);
  console.log(jobState)

  let handleFilterChange = (data) => {
    setJobState(data)
    console.log(jobState)
  }

  return (
    <>
      <JobFilter handleFilterChange={handleFilterChange}></JobFilter>
      <div className="container">

      {/* {JSON.stringify(jobState)} */}
        {jobState &&
          jobState.map((job) => {
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
          })}{" "}
      </div>
    </>
  );
}
