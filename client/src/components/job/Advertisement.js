import React, { useEffect, useState } from "react";
import { Container, Form, Button, Row, Col } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { addJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";

export default function Advertisement() {
  const initialValues = {
    title: "",
    location: "",
    vacancyOpeningDate: "",
    description: "",
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
      const location = formValues.location.split(",");
      const finalFormVal = {
        ...formValues,
        address: { city: location[0], state: location[1] },
      };

      dispatch(addJobAdvertisement(finalFormVal));
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
    if (!values.vacancyOpeningDate) {
      errors.vacancyOpeningDate = "VacancyOpeningDate  required";
    }

    if (!values.description) {
      errors.description = "description required";
    }

    return errors;
  };

  // onClick(() => {
  //   dispatch(allJobAdvertisement());
  // }, []);

  return (
    <Container>
      <Row>
        <Col md={{ span: 8, offset: 2 }}>
          <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="jobTitle">
              <Form.Label className="d-flex">Title</Form.Label>
              <Form.Control
                type="title"
                placeholder={"Enter title"}
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

            <Form.Group className="mb-3" controlId="vacancyOpeningDate">
              <Form.Label className="d-flex">Vacancy Opening Date</Form.Label>
              <Form.Control
                type="date"
                placeholder="About the company"
                name="vacancyOpeningDate"
                onChange={handleChange}
              />
              <p className="error">{formErrors.vacancyOpeningDate}</p>
            </Form.Group>
            {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
                            <Form.Check type="checkbox" label="Check me out" />
                        </Form.Group> */}
            <Form.Group className="mb-3" controlId="responsibility">
              <Form.Label className="d-flex">Job Description</Form.Label>
              <Form.Control
                as="textarea"
                type="responsibility"
                placeholder="Describe the description"
                name="description"
                onChange={handleChange}
              />
              <p className="error">{formErrors.description}</p>
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
