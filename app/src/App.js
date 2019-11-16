import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import AppNavBar from './AppNavBar';
import FindDoctor from './FindDoctor';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import { Link, withRouter } from 'react-router-dom';


class App extends Component {
  state = {
    isLoading: true,
    hello: ""
  };

  async componentDidMount() {
    const response = await fetch('/api/hello');
    const body = await response.json();
    this.setState({ hello: body, isLoading: false });
  }


  render() {
    const {hello, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }
   

  return (
    <div>
      <Router>
      <AppNavBar/>
      </Router>
      <div>
      <div className="App">
      <body>
      <Container className="wrapper">
      <Link to='/find'><button type="button" id = "choices" class="btn btn-secondary btn-lg">Find a doctor</button></Link>
      <Link to='/diagnosis'><button type="button" id = "choices" class="btn btn-secondary btn-lg" >Get a diagnosis</button></Link>
      </Container>
      </body>
      </div>
    </div>
    </div>
  );
 }
}

export default (App);