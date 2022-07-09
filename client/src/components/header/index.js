import React from "react";
import { Link } from "react-router-dom";
import Main from "../dashboard/Main";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
// import {FontAwesomeIcon} from "react-bootstrap"
import "./index.css";
import UserService from "../../services/UserService";

var FontAwesomeIcon = require('react-fontawesome');

export default function Header() {
  return (
    <Navbar
      bg="primary"
      variant="dark"
      expand="lg"
      className="header-navigation"
    >
      <Container fluid>
        <Navbar.Brand as={Link} to="/dashboard">
          Alumni Management Portal
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/user-profile">
              My Profile
            </Nav.Link>
            <Nav.Link as={Link} to="/add-new-advertisement">
              Job Adds
            </Nav.Link>
            <Nav.Link as={Link} to="/job-listings">
              Job Listing
            </Nav.Link>
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
          <button
            className="btn btn-success navbar-btn navbar-right"
            style={{ marginRight: 0 }}
            onClick={() => UserService.doLogout()}
          >
            Logout
          </button>
          <span className="navbar-text navbar-right">
            Signed in as {UserService.getUsername()}
          </span>
          &nbsp;
          <div className="notification-container">
              <FontAwesomeIcon className="fa-solid fa-bell" size="xs"/>
          </div>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
