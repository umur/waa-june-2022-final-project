import React, { useState } from 'react'
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const StudentPage = () => {

    const [studentList, setStudentList] = useState([]);

    const navigate = useNavigate();

    const onClicked = (id) => {
        navigate('/student/' + id)
    }

    useEffect(() => {
        setStudentList([
            { "id": 1, "Role": "Student", "fname": "John", "lname": "Doe", "email": "john@gmail.com", "active": true },
            { "id": 2, "Role": "Student", "fname": "John", "lname": "Doe", "email": "john@gmail.com", "active": false }
        ])
    }, [])

    return (
        <div className="container">
            <div className="pt-5">
                <div className="card">
                    <div className="card-header">
                        <div className="row">
                            <div className="col-6">
                                <h3>All Users</h3>
                            </div>
                        </div>
                    </div>
                    <div className="card-body">
                        <table className="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Is Active</th>
                                </tr>
                            </thead>
                            <tbody>
                                {studentList.map((item, ind) =>
                                    <tr key={item.id}>
                                        <th scope="row">{ind + 1}</th>
                                        <td>{item.Role}</td>
                                        <td>{item.fname}</td>
                                        <td>{item.lname}</td>
                                        <td>{item.email}</td>
                                        <td>{item.active ? 'Yes' : 'No'}
                                        </td>
                                        <td>
                                            <button className="btn btn-primary me-1" onClick={() => {
                                                onClicked(item.id)
                                            }}>
                                                Detail
                                            </button>
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    )
}

export { StudentPage }