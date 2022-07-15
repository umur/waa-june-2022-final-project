const user = JSON.parse(localStorage.getItem("user"));
class LoginInfo {
    isLogin() {
        return user ? true : false;
    }

    token() {
        return user ? user.access_token : "";
    }

    userType() {
        return user ? user.userType : "";
    }

    username() {
        return user ? user.username : "";
    }
}

export default new LoginInfo();