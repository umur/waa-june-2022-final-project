import './index.css'

function StudentInfoCard(props) {
    return (
        <div className='col-md-3'>
            <div className="card">
                <img src="https://picsum.photos/400" className="card-img-top" alt="" />
                <div className="card-body">
                    <h5 className="card-title">{props.name}</h5>
                </div>
                <ul className="list-group list-group-flush">
                    <li className="list-group-item">Major: Compro</li>
                    <li className="list-group-item">Address: Iowa, Fairfield</li>
                    <li className="list-group-item">GPA: 3.8</li>
                </ul>
            </div>
        </div>
    );
}

export default StudentInfoCard;