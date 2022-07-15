import React, { Component } from "react";
import ApiService from "../../services/ApiService";

class StudentList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      students: [],
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    ApiService.getAllData(ApiService.STUDENT_LIST).then((res) => {
      this.setState({ students: res.data.data });
      console.log(res.data.data);
    });
  }

  handleChange(event) {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    this.setState({
      [name]: value,
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    const data = {
      state: this.state.state,
      city: this.state.city,
      major: this.state.major,
      firstname: this.state.firstname,
      lastname: this.state.lastname,
    };
    ApiService.postData(ApiService.SEARCH_STUDENT, data).then(
      (res) => {
        console.log(res.data);
        this.setState({ students: res.data.data });
        console.log(res.data.data);
      },
      (error) => {
        console.log(error);
      }
    );
  }


  render() {
    return (
      <div className="container">
        <form className="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
            <div className="col-md-3">
              <label>State:</label>
              <input type="text" className="form-control" name="state"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>City:</label>
              <input type="text" className="form-control" name="city"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>Major:</label>
              <input type="text" className="form-control" name="major"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>Firstname:</label>
              <input type="text" className="form-control" name="firstname"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>Lastname:</label>
              <input type="text" className="form-control" name="lastname"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <br />
              <button className="btn btn-success float-right">
                <span>Search</span>
              </button>
            </div>
          </div>
        </form>


        <h2 className="text-center">Student List</h2>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th> Email</th>
                <th> Fullname</th>
                <th> Major</th>
                <th> GPA</th>
                <th> City</th>
                <th> Comment</th>
              </tr>
            </thead>
            <tbody>
              {this.state.students.map((student) => (
                <tr key={student.id}>
                  <td> {student.email} </td>
                  <td> {student.firstname} {student.lastname}</td>
                  <td> {student.major}</td>
                  <td> {student.gpa}</td>
                  <td> {student.city}</td>
                  <td></td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default StudentList;
