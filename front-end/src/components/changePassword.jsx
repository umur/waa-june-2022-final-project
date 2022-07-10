import { forwardRef, useImperativeHandle, useState } from "react";
import usersAdmin from "../service/users-admin";
import { Modal } from 'react-bootstrap'

const ChangePassword = forwardRef((props, ref) => {

    useImperativeHandle(ref, () => ({

    }))

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

        usersAdmin.changePass(password).then(resp => {

        }).catch((err) => {
            setErrorMessage('Unexpected error!')
            console.log(err);
        })
    }

    const handleChange = (e) => {
        const { name, value } = e.target

        setPassword((prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }))
    }

    return (
        <Modal show={show}>
            <form>
                <div className="modal-header">
                    <h5 className="modal-title">Password Change</h5>
                    <button type="button" className="btn-close" onClick={() => setShow(false)}></button>
                </div>
                <div className="modal-body">

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