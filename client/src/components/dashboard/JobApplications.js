import JobApplication from "./JobApplication";

const JobApplications = () => {
    const listofapp = [{id:1,item:'ad'},{id:2,item:'vff'}];
    return (
        <div>
            <h2>Job applications </h2>
            <ul>

                {

                    listofapp.map((j) => {
                        return <JobApplication key={j.id} job={j} ></JobApplication>

                    })
                }
            </ul>
        </div>

    );
}

export default JobApplications;