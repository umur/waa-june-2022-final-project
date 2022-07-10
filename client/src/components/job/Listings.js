import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";
import JobFilter from "./JobFilter";
import JobListing from "./Listing";

export default function JobListings(props) {
  const dispatch = useDispatch();
  const { JobAdvertisement } = useSelector((state) => state);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  return (
    <>
      <JobFilter></JobFilter>
      <div className="container">
        {JobAdvertisement &&
          JobAdvertisement.map((job) => {
            return (
              <JobListing
                key={job.id}
                id={job.id}
                title={"New Job"}
                aboutUs={""}
                description={job.comment}
              />
            );
          })}{" "}
      </div>
    </>
  );
}
