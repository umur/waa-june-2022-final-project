import React, { useState } from 'react'
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import useCollapse from 'react-collapsed'
import { useSelector } from 'react-redux';

const StudentDetailPage = (props) => {

    const currentUser = useSelector(state => state.user)
    const params = useParams();

    const [student, setStudent] = useState({});
    const [post, setPost] = useState({});
    const [comments, setComments] = useState([])
    const [isLoaded, setIsLoaded] = useState(false);
    const { getCollapseProps, getToggleProps, isExpanded } = useCollapse()

    const students = [
        {
            "id": 1, "Role": "Student", "firstName": "John", "lastName": "Doe", "email": "john@gmail.com", "active": true,
            "address": { "id": 1, "street": "106 S D S", "city": "Fairfield", "state": "IA", "zip": "52556" },
            "major": "Compro", "studentId": "613799"
        },
        {
            "id": 2, "Role": "Student", "firstName": "Jahna", "lastName": "Clara", "email": "john@gmail.com", "active": false,
            "address": { "id": 2, "street": "107 S D S", "city": "Fairfield", "state": "IA", "zip": "52557" },
            "major": "MBA", "studentId": "614800"
        }
    ]

    const comment = [
        {
            "id": 1, "student_id": 1, "faculty_id": 1, "comment": "He is a good student", "commenter": "Faculty2"
        },
        {
            "id": 2, "student_id": 1, "faculty_id": 2, "comment": "I like him", "commenter": "Faculty1"
        },
        {
            "id": 3, "student_id": 2, "faculty_id": 2, "comment": "Bullshit!", "commenter": "Faculty1"
        },
    ]

    useEffect(() => {
        setStudent(students.filter((item) => item.id == params.id))
        setComments(comment.filter((item) => item.student_id == params.id))
        setIsLoaded(true)
    }, [])


    const handlePost = (e) => {
        e.preventDefault();
        // console.log(post);
        // need to implement post to comment db
    }

    if (!isLoaded) {
        return (
            <div className="container mt-5">
                <div>Loading...</div>
            </div >
        )
    } else if (isLoaded) {
        return (
            <div className="container">
                <div className="pt-5">
                    <div className="card">
                        <div className="card-header">
                            <div className="row">
                                <div className="col-6">
                                    <h3><u>Student Details:</u></h3>
                                </div>
                            </div>
                        </div>
                        <div className="card-body">
                            <h4>First Name: {student[0].firstName ?? ""}</h4>
                            <h4>Last Name: {student[0].lastName ?? ""}</h4>
                            <h4>Email: {student[0].email ?? ""}</h4>
                            <h4>Major: {student[0].major ?? ""}</h4>
                            <h4>City: {student[0].address.city ?? ""}</h4>
                            <h4>Street: {student[0].address.street ?? ""}</h4>
                            <h4>State: {student[0].address.state ?? ""}</h4>
                            <h4>Zip: {student[0].address.zip ?? ""}</h4>
                        </div>
                    </div>
                    <div className="card mt-3">
                        <div className="card-header">
                            <div className="row">
                                <div className="col-3">
                                    <h3><u>Faculty Comments:</u></h3>
                                </div>
                                <div className='col-3'>
                                    <button
                                        {...getToggleProps()}
                                        className='btn btn-info'>
                                        {isExpanded ? 'Hide comment' : 'Write comment'}
                                    </button>
                                </div>
                                <br />
                                <form>
                                    <div {...getCollapseProps()} className='mt-2'>

                                        <div className="row">
                                            <div className="col-12">
                                                <div className="form-floating">
                                                    <textarea
                                                        onChange={(e) => setPost(e.target.value)}
                                                        className="form-control"></textarea>
                                                    <label htmlFor="">Comments</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className='row'>
                                        <div className="col-12">
                                            {isExpanded ?
                                                <button
                                                    onClick={(e) => { handlePost(e) }}
                                                    className='btn btn-success mt-2'>
                                                    Add
                                                </button> : ""}
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div className="card-body">
                            <div className="row">
                                <div className="col-12">
                                    {
                                        comments.map((item, ind) =>
                                            <div className="card-header mb-2" key={item.id}>
                                                <h6><u>{item.commenter}</u></h6>
                                                {item.comment}
                                            </div>
                                        )
                                    }
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div >
        )
    }

}

export { StudentDetailPage }