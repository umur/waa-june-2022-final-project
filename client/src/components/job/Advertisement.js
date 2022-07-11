import React, { useEffect, useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { addJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";

export default function Advertisement() {
  const initialValues = {
    title: "",
    location: "",
    aboutUs: "",
    responsibilities: "",
    benefits: "",
  };

  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  const dispatch = useDispatch();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({
      ...formValues,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    setIsSubmit(true);
  };

  const navigate = useNavigate();
  useEffect(() => {
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      dispatch(addJobAdvertisement(formValues));
      navigate("/student/job-advertisement");
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.title) {
      errors.title = "Title  required";
    }
    if (!values.location) {
      errors.location = "Location required";
    }
    if (!values.aboutUs) {
      errors.aboutUs = "About Us required";
    }

    if (!values.responsibilities) {
      errors.responsibilities = "Responsibilities required";
    }

    return errors;
  };

  // onClick(() => {
  //   dispatch(allJobAdvertisement());
  // }, []);

  return (
    <Container>
      <Row>
        <Col md={{ span: 6, offset: 3 }}>
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="jobTitle">
              <Form.Label className="d-flex">Title</Form.Label>
              <Form.Control
                type="title"
                placeholder="Enter title"
                name="title"
                onChange={handleChange}
              />
              <p className="error">{formErrors.title}</p>

              {/* <Form.Text className="text-muted d-flex">
                                We'll never share your title with anyone else.
                            </Form.Text> */}
            </Form.Group>

            <Form.Group className="mb-3" controlId="location">
              <Form.Label className="d-flex">Location</Form.Label>
              <Form.Control
                type="location"
                placeholder="Enter location information"
                name="location"
                onChange={handleChange}
              />
              <p className="error">{formErrors.location}</p>
            </Form.Group>

            <Form.Group className="mb-3" controlId="aboutUs">
              <Form.Label className="d-flex">About Us</Form.Label>
              <Form.Control
                type="aboutUs"
                placeholder="About the company"
                name="aboutUs"
                onChange={handleChange}
              />
              <p className="error">{formErrors.aboutUs}</p>
            </Form.Group>
            {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group> */}
            <Form.Group className="mb-3" controlId="responsibility">
              <Form.Label className="d-flex">Job Responsibilities</Form.Label>
              <Form.Control
                as="textarea"
                type="responsibility"
                placeholder="Describe the responsibilities"
                name="responsibilities"
                onChange={handleChange}
              />
              <p className="error">{formErrors.responsibilities}</p>
            </Form.Group>

            <Form.Group className="mb-3" controlId="benefits">
              <Form.Label className="d-flex">Benefits</Form.Label>
              <Form.Control
                as="textarea"
                type="responsibility"
                placeholder="Benefits"
                name="benefits"
                onChange={handleChange}
              />
              <p className="error">{formErrors.benefits}</p>
            </Form.Group>

            <Button variant="primary" type="submit" className="d-flex">
              Submit
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
}
