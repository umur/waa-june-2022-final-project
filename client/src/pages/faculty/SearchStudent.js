import StudentFilter from "../../components/StudentFilter";
import StudentInfoCard from "../../components/StudentInfoCard";
import {useState} from "react";

function SearchStudent() {
    const studentList = [
        {
            id: 1,
            name: "Pravash Upreti",
            major: "Compro"
        }, {
            id: 2,
            name: "Ashish Ghimire",
            major: "Compro"
        }, {
            id: 3,
            name: "Anjana Sharma",
            major: "Compro"
        }, {
            id: 4,
            name: "Nirmal Silwal",
            major: "Compro"
        }
    ]

    const [studentState, setStudentState] = useState([]);

    let handleFilterChange = (data) => {
        setStudentState(data);
    };

    return (
        <div>
            <StudentFilter handleFilterChange={handleFilterChange}></StudentFilter>

            <div className="row">

                {
                    studentList.map(student => {
                        return (
                            <StudentInfoCard
                                key={studentState.id}
                                id={studentState.id}
                                name={studentState.firstName }>
                            </StudentInfoCard>)
                    })
                }
            </div>

        </div>
    );
}

export default SearchStudent;