import React from 'react'
import { Link } from 'react-router-dom'
import Main from '../dashboard/Main'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { bottom } from '@popperjs/core';

export default function Header() {
    return (
        <Navbar bg="primary" variant="dark" expand="lg">
            {/* <Container> */}
                <Navbar.Brand as={Link} to="/dashboard">Alumni Management Portal</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="/user-profile" >My Profile</Nav.Link>
                        <Nav.Link as={Link} to="/add-new-advertisement" >Job Adds</Nav.Link>
                        {/* <Nav.Link href="#link">Link</Nav.Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">
                                Another action
                            </NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">
                                Separated link
                            </NavDropdown.Item>
                        </NavDropdown> */}
                    </Nav>
                </Navbar.Collapse>
            {/* </Container> */}
        </Navbar>
    )
}