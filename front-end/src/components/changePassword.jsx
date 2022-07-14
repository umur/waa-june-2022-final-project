import { forwardRef, useImperativeHandle, useState } from "react";
import usersAdmin from "../service/users-admin";
import { Modal } from 'react-bootstrap'
import { useRef } from "react";

const ChangePassword = forwardRef((props, ref) => {

    useImperativeHandle(ref, () => ({
        showPasswordModal(id) {
            setShow(true)
            setStudentId(id)
        }
    }))

    const [studentId, setStudentId] = useState("")
    const [password, setPassword] = useState("")
    const [errorMessage, setErrorMessage] = useState()
    const [submitted, setSubmitted] = useState(false)
    const [show, setShow] = useState(false)

    const savePassword = (e) => {
        e.preventDefault();
        setSubmitted(true)

        if (!password) {
            return
        }

        let data = { password: password }

        usersAdmin.changePass(studentId, data).then(resp => {
            setShow(false)
            setSubmitted(false)
            console.log(resp.data);
        }).catch((err) => {
            setErrorMessage('Unexpected error!')
            console.log(err);
        })
    }

    const handleChange = (e) => {
        setPassword(e.target.value)
    }

    return (
        <Modal show={show}>
            <form onSubmit={(e) => savePassword(e)}
                noValidate
                className={submitted ? 'was-validated' : ''}>
                <div className="modal-header">
                    <h5 className="modal-title">Password Change</h5>
                    <button type="button" className="btn-close" onClick={() => setShow(false)}></button>
                </div>
                <div className="modal-body">
                    {
                        errorMessage &&
                        <div className="alert alert-danger">
                            {errorMessage}
                        </div>
                    }

                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input
                            type="text"
                            name="password"
                            className="form-control"
                            placeholder="Password"
                            required
                            value={password}
                            onChange={(e) => handleChange(e)}
                        />
                        <div className="invalid-feedback">
                            You should insert new password!
                        </div>
                    </div>

                </div>
                <div className="modal-footer">
                    <button type="button" className="btn btn-secondary" onClick={() => setShow(false)}>Close</button>
                    <button type="submit" className="btn btn-primary">Save changes</button>
                </div>
            </form>
        </Modal>
    )

});

export { ChangePassword }