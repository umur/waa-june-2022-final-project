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
    <tr>
      <td>{props.id}</td>
      <td>{props.title}</td>
      <td>{props.address?.city}</td>
    </tr>
  );
}
