import jwt_decode from "jwt-decode";

export const isAdmin = () => {
    return getRole()==='ADMIN'
}

export const isStudent = () => {
    return getRole()==='STUDENT';
}

export const isFaculty = () => {
    return getRole()==='FACULTY';
}

export const getRole = () => {
    return jwt_decode(JSON.parse(localStorage.getItem("token")).accessToken).authorities;
}

export const getUsername = () => {
    return jwt_decode(JSON.parse(localStorage.getItem("token")).accessToken).username;
}

