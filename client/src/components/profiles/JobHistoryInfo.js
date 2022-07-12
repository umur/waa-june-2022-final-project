import { Col, Row } from "react-bootstrap";

export default function JobHistoryInfo(props) {
    return (
        <Row>
            <Col md={{span:8 ,offset:2}}>
                <div className="card-body">
                    <h5 className="card-title">{props.companyName}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Start Date: {props.startDate}</li>
                    <li className="list-group-item">End Date: {props.endDate}</li>
                </ul>
            </Col>
            <br />
        </Row>
    )
}