import axios from "axios";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useState } from "react";

const url = "http://localhost:8080/v1/api/comments";
const Comment = () => {
  const [students, setStudent] = useState([]);
  cosnt[(studentid, setStudentId)] = useState();
  const [comments, setComments] = useState("");
  const url1 = "http://localhost:8080/v1/api/students";
  const get10Jobs = async () => {
    const res = await axios.get(url1);

    setStudent(res.data);
  };
  useEffect(() => {
    get10Jobs();
  }, []);
  const changeHandler = (event) => {
    setComments(event.target.value);
  };
  const requestId = (event) => {
    setStudentId(event.target.value);
  };
  const handleSubmit = (e) => {
    e.preventDefault();

    const data = {
      studentid,
      comments,
    };
    axios.post(url, data);
    setComments("");
    alert(" comment added ");
  };
  return (
    <>
      <div className="options">
        <select onChange={requestId}>
          <option>Select a student</option>
          {students.map((nameOfStuent) => (
            <option value={nameOfStuent.id}>
              {nameOfStuent.firstName} {nameOfStuent.lastName}
            </option>
          ))}
        </select>
      </div>
      <form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>comment:</Form.Label>
          <Form.Control
            type="text"
            value={comments}
            onChange={changeHandler}
            placeholder="Enter Comment"
          />
          <Form.Text className="text-muted">
            please be respectable with words
          </Form.Text>
        </Form.Group>

        <Button variant="primary" type="submit" value="Submit" />
      </form>
    </>
  );
};

export default Comment;
