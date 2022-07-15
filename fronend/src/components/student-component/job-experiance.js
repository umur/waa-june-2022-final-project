import React, { Component } from "react";
export default class JobExperiance extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="container">
        <h1>Professional Job Experiance</h1>
        <hr />
        <form class="form-inline">
          <div className="row">
          <div className="col-md-4">
              <label for="email">First name:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-4">
              <label for="">Last name:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>Email:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>Username:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>User Type:</label>
              <select class="form-control">
                <option>--Select Type--</option>
                <option>Student</option>
                <option>Faculty</option>
              </select>
            </div>
            <div className="col-md-4">
              <label for="email">Password:</label>
              <input type="password" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>Major:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>CGPA:</label>
              <input type="number" class="form-control" />
            </div>
            <div className="col-md-4">
              <label>City:</label>
              <input type="text" class="form-control" />
            </div>
            <div className="col-md-12">
              <br/>
              <button className="btn btn-success float-right">
                <span>Registration</span>
              </button>
            </div>
          </div>
        </form>
      </div>
    );
  }
}
