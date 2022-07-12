import React from "react";
import { Card, Stack, Button } from "react-bootstrap";
export default function JobListing(props) {
  return (
    <div className="container">
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
       
      </Card>

      <br />
    </div>
  );
}
