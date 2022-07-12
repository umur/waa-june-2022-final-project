import React from "react";
import { Card, Stack, Button } from "react-bootstrap";
export default function JobListing(props) {
  return (
    <tr>
      <td>{props.id}</td>
      <td>{props.title}</td>
      <td>{props.address?.city}</td>
    </tr>
  );
}
