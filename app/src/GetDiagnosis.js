import React, { Component } from 'react';
import { BrowserRouter as Router, withRouter, Link, Redirect } from 'react-router-dom';
import AppNavBar from './AppNavBar';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import './GetDiagnosis.css'

class GetDiagnosis extends Component {

    constructor(props) {
        super(props);
        this.state = {
            data: null,
            checked: [],
            redirect: false
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.getSymptoms = this.getSymptoms.bind(this);
        this.getSymptoms();
    }

    getSymptoms() {
        const response = fetch('http://localhost:8080/api/symptoms')
            .then(response => response.json())
            .then(response => {
                this.setState({
                    data: response,
                    checked: [],
                    redirect: false
                });
            })
            .catch(err => {
                console.log(err);
            })
    }


    async handleSubmit(event) {
        event.preventDefault();
        const { item, checked, redirect } = this.state;
        this.setState({ data: item, checked: checked, redirect: true })


    }

    handleChange(event) {
        const item = this.state.data;
        var checked = this.state.checked;
        if (!checked.includes(event.target.name)) {
            checked.push(event.target.name);
        }
        else {
            checked = checked.filter(function (element) {
                return element != event.target.name;
            });
        }
        this.setState({ data: item, checked: checked, redirect: false });
    }


    render() {
        const symptoms = this.state.data;
        const redirect = this.state.redirect;
        //console.log(this.state.checked);

        if (redirect) {
            return <Redirect to={{
                pathname: '/verdict',
                state: { id: this.state.checked }
            }}
            />;
          }

          this.state.redirect=false;


        return (
            <div>
                <Router>
                    <div>
                        <AppNavBar />
                    </div>
                </Router>
                <div>
                    {symptoms !== null ?
                        (<div> {symptoms.map(symptom =>
                            <div>
                                <FormGroup >
                                    <Label for={symptom.Name} className="group">{symptom.Name} </Label>
                                    <Input type="checkbox" name={symptom.Name} id={symptom.Name}
                                        onChange={this.handleChange} />
                                </FormGroup>
                            </div>
                        )} </div>)
                        : (<div>loading...</div>)
                    }
                </div>

                <FormGroup  >
                    <div id="confirm">
                        <Button color="primary" type="submit" id="buttons">Submit</Button>{' '}
                        <Button color="secondary" tag={Link} to="/" id="buttons">Cancel</Button>
                    </div>
                </FormGroup>
            </div>

        );
    }
}

export default withRouter(GetDiagnosis);









