export default class User {
    constructor(username, password, email, role, mfa, token, id) {
        this.username = username
        this.password = password
        this.email = email
        this.role = role
        this.mfa = mfa
        this.token = token
        this.id = id
    }
}