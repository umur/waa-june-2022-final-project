import React from 'react'
import { Card, Container } from 'react-bootstrap'
export default function JobListing(props) {
    return (
        <div className='container'>
            <Card border="primary" style={{ width: '18rem' }}>
                <Card.Header>{props.title}</Card.Header>
                <Card.Body>
                    <Card.Title>{props.location}</Card.Title>
                    <Card.Text>
                        About Us: {props.aboutUs}
                    </Card.Text>
                    <Card.Text>
                        Job Description:{props.description}
                    </Card.Text>
                </Card.Body>
            </Card>
            <br/>
        </div>
    )
}