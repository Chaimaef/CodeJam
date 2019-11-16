import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch, withRouter,Link } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavBar from './AppNavBar';
import './FindDoctor.css';


class FindDoctor extends Component {

    emptyItem = {
        name: '',
        address: '',
        city: '',
        state: '',
        country: '',
        postalCode: '',
        symptoms: ''
      };

    constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem
    };
    this.handleChange = this.handleChange.bind(this);
  }


  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }


  async getSymptoms (event){
    await fetch('localhost:8080/api/symptoms', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        
      });
      this.props.history.push('/find');
    }
  

//   async handleSubmit(event) {
//     event.preventDefault();
//     const {item} = this.state;

//     await fetch('/api/', {
//       method: 'POST',
//       headers: {
//         'Accept': 'application/json',
//         'Content-Type': 'application/json'
//       },
//       body: JSON.stringify(item),
//     });
//     this.props.history.push('/find');
//   }


    
    render() {
        const {item} = this.state;
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
                   onChange={this.handleChange} autoComplete="name"/>
               </FormGroup>

               <FormGroup>
               <Label for="address">Address</Label>
               <Input type="text" name="adress" id="address" value={item.adress || ''}
                   onChange={this.handleChange} autoComplete="adress"/>
               </FormGroup>

               <FormGroup>
               <Label for="city">City</Label>
               <Input type="text" name="city" id="city" value={item.city || ''}
                   onChange={this.handleChange} autoComplete="city"/>
               </FormGroup>

               <FormGroup>
               <Label for="state">State</Label>
               <Input type="text" name="state" id="state" value={item.state || ''}
                   onChange={this.handleChange} autoComplete="state"/>
               </FormGroup>

               <FormGroup>
               <Label for="name">Postal Code</Label>
               <Input type="text" name="postalCode" id="postalCode" value={item.postalCode || ''}
                   onChange={this.handleChange} autoComplete="postalCode"/>
               </FormGroup>

               <FormGroup>
               <Label for="name">Symptoms</Label>
               <Input type="text" name="symptoms" id="symptoms" value={item.symptoms || ''}
                   onChange={this.handleChange} autoComplete="symptoms"/>
               </FormGroup>

           
               <FormGroup  >
               <div id="confirm">
                <Button color="primary" type="submit" id="buttons">Submit</Button>{' '}
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
