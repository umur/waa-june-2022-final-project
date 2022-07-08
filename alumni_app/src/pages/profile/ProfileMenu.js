import * as React from "react";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import { Avatar } from "@material-ui/core";
import { Link, useNavigate } from "react-router-dom";

export default function ProfileMenu() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const navigate = useNavigate();
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

  const handleLogout = () => {};

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
