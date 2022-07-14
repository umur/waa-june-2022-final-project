import React, { useState } from 'react'
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import useCollapse from 'react-collapsed'
import { useSelector } from 'react-redux';
import student from '../../service/student'

const StudentDetailPage = () => {

    const currentUser = useSelector(state => state.user)
    const [userStudent, setStudent] = useState({});
    const [post, setPost] = useState({});
    const [isLoaded, setIsLoaded] = useState(false);
    const { getCollapseProps, getToggleProps, isExpanded } = useCollapse()

    const param = useParams();

    useEffect(() => {
        if (currentUser?.id) {
            student.findById(currentUser.id).then(resp => {
                setStudent(resp.data)
                setIsLoaded(true)
            }).catch(err => {
                console.log(err);
            })
        }
    }, [])


    const handlePost = (e) => {
        // e.preventDefault();

        if (currentUser?.id) {
            const newPost = { comment: post, commenter: currentUser.username }
            student.postComment(newPost, param.id).then(resp => {
                console.log(resp.data);
            }).catch(err => {
                console.log(err);
            })
        }
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
                            <h4>First Name: {userStudent.firstName ?? ""}</h4>
                            <h4>Last Name: {userStudent.lastName ?? ""}</h4>
                            <h4>Email: {userStudent.email ?? ""}</h4>
                            <h4>Major: {userStudent.major ?? ""}</h4>
                            <h4>City: {userStudent.address.city ?? ""}</h4>
                            <h4>Street: {userStudent.address.street ?? ""}</h4>
                            <h4>State: {userStudent.address.state ?? ""}</h4>
                            <h4>Zip: {userStudent.address.zip ?? ""}</h4>
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
                                        userStudent.student.comments.map((item, ind) =>
                                            <div className="card-header mb-2" key={item.id ?? ""}>
                                                <h6><u>{item.commenter ?? ""}</u></h6>
                                                <span>{item.comment ?? ""}</span>
                                                <br />
                                                <span>{item.postTime ?? ""}</span>
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