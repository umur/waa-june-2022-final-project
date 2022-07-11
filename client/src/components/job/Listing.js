import React from "react";
import { Card, Stack, Button } from "react-bootstrap";
export default function JobListing(props) {
  return (
    <div className="col-6">
      <Card border="primary">
        <Card.Header>
          {props.title} {props.id}
        </Card.Header>
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
          </Stack>
        </Card.Footer>
      </Card>

      <br />
    </div>
  );
}
