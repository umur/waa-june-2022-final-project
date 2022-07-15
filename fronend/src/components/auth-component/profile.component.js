import React, { Component } from "react";
import ApiService from "../../services/ApiService";
import { ToastContainer, toast } from 'react-toastify';

export default class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      profileData: {},

    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    ApiService.getAllData(ApiService.GET_PROFILE).then((res) => {
      this.setState({ profileData: res.data.data });
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
      email: this.state.email !== undefined ? this.state.email : this.state.profileData.email,
      // userType: this.state.userType,
      firstName: this.state.firstName !== undefined ? this.state.firstName : this.state.profileData.firstName,
      lastname: this.state.lastname !== undefined ? this.state.lastname : this.state.profileData.lastname,
      major: this.state.major !== undefined ? this.state.major : this.state.profileData.major,
      gpa: this.state.gpa !== undefined ? this.state.gpa : this.state.profileData.gpa,
      city: this.state.city !== undefined ? this.state.city : this.state.profileData.city,
      userType: this.state.profileData.userType
    };
    console.log(data);
    ApiService.postData(ApiService.UPDATE_PROFILE, data).then(
      (res) => {
        toast.warning('Data Update Success', {
          position: "top-right",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          });
      },
      (error) => {
        console.log(error);
      }
    );
  }

  render() {
    return (
      <div className="container">
        <h1>Profile Update</h1>
        <p>Please fill in this form to create an account.</p>
        <hr />
        <form className="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
          <div className="col-md-4">
              <label>First name:</label>
              <input type="text" className="form-control"
              name="firstName"
              defaultValue={this.state.profileData.firstName || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-4">
              <label>Last name:</label>
              <input type="text" className="form-control" name="lastname"
               defaultValue={this.state.profileData.lastname || ""}
              onChange={this.handleChange}/>
            </div>
            {/* <div className="col-md-4">
              <label>Email:</label>
              <input type="text" className="form-control" name="email" value={this.state.profileData.email || ""}
              onChange={this.handleChange}/>
            </div> */}
            <div className="col-md-4">
              <label>Username:</label>
              <input type="text" className="form-control" name="email" value={this.state.profileData.email || ""}
              onChange={this.handleChange}/>
            </div>
            <div className="col-md-4">
              <label>User Type:</label>
              <select className="form-control" name="userType" value={this.state.profileData.userType || ""}
              onChange={this.handleChange} >
               <option>--Select Type--</option>
                <option value="STUDENT">Student</option>
                <option value="FACULTY">Faculty</option>
              </select>
            </div>
            <div className="col-md-4">
              <label>Major:</label>
              <input type="text" className="form-control" name="major" defaultValue={this.state.profileData.major || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>CGPA:</label>
              <input type="text" className="form-control" name="gpa" defaultValue={this.state.profileData.gpa || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>City:</label>
              <input type="text" className="form-control" name="city" defaultValue={this.state.profileData.city || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>Resume Upload:</label>
              <input type="file" className="form-control" />
            </div>
            <div className="col-md-4">
              <br/>
              <button className="btn btn-warning">
                <span>Update</span>
              </button>
            </div>
          </div>
        </form>
        <ToastContainer />
      </div>
    );
  }
}
