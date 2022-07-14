import React, { useState, useEffect } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate, Navigate } from 'react-router-dom';
import User from '../../models/User';
import { Form, Input, Button, notification, Checkbox } from "antd";
import './SignupPage.css'
import { useSelector } from 'react-redux';
import Authentication from '../../service/authentication';

const SignupPage = (props) => {

    // need to implement user class
    const [user, setUser] = useState(new User('', '', '', '', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
    const [redirect, setRedirect] = useState();
    const [qrImageUrl, setQrImageUrl] = useState();
    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();

    //mount effect
    useEffect(() => {
        if (currentUser?.id) {
            navigate('/profile');
        }
    }, [])

    //input onChange(event => handleChange(event))
    const handleChange = (e) => {
        const { name, value, checked } = e.target;

        setUser((prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }));
    }

    const handleCheck = (e) => {
        const { name, checked } = e.target
        setUser((prevState => {
            return {
                ...prevState,
                [name]: checked
            }
        }))
    }
    //handle register
    const handleRegister = (e) => {
        e.preventDefault();
        setSubmitted(true);

        //validation
        if (!user.username || !user.password || !user.email || !user.role) {
            return;
        }

        setLoading(true);

        //         const navigate = useNavigate();
        // navigate('/other-page', { state: { id: 7, color: 'green' } });

        Authentication.register(user).then(u => {
            if (u.data.mfa) {
                console.log(u);
                setQrImageUrl(u.data.secretImageUri)
                navigate('/qrcode', { state: { imageUrl: u.data.secretImageUri } })
            } else {
                navigate('/login')
            }
            // navigate('/login');
        }).catch(err => {
            console.log(err);
            setErrorMessage(err.response.data.message)
            // if (err?.response?.status === 409) {
            //     setErrorMessage('Username already exists');
            // } else {
            //     setErrorMessage('Unexpected error');
            // }

            setLoading(false);
        })
    }

    // if (redirect) {
    //     return (
    //         <Navigate to={{ pathname: redirect, state: { imageUrl: qrImageUrl } }} />
    //     )
    // }

    return (
        <div className="container mt-5">
            <div className="card ms-auto me-auto p-3 shadow-lg custom-card">
                <FontAwesomeIcon icon={faUserCircle} className="ms-auto me-auto user-icon" />

                {errorMessage &&
                    <div className="alert alert-danger">
                        {errorMessage}
                    </div>
                }

                <form
                    onSubmit={(e) => handleRegister(e)}
                    noValidate
                    className={submitted ? 'was-validated' : ''}>
                    <div className="form-group">
                        <label htmlFor="name">Username: </label>
                        <input
                            type="text"
                            className="form-control"
                            name="username"
                            placeholder="username"
                            value={user.username}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Username is required.
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email: </label>
                        <input
                            type="email"
                            className="form-control"
                            name="email"
                            placeholder="email"
                            value={user.email}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Email is required.
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="Password">Password: </label>
                        <input
                            type="password"
                            className="form-control"
                            name="password"
                            placeholder="password"
                            value={user.password}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Password is required.
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="Password">Role: </label>
                        <select
                            className="form-select"
                            name='role'
                            value={user.role}
                            onChange={(e) => handleChange(e)}
                            required>
                            <option value=''>Select Role</option>
                            <option value="student">Student</option>
                            <option value="faculty">Faculty</option>
                        </select>
                        <div className="invalid-feedback">
                            Role is required.
                        </div>
                    </div>
                    {/* <Form.Item name="mfa" valuePropName="checked">
                        <Checkbox>Enable two-factor authentication</Checkbox>
                    </Form.Item> */}
                    <div className="form-check">
                        <input
                            className="form-check-input"
                            type="checkbox"
                            name="mfa"
                            onChange={(e) => handleCheck(e)}
                            value={user.mfa} />
                        <label className="form-check-label">
                            Use 2Factor
                        </label>
                    </div>

                    <button className="btn btn-info w-100 mt-3"
                        disabled={loading}>
                        Sign Up
                    </button>

                </form>
                <Link to="/login" className="btn btn-link" style={{ color: 'darkgray' }}>
                    I have an Account!
                </Link>
            </div>
        </div>
    )
}

export { SignupPage }