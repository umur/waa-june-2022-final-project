import React from 'react'
import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import profile from '../../service/profile';

const ProfilePage = () => {

    const [me, setMe] = useState({});
    const [role, setRole] = useState({});
    const [isActive, setIsActive] = useState({});
    const currentUser = useSelector(state => state.user);

    useEffect(() => {
        if (currentUser?.id) {
            profile.getMe().then(resp => {
                setMe(resp.data);
                setRole(resp.data.roles[0])
            }).catch(err => {
                console.log(err);
            })

        }
    }, [])

    return (
        <div className="container mt-3">
            <h3>{me.id}</h3>
            <h3>{me.username}</h3>
            <h3>{me.email}</h3>
            <h3>{me.active}</h3>
            <h3>{me.last_logged}</h3>
            <h3>{role.name}</h3>
        </div>
    )
}

export { ProfilePage }