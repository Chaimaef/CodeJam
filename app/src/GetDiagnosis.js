import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavBar from './AppNavBar';

class GetDiagnosis extends Component {

    
    render() {
    
      return (
        <Router>
        <div>
          <AppNavBar/>
          <body>
           <p>Hello World</p>
          </body>
        </div>
        </Router>
      );
     }
}

export default withRouter(GetDiagnosis);