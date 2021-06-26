import React, { Component } from 'react';
import './login.css';
import {FormControl, Button, Input, Container, CardContent} from '@material-ui/core';
import api from '../../api';

class Login extends Component {

    render() {
       
        return(
            <Container className="containerLogin">
                <CardContent className="contentLogin">
                  <div className="formLogin">
                    <FormControl>
                        <h1 className="mudar">NextLevel</h1>
                        <h2> Faça seu logon</h2>
    
                        <Input disable="false" name="login" placeholder="Login" className="inputLogin"/>
                        </FormControl>
                        <Input name="password" type="password" placeholder="Senha" className="inputLogin" />
                        <FormControl className="formLogin">
                    </FormControl>
                    </div>
                    <Button className="botaoLogin" type="submit">Entrar</Button>
                </CardContent>
            </Container>
        )
    }
    
}

export default Login;