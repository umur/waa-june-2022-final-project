import StudentFilter from "../../components/StudentFilter";
import StudentInfoCard from "../../components/StudentInfoCard";
import {useState} from "react";

function SearchStudent() {
    const [studentState, setStudentState] = useState([]);

    let handleFilterChange = (data) => {
        setStudentState(data);
    };

    return (
        <div>
            <StudentFilter handleFilterChange={handleFilterChange}></StudentFilter>

            <div className="row">
                {
                    studentState &&
                    studentState?.map(student => {
                        return (
                            <StudentInfoCard
                                key={student.id}
                                id={student.id}
                                firstName={student.firstName}
                                lastName={student.lastName}
                                address={student.address}
                                gpa={student.gpa}>
                            </StudentInfoCard>)
                    })
                }
            </div>

        </div>
    );
}

export default SearchStudent;