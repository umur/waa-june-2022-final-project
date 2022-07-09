import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../store/reducers/JobAdvertisement";
import JobFilter from "./JobFilter";
import JobListing from "./Listing";

export default function JobListings(props) {
  const dispatch = useDispatch();
  const { jobAdvertisementList } = useSelector((state) => state);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  return (
    <>
      <JobFilter></JobFilter>
      <div className="container">
        {jobAdvertisementList &&
          jobAdvertisementList.map((item) => {
            return (
              <JobListing
                key={item.id}
                id={item.id}
                title={item.title}
                aboutUs={item.aboutUs}
                description={item.description}
              />
            );
          })}{" "}
      </div>
    </>
  );
}
