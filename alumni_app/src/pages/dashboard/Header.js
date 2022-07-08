import { Divider, List, makeStyles } from "@material-ui/core";
import { ListItem, Stack } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import ProfileMenu from "../profile/ProfileMenu";

const useStyles = makeStyles((theme) => ({
  navlinks: {
    marginLeft: theme.spacing(10),
    display: "flex",
  },
  link: {
    textDecoration: "none",
    color: "white",
    fontSize: "15px",
    // marginLeft: theme.spacing(1),
    "&:hover": {
      color: "yellow",
      borderBottom: "1px solid white",
    },
  },
}));

export default function Header() {
  const classes = useStyles();
  return (
    <div className="">
      <Stack
        direction="row"
        divider={<Divider orientation="vertical" flexItem />}
        spacing={1}
      >
        <ListItem>
          <Link to="/" className={classes.link}>Dashboard</Link>
        </ListItem>
        <ListItem>
          <Link to="/Students" className={classes.link}>Student</Link>
        </ListItem>
        <ListItem>
          <Link to="/Faculties" className={classes.link}> Faculty </Link>
        </ListItem>
        <ListItem>
          <Link to="/Jobs" className={classes.link}>Jobs</Link>
        </ListItem>
        <ListItem>
          <ProfileMenu />
        </ListItem>
      </Stack>
    </div>
  );
}
