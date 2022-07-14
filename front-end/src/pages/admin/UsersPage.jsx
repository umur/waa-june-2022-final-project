import React from 'react'
import { useEffect } from 'react';
import { useState, useRef } from 'react'
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import Loading from '../../components/loading';
import usersAdmin from '../../service/users-admin';
import { ChangePassword } from '../../components/changePassword';

const UsersPage = () => {
    const [usersList, setUsersList] = useState([]);
    const [isLoaded, setIsLoaded] = useState(false)
    const [errorMessage, setErrorMessage] = useState()
    const currentUser = useSelector(state => state.user)

    const saveComponent = useRef();

    const navigate = useNavigate()

    useEffect(() => {
        if (currentUser?.id) {
            usersAdmin.findAll().then(resp => {
                setUsersList(resp.data.filter((item) => item.roles[0].name != 'ROLE_ADMIN'))
                setIsLoaded(true)
            }).catch((err) => {
                setErrorMessage('Unexpected error!')
                console.log(err);
            })
        }
    }, [])

    const updatePassword = (e, id) => {
        // e.preventDefault();
        saveComponent.current?.showPasswordModal(id);
    }

    const deActivate = (id) => {
        if (currentUser?.id) {
            usersAdmin.deactivate(id).then(resp => {
                console.log(resp.data);
            }).catch((err) => {
                setErrorMessage('Unexpected error!')
                console.log(err);
            })
        }
    }

    const activate = (id) => {
        if (currentUser?.id) {
            usersAdmin.activate(id).then(resp => {
                console.log(resp.data);
            }).catch((err) => {
                setErrorMessage('Unexpected error!')
                console.log(err);
            })
        }
    }


    if (!isLoaded) {
        return (
            <Loading></Loading >
        )
    } else if (isLoaded) {
        return (
            <div className="container">
                <div className="pt-5">
                    <div className="card">
                        <div className="card-header">
                            <div className="row">
                                <div className="col-6">
                                    <h3>All Users</h3>
                                </div>
                            </div>
                        </div>
                        <div className="card-body">
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">First Name</th>
                                        <th scope="col">Last Name</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Is Active</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {usersList.map((item, ind) =>
                                        <tr key={item.id}>
                                            <th scope="row">{ind + 1}</th>
                                            <td>{item.roles[0].name ?? ""}</td>
                                            <td>{item.firstName ?? ""}</td>
                                            <td>{item.lastName ?? ""}</td>
                                            <td>{item.email ?? ""}</td>
                                            <td>{item.active ? 'Yes' : 'No'}
                                            </td>
                                            <td>
                                                {/* <form> */}
                                                <button
                                                    onClick={() => updatePassword(item.id)}
                                                    className="btn btn-primary me-1">
                                                    Reset password
                                                </button>

                                                {
                                                    item.active ?
                                                        <button type="submit" onClick={() => deActivate(item.id)} className="btn btn-danger">Deactivate</button>
                                                        :
                                                        <button onClick={() => activate(item.id)} className="btn btn-info">Activate</button>
                                                }
                                                {/* </form> */}
                                            </td>
                                        </tr>
                                    )}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <ChangePassword ref={saveComponent}></ChangePassword>
            </div>
        )
    }
}

export { UsersPage }