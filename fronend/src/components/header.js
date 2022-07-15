import React from 'react';
import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import LoginInfo from '../services/login-info.service';

const logout = () => {
  localStorage.clear();
  window.location.href = '/login';
}

let Header;

if (LoginInfo.userType() === "FACULTY") {
  Header = () => (
    <div className="header">
        <Navbar bg="primary" variant="dark">
          <Container>
          <Navbar.Brand as={Link} >
            { LoginInfo.username() }
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/dashboard" >Dashboard </Nav.Link>
            <Nav.Link as={Link} to="/profile">Profile</Nav.Link>
            {/* <Nav.Link as={Link} to="/Jobs">Jobs</Nav.Link> */}
            <Nav.Link as={Link} to="/job-list">Job List</Nav.Link>
            {/* <Nav.Link as={Link} to="/job-update">Job Update</Nav.Link> */}
            <Nav.Link as={Link} to="/student-list">Student</Nav.Link>
            <Nav.Link onClick={() => logout()}>Logout</Nav.Link>
          </Nav>
          </Container>
        </Navbar>
    </div>
  )
} else if (LoginInfo.userType() === "STUDENT") {
  Header = () => (
  
    <div className="header">
        <Navbar bg="primary" variant="dark">
          <Container>
          <Navbar.Brand as={Link} >
          { LoginInfo.username() }
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/dashboard" >Dashboard </Nav.Link>
            <Nav.Link as={Link} to="/profile">Profile</Nav.Link>
            {/* <Nav.Link as={Link} to="/Jobs">Jobs</Nav.Link> */}
            <Nav.Link as={Link} to="/job-post">Job Post</Nav.Link>
            <Nav.Link as={Link} to="/job-list">Job List</Nav.Link>
            <Nav.Link onClick={() => logout()}>Logout</Nav.Link>
          </Nav>
          </Container>
        </Navbar>
    </div>
  )

} else if (LoginInfo.userType() === "ADMIN") {
  Header = () => (
  
    <div className="header">
        <Navbar bg="primary" variant="dark">
          <Container>
          <Navbar.Brand as={Link} >
          { LoginInfo.username() }
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/dashboard" >Dashboard </Nav.Link>
            {/* <Nav.Link as={Link} to="/profile">Profile</Nav.Link> */}
            {/* <Nav.Link as={Link} to="/Jobs">Jobs</Nav.Link> */}
            {/* <Nav.Link as={Link} to="/job-post">Job Post</Nav.Link> */}
            <Nav.Link as={Link} to="/job-list">Job List</Nav.Link>
            {/* <Nav.Link as={Link} to="/job-update">Job Update</Nav.Link> */}
            <Nav.Link as={Link} to="/student-list">Student</Nav.Link>
            
            <Nav.Link as={Link} to="/all-user-list">User</Nav.Link>
            <Nav.Link onClick={() => logout()}>Logout</Nav.Link>
          </Nav>
          </Container>
        </Navbar>
    </div>
  )
}

export default Header;