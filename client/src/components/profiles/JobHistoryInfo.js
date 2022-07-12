
export default function JobHistoryInfo(props) {
    return (
        <div>
            <div className="card col-md-5 col-md-offset-5">
                <div className="card-body">
                    <h5 className="card-title">{props.companyName}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Start Date: {props.startDate}</li>
                    <li className="list-group-item">End Date: {props.endDate}</li>
                </ul>
            </div>
            <br />
        </div>
    )
}