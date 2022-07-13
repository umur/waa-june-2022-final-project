import React from "react";
import { useState } from "react";
import { Form, Button, Container } from "react-bootstrap";

const Registration = () => {
  const [studentInfo, setStudentInfo] = useState();

  const onSubmit = (data) => {
    setStudentInfo(data);
  };

  return (
    <Container>
      <h1>Faculty Registration</h1>
      <div className="ui divider"></div>
      <div className="ui form">
        <Form>
          <Form.Group className="mb-3">
            <Form.Label>First Name: </Form.Label>
            <Form.Control
              type="text"
              className="mb-3"
              name="fName"
              placeholder="First Name"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>Last Name: </Form.Label>
            <Form.Control
              type="text"
              className=""
              name="lName"
              placeholder="Last Name"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>Address: </Form.Label>
            <Form.Control
              type="text"
              className=""
              name="address"
              placeholder="Address"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>Email: </Form.Label>
            <Form.Control
              type="email"
              className=""
              name="email"
              placeholder="Email"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>User Name: </Form.Label>
            <Form.Control
              type="text"
              className=""
              name="userName"
              placeholder="User Name"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Label>Password: </Form.Label>
            <Form.Control
              type="password"
              className=""
              name="password"
              placeholder="Enter your password"
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Button>Register Faculty</Button>
          </Form.Group>
        </Form>
      </div>
    </Container>
  );
};

export { Registration as FacultyRegistration };
