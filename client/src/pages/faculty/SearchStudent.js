import StudentFilter from "../../components/StudentFilter";
import StudentInfoCard from "../../components/StudentInfoCard";

function SearchStudent() {
    const studentList = [
        {
            id: 1,
            name: "Pravash Upreti",
            major: "Compro"
        }, {
            id: 1,
            name: "Ashish Ghimire",
            major: "Compro"
        }, {
            id: 1,
            name: "Anjana Sharma",
            major: "Compro"
        }, {
            id: 1,
            name: "Nirmal Silwal",
            major: "Compro"
        }
    ]

    return (
        <div>
            <StudentFilter></StudentFilter>

            <div className="row">


                {
                    studentList.map(student => {
                        return (
                            <StudentInfoCard
                                key={student.id}
                                name={student.name}>

                            </StudentInfoCard>)
                    })
                }
            </div>

        </div>
    );
}

export default SearchStudent;