import React from "react";
import { Link } from "react-router-dom";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import "./index.css";
import UserService from "../../services/UserService";

var FontAwesomeIcon = require("react-fontawesome");

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
          <Nav className="me-auto"></Nav>

          <div className="notification-container">
            <FontAwesomeIcon
              name=""
              style={{ color: "white" }}
              className="fa-solid fa-bell"
              size="lg"
            />
          </div>

          <span className="navbar-text navbar-right">
            {UserService.getUsername()}
          </span>

          <button
            className="btn btn-info navbar-btn navbar-right"
            style={{ marginRight: 0, marginLeft:5}}
            onClick={() => UserService.doLogout()}
          >
            Logout
          </button>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
