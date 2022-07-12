import React, { useContext, useState } from "react";
import { postRequest, postRequestNoAuth } from "../../setup/fetch-manager/FetchGateway";
import Cookies from 'js-cookie';
import { AUTHCONTEXT } from "../../App";
import { useNavigate } from "react-router";

const initialValues = {
    emailAddress: "",
    password: ""
};

export default function Login() {
    const [values, setValues] = useState(initialValues);
    const { setAuth } = useContext(AUTHCONTEXT)
    const navigate = useNavigate();
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setValues({
            ...values,
            [name]: value,
        });
    };

    const postData = async () => {
        Cookies.remove('token');
        Cookies.remove('role');
        Cookies.remove('id');
        let params = "/login";
        let result = await postRequestNoAuth(params, values);
        if (result != undefined) {
            setAuth(result.token)
            Cookies.set('token', result.token);
            Cookies.set('role', result.role);
            Cookies.set('id', result.id);
            Cookies.set('isAdmin', result.isAdmin);
            Cookies.set('isStudent', result.isStudent);
            Cookies.set('isFaculty', result.isFaculty);
        }
        else{
            alert('Wrong info provided !')
        }
    };

    return (
        <>
            <section className="">
                <div className="container-fluid h-custom ">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-md-9 col-lg-6 col-xl-5">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                                className="img-fluid" alt="Sample image" />
                        </div>
                        <div className="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                            <form>
                                <div className="divider d-flex align-items-center my-4">
                                    <p className="text-center fw-bold mx-3 mb-0">SIGN IN</p>
                                </div>

                                <div className="form-outline mb-4">
                                    <input type="email" id="form3Example3" className="form-control form-control-lg"
                                        placeholder="Enter a valid email address" name="username" onChange={handleInputChange} />
                                    <label className="form-label" >Email address</label>
                                </div>

                                <div className="form-outline mb-3">
                                    <input type="password" id="form3Example4" className="form-control form-control-lg"
                                        placeholder="Enter password" name="password" onChange={handleInputChange} />
                                    <label className="form-label" htmlFor="form3Example4">Password</label>
                                </div>

                                <div className="d-flex justify-content-between align-items-center">
                                    <div className="form-check mb-0">
                                        <input className="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                                        <label className="form-check-label" htmlFor="form2Example3">
                                            Remember me
                                        </label>
                                    </div>
                                    <a href="#!" className="text-body">Forgot password?</a>
                                </div>

                                <div className="text-center text-lg-start mt-4 pt-2">
                                    <button type="button" className="btn btn-primary btn-lg" onClick={postData}>Login</button>
                                    <p className="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="#!"
                                        className="link-danger" onClick={() => { navigate("/Register") }}>Register</a></p>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </section>
            <div className="sigin-In d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
                <div className="text-white ">
                    Copyright © 2020. All rights reserved.
                </div>
                <div>
                    <a href="#!" className="text-white me-4">
                        <i className="fab fa-facebook-f"></i>
                    </a>
                    <a href="#!" className="text-white me-4">
                        <i className="fab fa-twitter"></i>
                    </a>
                    <a href="#!" className="text-white me-4">
                        <i className="fab fa-google"></i>
                    </a>
                    <a href="#!" className="text-white">
                        <i className="fab fa-linkedin-in"></i>
                    </a>
                </div>
            </div>
        </>

    )

}