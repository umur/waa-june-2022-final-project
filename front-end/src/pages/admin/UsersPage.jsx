import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react'
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import Loading from '../../components/loading';
import usersAdmin from '../../service/users-admin';
import Modal from 'react-bootstrap/Modal'

const UsersPage = () => {
    const [usersList, setUsersList] = useState([]);
    const [isLoaded, setIsLoaded] = useState(false)
    const currentUser = useSelector(state => state.user)

    const navigate = useNavigate()

    useEffect(() => {
        if (currentUser?.id) {
            usersAdmin.findAll().then(resp => {
                setUsersList(resp.data.filter((item) => item.roles[0].name != 'ROLE_ADMIN'))
                setIsLoaded(true)
            })
        }
    }, [])

    const onClickedReset = (e, id) => {
        console.log(e);
        console.log(id);
        // if (currentUser?.id) {
        //     usersAdmin.changePass(id, )
        // }
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
                                                <button
                                                    onClick={(e) => {
                                                        onClickedReset(e, item.id)
                                                    }}
                                                    className="btn btn-primary me-1">
                                                    Reset password
                                                </button>
                                                {
                                                    item.active ? <button className="btn btn-danger">Deactivate</button> : <button className="btn btn-info">Activate</button>
                                                }
                                            </td>
                                        </tr>
                                    )}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export { UsersPage }