import JobAdvertisement from "./JobAdvertisement";
const JobAdvertisements = () => {

    const listofAdd = [{id:1,item:'ad'},{id:2,item:'vff'}];
    return (

        <div>
            <h2>Job advertisements</h2>
            <ul>

                {

                    listofAdd.map((j) => {
                        return <JobAdvertisement key={j.id} job={j} ></JobAdvertisement>

                    })
                }
            </ul>

        </div>

    );
}

export default JobAdvertisements;