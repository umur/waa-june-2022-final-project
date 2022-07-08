
export default function JobHistoryInfo(props) {
    return (
        <div className='col-md-3'>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title">{props.title}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Location: {props.location}</li>
                    <li className="list-group-item">About Company: {props.aboutUs}</li>
                </ul>
            </div>
            <br />
        </div>
    )
}