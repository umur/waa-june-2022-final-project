import React, { useContext, useState } from "react";
import { JobContext } from "../../App";
import { UserContext } from "../../context/context";
import JobCard from "../cards/JobCard";
import AddJob from "./AddJob";

const JobsPage = () => {
  const jobs = useContext(JobContext);
  const [showAddJob, setShowAddJob] = useState(false);
  return (
    <>
      <div>
        <div>
          <div className="user">
            {/* <i className="glyphicon glyphicon-user"></i> */}
            {/* <h3> Lets go for a <FaBeer />? </h3> */}
            {/* <img
                  className="card-img-top"
                  style={{ width: "2rem", height: "2rem" }}
                  src="https://th.bing.com/th/id/OIP.NkVlMldT0rn1beTIQuXU_wAAAA?w=158&h=180&c=7&r=0&o=5&pid=1.7"
                  alt={user}
                /> */}
          </div>
          <div className="container specialBorder">
            <h1>Job Advertisemnts</h1>
          </div>
          <div className="container specialBorder ">
           
           <div className="row">
                  <tr>
              {jobs
                ? jobs.map(job=> {
                    return(
                      <div className="col" >

                      
                       <JobCard key= {job.id} props= {job}/>

                        </div>
                    )
                })
                 
                : 
                "No jobs"}

                </tr>
           </div> 
          </div>
          <div className="container specialBorder ">
            <div className="inputToleft gapButton">
              <button
                type="button"
                className="btn btn-outline-secondary btn-lg"
                onClick={() => {
                  setShowAddJob(!showAddJob);
                }}
              >
                Add/ Edit Jobs
              </button>
            </div>
          </div>

          <div className="container specialBorder">
            {showAddJob ? <AddJob /> : ""}
          </div>
        </div>
      </div>
    </>
  );
};

export default JobsPage;
