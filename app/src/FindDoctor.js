import React, { Component } from 'react';
import { BrowserRouter as Router, withRouter, Link, Redirect } from 'react-router-dom';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavBar from './AppNavBar';
import './FindDoctor.css';


class FindDoctor extends Component {



    constructor(props) {
        super(props);
        if(this.props.location.state != undefined){
        const diagnosis = this.props.location.state.diagnosis;

        var s = (JSON.stringify(diagnosis));
        s = s.substring(1, s.indexOf(','))
        s = s.substring(1, s.length - 1)
        if (s.length > 0) {
            this.state = {
                item: {
                    name: '',
                    address: '',
                    city: '',
                    state: '',
                    country: '',
                    postalCode: '',
                    speciality: s
                },
                redirect: false
            };
        }
        }
        // this.state = {
        //     item: {
        //         name: '',
        //         address: '',
        //         city: '',
        //         state: '',
        //         country: '',
        //         postalCode: '',
        //         speciality: ''
        //     },
        //     redirect: false
        // };
   
       
        else{
            this.state = {
                    item: {
                        name: '',
                        address: '',
                        city: '',
                        state: '',
                        country: '',
                        postalCode: '',
                        speciality: ''
                    },
                    redirect: false
                }; 
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }



    async handleSubmit(event) {
        event.preventDefault();
        const { item } = this.state;
        this.setState({ item: item, redirect: true })

    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = { ...this.state.item };
        item[name] = value;
        this.setState({ item: item, redirect: false });
    }

    render() {
        const { item, redirect } = this.state;
        console.log(item.speciality);
        //console.log(item.speciality);
        if (redirect) {
            return <Redirect to={{
                pathname: '/display',
                state: { id: item }
            }}
            />;
        }

        this.state.redirect = false;


        return (
            <div>
                <AppNavBar />
                <div>
                    <body>
                        <Form onSubmit={this.handleSubmit} id = "form">
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
                                    <Button color="secondary" type="submit" id="buttons">Submit</Button>{' '}
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


