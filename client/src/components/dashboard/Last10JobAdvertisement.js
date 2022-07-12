import axios from "axios";
import { useState } from "react";
import JobListing from '../job/Listing'
import { useEffect } from "react";
const Last10JobAdvertisement = () => {
    const [jobs, tenJobs] = useState([])
    const url = 'http://localhost:8080/v1/api/job-advertisements/last10Advertisements'

    const get10Jobs = async () => {
         const res= await axios.get(url)
            console.log(res.data)
            tenJobs(res.data);
    }
    useEffect(() => {

        get10Jobs();
    }, [])

    return <>
        {
         
           jobs.map((job) => {
                <JobListing
                    key={job.id}
                    id={job.id}
                    title={job.title}
                    benefits={job.benefits}
                    description={job.description}
                    address={job.address}
                />
            })

        }

    </>
}

export default Last10JobAdvertisement;