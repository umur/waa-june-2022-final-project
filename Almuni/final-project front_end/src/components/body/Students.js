import React, { useEffect, useState } from 'react'
import Student from '../body/Student'
const Students = () => {
    const [studentsState, setStudentsState]=useState({});

    const fetchTodos = async () => {
        const result = await axios.get('http://localhost:8082/todos');
        setStudentsState(result.data);
    }
    useEffect(()=>{
        fetchTodos();
    },[])
  return (

    <div>Students
        {
            studentsState.map((item)=>{
                return <Student
                key={item.id}
                id={item.id}
                state={item.state}
                city={item.city}
                major={item.major}
                name={item.name}
                studentId={item.studentId}
                ></Student>
            })
        }

    </div>

  )
}

export default Students