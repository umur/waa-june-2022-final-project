import React from 'react'
import logo from '../logo.svg'
import loading from './loading.css'

const Loading = () => {
    return (
        <div className="container">
            <div className="ms-auto">
                <h3>Loading...<img src={logo} alt="logo" className='App-logo logo-size' /></h3>
            </div>

        </div>
    )
}

export default Loading