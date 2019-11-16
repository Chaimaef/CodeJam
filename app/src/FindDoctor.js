import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, withRouter, Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavBar from './AppNavBar';
import './FindDoctor.css';
import { empty } from 'rxjs';
import { throwStatement } from '@babel/types';


class FindDoctor extends Component {

    // getSymptoms() {
    //     const response = fetch('http://localhost:8080/api/symptoms')
    //         // .then(response =>  {
    //         // console.log(response.json());
    //         //const body = response.json();
    //         .then(response => response.json())
    //         .then(response => {
    //             this.setState ({item: {
    //                 name: '',
    //                 address: '',
    //                 city: '',
    //                 state: '',
    //                 country: '',
    //                 postalCode: '',
    //                 speciality: ''
    //             } , data: response});
    //             this.render();
    //         })
    //         .catch(err => {
    //             console.log(err);
    //             // throw new Error(err)
    //         })
    // }


   


    constructor(props) {
        super(props);
        this.state = {
            item: {
                name: '',
                address: '',
                city: '',
                state: '',
                country: '',
                postalCode: '',
                speciality: ''
            }
        };
        this.handleChange = this.handleChange.bind(this);

    }


    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = { ...this.state.item };
        item[name] = value;
        this.setState({ item });
    }

    render() {
        const { item, data } = this.state;
        console.log(data);
        return (
            <div>
                <Router>
                    <AppNavBar/>
                </Router>
                <div>
                    <body>
                        {/* <Form onSubmit={this.handleSubmit}> */}
                        <Form>
                            <FormGroup>
                                <Label for="name">Name</Label>
                                <Input type="text" name="name" id="name" value={item.name || ''}
                                    onChange={this.handleChange} autoComplete="name" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="address">Address</Label>
                                <Input type="text" name="adress" id="address" value={item.adress || ''}
                                    onChange={this.handleChange} autoComplete="adress" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="city">City</Label>
                                <Input type="text" name="city" id="city" value={item.city || ''}
                                    onChange={this.handleChange} autoComplete="city" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="state">State</Label>
                                <Input type="text" name="state" id="state" value={item.state || ''}
                                    onChange={this.handleChange} autoComplete="state" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="name">Postal Code</Label>
                                <Input type="text" name="postalCode" id="postalCode" value={item.postalCode || ''}
                                    onChange={this.handleChange} autoComplete="postalCode" />
                            </FormGroup>

                            <FormGroup>
                                <Label for="name">Speciality</Label>
                                <Input type="text" name="speciality" id="speciality" value={item.speciality || ''}
                                    onChange={this.handleChange} autoComplete="speciality" />
                            </FormGroup>

                            <FormGroup  >
                                <div id="confirm">
                                    <Button color="primary" type="submit" id="buttons" onClick={this.get}>Submit</Button>{' '}
                                    <Button color="secondary" tag={Link} to="/" id="buttons">Cancel</Button>
                                </div>
                            </FormGroup>

                        </Form>
                    </body>
                </div>
            </div>
        );
    }
}

export default withRouter(FindDoctor);


