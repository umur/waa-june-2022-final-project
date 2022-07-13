import "./index.css";
import image from "../../../src/userprofile.png";

function StudentInfoCard(props) {
  return (
    <div className="col-md-3">
      <div className="card">
        <img src={image} alt="user-image" width="250px" height="250px" />
        <div className="card-body">
          <h5 className="card-title">
            {props.firstName + " " + props.lastName}
          </h5>
        </div>
        <ul className="list-group list-group-flush">
          {/* <li className="list-group-item"></li> */}
          <li className="list-group-item">
            Address: {props.address?.city + ", " + props.address?.state}
          </li>
          <li className="list-group-item">GPA: {props.gpa}</li>
        </ul>
      </div>
      <br />
    </div>
  );
}

export default StudentInfoCard;
