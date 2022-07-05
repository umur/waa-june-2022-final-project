import React, { useState, useEffect } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate } from 'react-router-dom';
import User from '../../models/User';
import './SignupPage.css'
import { useSelector } from 'react-redux';
import Authentication from '../../service/authentication';

const SignupPage = () => {

    // need to implement user class
    const [user, setUser] = useState(new User('', '', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");
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
        const { name, value } = e.target;

        setUser((prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }));
    }

    //handle register
    const handleRegister = (e) => {
        e.preventDefault();
        setSubmitted(true);

        //validation
        if (!user.username || !user.password || !user.email) {
            return;
        }

        setLoading(true);

        Authentication.register(user).then(u => {
            navigate('/login');
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