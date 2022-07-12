import { Col, Row, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

export default function JobHistoryInfo(props) {
    const navigate = useNavigate();
    const handleJobHistoryEdit = () => {
        navigate('/student/job-history/edit', {state: {id:props.id,companyName: props.companyName, startDate:props.startDate,endDate:props.endDate,reasonToLeave:props.reasonToLeave, comment:props.comment}})
    }

    return (
        <Row>
            <Col md={{ span: 8, offset: 2 }}>
                <Button as="a" variant="primary" className="pull-right" onClick={handleJobHistoryEdit}>
                    Edit
                </Button>
                <div className="card-body">
                    <h5 className="card-title">{props.companyName}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Start Date: {props.startDate}</li>
                    <li className="list-group-item">End Date: {props.endDate}</li>
                    <li className="list-group-item">Reason of Leaving: {props.reasonToLeave}</li>
                    <li className="list-group-item">Comments: {props.comment}</li>
                </ul>

            </Col>
            <br />
        </Row>
    )
}