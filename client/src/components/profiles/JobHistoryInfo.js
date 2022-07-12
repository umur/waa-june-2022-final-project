
export default function JobHistoryInfo(props) {
    return (
        <div className='col-md-3'>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{props.companyName}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Start Date: {props.startDate}</li>
                    <li className="list-group-item">End Date: {props.endDate}</li>
                    {/* <li className="list-group-item">Reason of Leaving: {props.reasonToLeave}</li> */}
                </ul>
            </div>
            <br />
        </div>
    )
}