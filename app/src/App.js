import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import AppNavBar from './AppNavBar';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


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
    <Router>
    <div>
      <AppNavBar/>
     <div className="App">
      <header className="App-header">
        {hello}
      </header>
    </div>
    </div>
    </Router>
  );
 }
}

export default App;
