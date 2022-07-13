import React from "react";
import { Card, Stack, Button } from "react-bootstrap";
import { useNavigate, Link } from "react-router-dom";
export default function JobListing(props) {
  const navigate = useNavigate();

  const handleJobEdit = () => {
    navigate("/student/job-advertisement/edit", {
      state: {
        id: props.id,
        title: props.title,
        location: props.address.city + "," + props.address.state,
        description: props.description,
        benefits: props.benefits,
      },
    });
  };
  return (
    <div className="col-6">
      <Card border="primary">
        <Card.Header>{props.title}</Card.Header>
        <Card.Body>
          <Card.Title>
            {props.address
              ? props.address.city + "," + props.address.state
              : ""}
          </Card.Title>
          <Card.Text>
            <b>Job Description: </b>
            {props.description}
          </Card.Text>
          <Card.Text>
            <b>Benefits: </b>
            {props.benefits}
          </Card.Text>
        </Card.Body>
        <Card.Footer>
          <Stack direction="horizontal" gap={2}>
            <Button as="a" variant="primary" className="pull-right">
              Apply
            </Button>
            <Button
              as="a"
              variant="primary"
              className="pull-right"
              onClick={handleJobEdit}
            >
              Edit
            </Button>
          </Stack>
        </Card.Footer>
      </Card>

      <br />
    </div>
  );
}
