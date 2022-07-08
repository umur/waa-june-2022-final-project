import React from 'react'
import { Form,Row } from 'react-bootstrap'

export default function JobFilter() {
    return (<div className="card filter-form">

        <Form>
            <Row>
                <Form.Group className="mb-3 col-3" controlId='searchByTitle'>
                    <Form.Label for="name" className="form-label">Title</Form.Label>
                    <Form.Control type="text" className="form-control" id="title" />
                </Form.Group>

                <Form.Group className="mb-3 col-3">
                    <Form.Label for="state" className="form-label">State</Form.Label>
                    <Form.Select className="form-select" id="state">
                        <option selected>Select</option>
                        <option value="1">Iowa</option>
                        <option value="2">New York</option>
                        <option value="3">Berlinton</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group className="mb-3 col-3">
                    <Form.Label for="city" className="form-label">City</Form.Label>
                    <Form.Select className="form-select" id="city">
                        <option selected>Select</option>
                        <option value="1">Fairfield</option>
                        <option value="2">De Moinse</option>
                        <option value="3">Berlinton</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group className="mb-3 col-3">
                    <Form.Label for="tagName" className="form-label">Tag Name</Form.Label>
                    <Form.Control type="text" className="form-control" id="tagName" />
                </Form.Group>
            </Row>
        </Form>

    </div>)
}