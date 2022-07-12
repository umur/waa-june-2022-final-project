import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router";
import { postRequest, postRequestNoAuth } from "../../setup/fetch-manager/FetchGateway";

const initialvalues = {
    name: "",
    email: "",
    password1: "",
    password2: "",
    role: "",
    agree: false
};

function Register() {

    const [values, setValues] = useState(initialvalues);
    const [isPasswordMatched, setPasswordMatched] = useState(true);
    const navigate = useNavigate();

    const onValueChange = (e) => {


        const { name, value } = e.target;


        setValues({
            ...values,
            [name]: value,
        });

    }

    const postData = async () => {
        let params = "/login/register";
        if (values.password1 != values.password2) {
            setPasswordMatched(false)
        } else {
            setPasswordMatched(true)
            await postRequestNoAuth(params, values);
            navigate('/')
        }

    }
    return (
        <div className="">
            <section className="mt-4" >
                <div className="row d-flex justify-content-center align-items-center">
                    <div className="col-lg-12 col-xl-11">
                        <div className="card text-black" >
                            <div className="card-body ">
                                <div className="row justify-content-center">
                                    <div className="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                        <p className="text-center h1 fw-bold mb-5 ">Sign up</p>

                                        <form className="mx-1 mx-md-4">

                                            <div className="d-flex flex-row align-items-center ">
                                                <i className="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input
                                                        type="text"
                                                        name="name"
                                                        id="form3Example1c"
                                                        className="form-control"
                                                        onChange={onValueChange}
                                                    />
                                                    <label className="form-label" for="form3Example1c">Your Name</label>
                                                </div>
                                            </div>

                                            <div className="d-flex flex-row align-items-center">
                                                <i className="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input
                                                        type="email"
                                                        name="email"
                                                        id="form3Example3c"
                                                        className="form-control"
                                                        onChange={onValueChange}
                                                    />
                                                    <label className="form-label" for="form3Example3c">Your Email</label>
                                                </div>
                                            </div>

                                            <div className="d-flex flex-row align-items-center ">
                                                <i className="fas fa-lock fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input
                                                        type="password"
                                                        name="password1"
                                                        id="form3Example4c"
                                                        className="form-control"
                                                        onChange={onValueChange} />
                                                    <label className="form-label" for="form3Example4c">Password</label>
                                                </div>
                                            </div>

                                            <div className="d-flex flex-row align-items-center ">
                                                <i className="fas fa-key fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <input
                                                        type="password"
                                                        name="password2"
                                                        id="form3Example4cd"
                                                        className="form-control"
                                                        onChange={onValueChange}
                                                    />
                                                    <label className="form-label" for="form3Example4cd">Repeat your password</label>
                                                </div>
                                            </div>


                                            <div className="d-flex flex-row align-items-center ">
                                                <i className="fas fa-key fa-lg me-3 fa-fw"></i>
                                                <div className="form-outline flex-fill mb-0">
                                                    <select
                                                        className="form-select"
                                                        name="role"
                                                        onChange={onValueChange}>
                                                        <option selected>Select Role</option>
                                                        <option
                                                            value="faculty"
                                                            name="role"
                                                        >Faculty</option>
                                                        <option
                                                            value="student"
                                                            name="role"
                                                        >Student</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div className="d-flex flex-row align-items-center mb-4">
                                                <i className="fas fa-key fa-lg me-3 fa-fw"></i>
                                                {(isPasswordMatched ? '' :
                                                    <span className="danger"> Password Milena Bhai</span>
                                                )}
                                            </div>

                                            <br></br>


                                            <div className="form-check d-flex justify-content-center mb-5">
                                                <input
                                                    className="form-check-input me-2"
                                                    name="checked"
                                                    type="checkbox"
                                                    id="form2Example3c"
                                                    onChange={onValueChange}
                                                />
                                                <label className="form-check-label" for="form2Example3">
                                                    I agree all statements in <a href="#!">Terms of service</a>
                                                </label>
                                            </div>

                                            <div className="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                                <button type="button" className="btn btn-primary btn-lg" onClick={postData}>Register</button>
                                            </div>
                                            <a href="#!" className="link-danger" onClick={() => { navigate("/") }}>Login</a>
                                        </form>

                                    </div>
                                    <div className="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                            className="img-fluid" alt="Sample image" />

                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}

export default Register;