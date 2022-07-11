import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";
import JobFilter from "./JobFilter";
import JobListing from "./Listing";

export default function JobListings(props) {
  const dispatch = useDispatch();
  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  return (
    <>
      <JobFilter></JobFilter>

      <div className="row">
        {jobAdvertisement &&
          [...jobAdvertisement]
            .sort((x, y) => (x.id > y.id ? 1 : -1))
            .map((job) => {
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
