import axios from "axios";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useState } from "react";

const url = 'http://localhost:8080/v1/api/comments';
const Comment = () => {
    const [comments, setComments] = useState('');

    const changeHandler = (event) => {
        setComments(event.target.value);

    }

    const handleSubmit = (e) => {
        e.preventDefault();

        alert('A comment is being posted ');
        axios.post(url, comments);
        setComments('');

    }
    return (<>
        <form onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label >comment:</Form.Label>
                <Form.Control type="text" value={comments} onChange={changeHandler} placeholder="Enter Comment" />
                <Form.Text className="text-muted">
                    please be respectable with words
                </Form.Text>
            </Form.Group>

            <Button variant="primary" type="submit" value="Submit" />
        </form>


    </>);
}

export default Comment; 