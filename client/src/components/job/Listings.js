import React, { useEffect } from "react";
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

  return (
    <>
      <JobFilter></JobFilter>
      <div className="container">
        {jobAdvertisement &&
          jobAdvertisement.map((job) => {
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
