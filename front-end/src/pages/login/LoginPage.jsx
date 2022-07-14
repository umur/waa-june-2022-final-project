import React from 'react'
import { useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate } from 'react-router-dom';
import './LoginPage.css'
import User from '../../models/User';
import Authentication from '../../service/authentication';
import { useDispatch, useSelector } from 'react-redux';
import { setCurrentUser } from '../../store/actions/user'

const LoginPage = () => {

    const [user, setUser] = useState(new User('', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');
    const [username, setUsername] = useState();
    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();
    const dispatch = useDispatch();

    //mount
    useEffect(() => {
        if (currentUser?.id) {
            navigate('/profile');
        }
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;

        setUser((prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }));

    }

    const handleLogin = (e) => {
        e.preventDefault();
        setSubmitted(true);

        if (!user.username || !user.password) {
            return;
        }

        setLoading(true);

        Authentication.login(user).then(response => {
            //set user in session
            if (response.data.mfa) {
                navigate('/verify', { state: { username: user.username, password: user.password } })
            } else {
                dispatch(setCurrentUser(response.data));
                navigate('/profile');
            }
        }).catch(err => {
            console.log(err);
            if (err.response.status === 500) {
                setErrorMessage("Oops something wrong!")
            } else {
                setErrorMessage(err.response.data.message);
            }
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
                    onSubmit={(e) => handleLogin(e)}
                    noValidate
                    className={submitted ? 'was-validated' : ''}>
                    <div className="form-group">
                        <label htmlFor="username">Username: </label>
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
                        <label htmlFor="password">Password: </label>
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

                    <button
                        className="btn btn-info w-100 mt-3"
                        disabled={loading}>
                        Sign In
                    </button>
                </form>
                <Link to="/signup" className="btn btn-link" style={{ color: 'darkgray' }}>
                    Create New Account!
                </Link>
                <Link to="/forgot" className="btn btn-link" style={{ color: 'darkgray' }}>
                    Forgot password!
                </Link>
            </div>
        </div>
    )
}

export { LoginPage }