import React, { Component } from 'react';
import {FormControl, Button, Input, Container, CardContent, Grid} from '@material-ui/core';
import './card.css';
import BotsGrid from '../botsgrid/botsgrid';


function Card(){

    return(
        <Container className="containerCard">
            <CardContent className="contentCard">
                <BotsGrid/>
            </CardContent>
        </Container>
    )
}

export default Card;