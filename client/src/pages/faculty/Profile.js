import React, { useEffect, useState } from 'react'
import { Breadcrumb, Container, Row, Col, Card } from 'react-bootstrap';
import image from '../../../src/userprofile.png'
import { getFacultyProfile } from "../../redux/reducers/UserProfile/actions";

import FileUploadPage from '../../pages/FileUploadPage';
import { useDispatch, useSelector } from "react-redux";


export default function FacultyProfile() {
    const dispatch = useDispatch();
    const userProfile = useSelector((state) => state.userProfile);

    useEffect(() => {
        dispatch(getFacultyProfile());
    }, []);
    return (
        <Container>
            <Breadcrumb name="Basic Information" />
            <section className='content'>
                <Container fluid="lg">
                    <Row>
                        <Col md={{ span: 3 }}>
                            <img src={image} alt="user-image" width="250px" height="250px" />
                        </Col>
                        <Col md={{ span: 6 }}>
                            <div className='row d-flex justify-content-center align-items-center h-100'>
                                <div className='card'>
                                    <div className='card-body p-4 text-block'>
                                        <div className='mb-5'>
                                            <p className="lead fw-normal mb-1">Faculty Profile</p>
                                            <div className="p-4" style={{ backgroundColor: "#f8f9fa" }}>
                                                <p className="text-right">
                                                    {/* <Link to={`update/${facultyProfile?.id}`}><i className='fas fa-edit text-primary ml-2'></i></Link> */}
                                                </p>
                                                <p className="font-italic mb-1">
                                                    Name: {userProfile?.firstName + " " + userProfile?.lastName}
                                                </p>
                                                <p className="font-italic mb-0">
                                                    Email: {userProfile?.email}
                                                </p>
                                                <p className='font-italic mb-0'>
                                                    Address: {userProfile?.address}
                                                </p>
                                            </div>
                                        </div>

                                        {/* <FileUploadPage /> */}
                                    </div>
                                </div>
                            </div>

                        </Col>
                    </Row>
                    <br />
                </Container>
            </section>
        </Container>
    )
}