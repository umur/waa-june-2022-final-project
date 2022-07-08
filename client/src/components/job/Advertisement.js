import React from "react";
import { Container, Form, Button,Row, Col } from "react-bootstrap";

export default function Advertisement() {
    return (
        <Container>
            <Row>
                <Col md={{ span: 6, offset: 3 }}>
                    <Form>
                        <Form.Group className="mb-3" controlId="jobTitle">
                            <Form.Label className="d-flex">Title</Form.Label>
                            <Form.Control type="title" placeholder="Enter title" />
                            {/* <Form.Text className="text-muted d-flex">
                                We'll never share your title with anyone else.
                            </Form.Text> */}
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="location">
                            <Form.Label className="d-flex">Location</Form.Label>
                            <Form.Control type="location" placeholder="Enter location information" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="aboutUs">
                            <Form.Label className="d-flex">About Us</Form.Label>
                            <Form.Control type="aboutUs" placeholder="About the company" />
                        </Form.Group>
                        {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group> */}
                        <Form.Group className="mb-3" controlId="responsibility">
                            <Form.Label className="d-flex">Job Responsibilities</Form.Label>
                            <Form.Control as="textarea" type="responsibility" placeholder="Describe the responsibilities" style={{height: '100px'}} />
                        </Form.Group>

                        <Button variant="primary" type="submit" className="d-flex">
                            Submit
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}