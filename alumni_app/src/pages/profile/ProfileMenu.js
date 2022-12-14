import * as React from "react";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import { Avatar } from "@material-ui/core";
import { Link, useNavigate } from "react-router-dom";
import Cookies from 'js-cookie';
import { AUTHCONTEXT } from "../../App";

export default function ProfileMenu() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const navigate = useNavigate();
  const {setAuth} = React.useContext(AUTHCONTEXT)
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleEditProfile = () => {
    navigate("/Profile");
  };

  const handleChangePassword = () => {
    navigate("/reset-password");
  };

  const handleUploadCV= () =>{
    navigate("/cv");
  }

  const handleLogout = () => {
    Cookies.remove('token');
    setAuth(undefined);
  };

  return (
    <div>
      <Avatar
        alt="Profile image not"
        src=""
        onClick={handleClick}
        sx={{ width: 30, height: 30 }}
      />
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          "aria-labelledby": "basic-button",
        }}
      >
        <MenuItem
          onClick={handleUploadCV}
          LinkComponent={Link}
          href="/cv"
        >
          Upload CV
        </MenuItem>

        <MenuItem
          onClick={handleEditProfile}
          LinkComponent={Link}
          href="/Profile"
        >
          Edit Profile
        </MenuItem>
        <MenuItem onClick={handleChangePassword}>Change Password</MenuItem>
        <MenuItem onClick={handleLogout}>Logout</MenuItem>
      </Menu>
    </div>
  );
}
