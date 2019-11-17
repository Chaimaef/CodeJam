import React, { Component } from 'react';
import './App.css';
import AppNavBar from './AppNavBar';
import { BrowserRouter as Router } from 'react-router-dom';
import { Container} from 'reactstrap';
import { Link} from 'react-router-dom';


class App extends Component {
  state = {
    isLoading: true,

  };

  async componentDidMount() {
    const response = await fetch('/api/hello');
    const body = await response.json();
    this.setState({ hello: body, isLoading: false });
  }


  render() {
    const { isLoading } = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }


    return (
      <div>
        <Router>
          <AppNavBar />
        </Router>
          <div className="App" id="here">
              <Container className="wrapper">
                <Link to='/find'><button type="button" id="choices" className="btn btn-secondary btn-lg">Find a doctor</button></Link>
                <Link to='/diagnosis'><button type="button" id="choices" className="btn btn-secondary btn-lg" >Get a diagnosis</button></Link>
              </Container>
        </div>
      </div>
    );
  }
}


export default (App);

