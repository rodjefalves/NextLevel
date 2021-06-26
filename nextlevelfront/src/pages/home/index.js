import React, { Component } from 'react';
import './home.css';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import MenuListComposition from '../../components/menu/menu';
import Card from '../../components/cardApresentacao/cardApresentacao';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
    grids: {
        backgroundColor: '#F2F4F9',
    }
}));

export default function Home() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Grid className={classes.grids} container spacing={3}>
        <Grid item xs={2}>
            <MenuListComposition/>
        </Grid>
        <Grid className={classes.grids} item xs={10}>
            <Card/>
        </Grid>
      </Grid>
    </div>
  );
}