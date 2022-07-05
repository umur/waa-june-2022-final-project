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
            <a href='https://reactjs.org' className="brand ms 1">
                <img src={logo} className="App-logo" alt="logo" />
            </a>
            <div className="navbar-nav me-auto">
                {currentUser?.roles[0] === Role.USER &&
                    <li className="nav-item">
                        <NavLink to="/profile" className="nav-link">
                            User Dashboard
                        </NavLink>
                    </li>
                }
                {currentUser?.roles[0] === Role.ADMIN &&
                    <li className="nav-item">
                        <NavLink to="/admin" className="nav-link">
                            Admin Dashboard
                        </NavLink>
                    </li>
                }
                <li className="nav-item">
                    <NavLink to="/home" className="nav-link">
                        Home
                    </NavLink>
                </li>

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