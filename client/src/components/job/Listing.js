import React from 'react'
import { Card, Stack, Button } from 'react-bootstrap'
export default function JobListing(props) {
    return (
        <div className='container'>

            <Card border="primary">
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
                <Card.Footer>
                    <Stack direction="horizontal" gap={2}>
                        <Button as="a" variant="primary" className="align-right">
                            Apply
                        </Button>
                    </Stack>
                </Card.Footer>
            </Card>

            <br />
        </div>
    )
}