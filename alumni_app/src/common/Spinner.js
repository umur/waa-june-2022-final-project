import React from "react";

export default function Spinner() {
    return (
        <>
            <div className="d-flex justify-content-center">
                <div className="spinner-border loader" role="status">
                    <span className="sr-only"></span>
                </div>
            </div>
        </>

    )
}