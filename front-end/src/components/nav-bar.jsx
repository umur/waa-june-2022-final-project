import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import logo from '../logo.svg'
import { clearCurrentUser } from '../store/actions/user'
import { Role } from '../models/Role'

const NavBar = () => {

    const currentUser = useSelector(state => state.user);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const logOut = () => {
        dispatch(clearCurrentUser());
        navigate('/login');
    }

    return (
        <nav className="navbar navbar-expand navbar-dark bg-dark">
            <a href='/home' className="brand ms 1">
                <img src={logo} className="App-logo" alt="logo" />
            </a>
            <div className="navbar-nav me-auto">
                {currentUser?.roles[0] === Role.STUDENT &&
                    <li className="nav-item">
                        <NavLink to="/profile" className="nav-link">
                            Dashboard
                        </NavLink>
                    </li>
                }

                {currentUser?.roles[0] === Role.STUDENT &&
                    <li className="nav-item">
                        <NavLink to="/jobs" className="nav-link">
                            Job Advertisement
                        </NavLink>
                    </li>
                }
                {currentUser?.roles[0] === Role.STUDENT &&
                    <li className="nav-item">
                        <NavLink to="/charts" className="nav-link">
                            Charts
                        </NavLink>
                    </li>
                }


                {currentUser?.roles[0] === Role.ADMIN &&
                    <li className="nav-item">
                        <NavLink to="/users" className="nav-link">
                            Registered Users
                        </NavLink>
                    </li>
                }

                {currentUser?.roles[0] === Role.ADMIN &&
                    <li className="nav-item">
                        <NavLink to="/charts" className="nav-link">
                            Charts
                        </NavLink>
                    </li>
                }

                {currentUser?.roles[0] === Role.FACULTY &&
                    <li className="nav-item">
                        <NavLink to="/students" className="nav-link">
                            Students
                        </NavLink>
                    </li>
                }
                {currentUser?.roles[0] === Role.FACULTY &&
                    <li className="nav-item">
                        <NavLink to="/jobs" className="nav-link">
                            Job Advertisement
                        </NavLink>
                    </li>
                }
                {currentUser?.roles[0] === Role.FACULTY &&
                    <li className="nav-item">
                        <NavLink to="/applied-jobs" className="nav-link">
                            Recently Applied Job
                        </NavLink>
                    </li>
                }
                {currentUser?.roles[0] === Role.FACULTY &&
                    <li className="nav-item">
                        <NavLink to="/charts" className="nav-link">
                            Charts
                        </NavLink>
                    </li>
                }
            </div>

            {!currentUser &&
                <div className="navbar-nav ms-auto">
                    <li className="nav-item">
                        <NavLink to="signup" className="nav-link">
                            Sign Up
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="login" className="nav-link">
                            Sign In
                        </NavLink>
                    </li>
                </div>
            }

            {currentUser &&
                <div className="navbar-nav ms-auto">
                    <li className="nav-item">
                        <NavLink to="/profile" className="nav-link">
                            {currentUser.username}
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <a href="#" className="nav-link" onClick={() => logOut()}>Sign Out</a>
                    </li>
                </div>
            }
        </nav>
    )
}

export { NavBar }