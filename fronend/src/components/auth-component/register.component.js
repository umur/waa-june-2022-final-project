import React, { Component } from "react";
import { ToastContainer, toast } from 'react-toastify';
import ApiService from "../../services/ApiService";
import Nav from 'react-bootstrap/Nav';
import { Link } from "react-router-dom";

const notify = () => toast.info("Wow so easy!");
export default class Registration extends Component {
  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    debugger;
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
      username: this.state.username,
      password: this.state.password,
      userType: this.state.userType,
      firstname: this.state.firstname,
      lastname: this.state.lastname,
      city: this.state.city,
    };
    ApiService.postData(ApiService.REGISTRATION, data).then(
      (res) => {
        // const navigate = useNavigate();
        // navigate("/job-list");
        // this.props.navigate('/crime');
        toast.success('Data Save Success', {
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
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr />
        <form className="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
          <div className="col-md-4">
              <label>First name:</label>
              <input type="text" className="form-control"
              name="firstname"
              //  value={inputs.description || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>Last name:</label>
              <input type="text" className="form-control" name="lastname"
              //  value={inputs.description || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>Email:</label>
              <input type="text" className="form-control" name="email"
              //  value={inputs.description || ""}
              onChange={this.handleChange} />
            </div>
            <div className="col-md-4">
              <label>Username:</label>
              <input type="text" className="form-control" name="username"
              onChange={this.handleChange}/>
            </div>
            <div className="col-md-4">
              <label>User Type:</label>
              <select className="form-control" name="userType"
              onChange={this.handleChange}>
                <option>--Select Type--</option>
                <option value="STUDENT">Student</option>
                <option value="FACULTY">Faculty</option>
              </select>
            </div>
            <div className="col-md-4">
              <label>Password:</label>
              <input type="password" className="form-control" name="password"
              onChange={this.handleChange}/>
            </div>
            <div className="col-md-4">
              <label>City:</label>
              <input type="text" className="form-control" name="city"
              onChange={this.handleChange}/>
            </div>
            <div className="col-md-12">
              <br/>
              <button className="btn btn-success float-right">
                <span>Registration</span>
              </button>
            </div>
          </div>
        </form>
        <Nav.Link as={Link} to="/login" >login </Nav.Link>

        {/* <button onClick={notify}>Notify!</button> */}
        <ToastContainer />
      </div>
    );
  }
}
