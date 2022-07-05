import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
    return (
        <ul>
            <li>
                <Link to='/'>HomePage</Link>
            </li>
        </ul>
    )
}