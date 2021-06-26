import React, { Component } from 'react';
import {Button} from '@material-ui/core';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Row, Col } from 'react-bootstrap';
import './botsgrid.css';
import api from '../../api';

class BotsGrid extends Component {
    state = {
        profiles: [],
      }
    
      async componentDidMount() {
        const response = await api.get('');
    
        this.setState({ profiles: response.data });
      }
    
      render() {
    
        const { profiles } = this.state;
    
        return(
            <Row>
                <Col><img width="70%" src={"https://vignette4.wikia.nocookie.net/ironman/images/e/ee/Photo(696).jpg/revision/latest?cb=20130922104708"}/></Col>
                <Col>
                    <h1 className="nomeProfile">Nome Completo</h1>
                    <h2 className="titulo2Profile">(99) 9 9999-9999</h2>
                    <h2 className="titulo2Profile">mail@email.com</h2>
                    <h2 className="titulo2Profile">22/07/1970</h2>
                    <Button className="botaoCard">Enviar para uma empresa</Button>
                </Col>
            </Row>
        )
      };

}
export default BotsGrid