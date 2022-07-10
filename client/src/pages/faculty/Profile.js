import React, { useEffect, useState } from 'react'
import { Breadcrumb, Container, Row, Col, Card } from 'react-bootstrap';
import logo from '../../../src/logo.svg';

import FileUploadPage from '../../pages/FileUploadPage';

export default function FacultyProfile() {
    const initialState = { email: "pnaira@miu.edu", password: "1234", role: "faculty", firstName: "Premchand", lastName: "Nair", address: "Linclon Street, Nebraska" }
    const [facultyProfile, setfacultyProfile] = useState(initialState);

    // const username = getUsername();
    // useEffect(() => {
    //     get();
    // }, []);
    return (
        <Container>
            <Breadcrumb name="Basic Information" />
            <section className='content'>
                <Container fluid="lg">
                    <Row>
                        <Col md={{ span: 3 }}>
                            <img src={logo} alt="user-image" />
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
                                                    Name: {facultyProfile?.firstName + " " + facultyProfile?.lastName}
                                                </p>
                                                <p className="font-italic mb-1">
                                                    Role: {facultyProfile?.role}
                                                </p>
                                                <p className="font-italic mb-0">
                                                    Email: {facultyProfile?.email}
                                                </p>
                                                <p className='font-italic mb-0'>
                                                    Address: {facultyProfile?.address}
                                                </p>


                                            </div>
                                        </div>

                                        <FileUploadPage/>
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