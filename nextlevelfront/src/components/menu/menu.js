import React from 'react';
import Button from '@material-ui/core/Button';
import ClickAwayListener from '@material-ui/core/ClickAwayListener';
import Grow from '@material-ui/core/Grow';
import Paper from '@material-ui/core/Paper';
import Popper from '@material-ui/core/Popper';
import MenuItem from '@material-ui/core/MenuItem';
import MenuList from '@material-ui/core/MenuList';
import { makeStyles } from '@material-ui/core/styles';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHome, faQuestionCircle, faSignOutAlt } from '@fortawesome/free-solid-svg-icons'

import './menu.css';

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    position: 'absolute',
    height: '100%',
    width: '15%'
  },
  paper: {
    width: '100%'
  },
  logo: {
    textAlign: 'center',
    padding: '2vh',
    color: '#0044E9'
  },
}));

export default function MenuListComposition() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const anchorRef = React.useRef(null);

  const handleToggle = () => {
    setOpen((prevOpen) => !prevOpen);
  };

  const handleClose = (event) => {
    if (anchorRef.current && anchorRef.current.contains(event.target)) {
      return;
    }

    setOpen(false);
  };

  function handleListKeyDown(event) {
    if (event.key === 'Tab') {
      event.preventDefault();
      setOpen(false);
    }
  }

  const prevOpen = React.useRef(open);
  React.useEffect(() => {
    if (prevOpen.current === true && open === false) {
      anchorRef.current.focus();
    }

    prevOpen.current = open;
  }, [open]);

  return (
    <div className={classes.root}>
      <Paper className={classes.paper}>
        <h1 className={classes.logo}>NextLevel</h1>  
        <MenuList>
          <MenuItem selected="true" className="menuItem"><h3 className="espacoClass"><FontAwesomeIcon icon={faHome} />Profile</h3></MenuItem>
          <MenuItem className="menuItem"><h3 className="espacoClass"><FontAwesomeIcon icon={faQuestionCircle}/>Sobre</h3></MenuItem>
          <MenuItem className="menuItem"><h3 className="espacoClass"><FontAwesomeIcon icon={faSignOutAlt} />Sair</h3></MenuItem>
        </MenuList>
      </Paper>
    </div>
  );
}
