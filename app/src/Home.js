import React, { Component } from 'react';
import './App.css';
import App from './App';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import FindDoctor from './FindDoctor';
import GetDiagnosis from './GetDiagnosis';
import DisplayDoctors from './DisplayDoctors';


class Home extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={App}/>
          <Route path='/find' exact={true} component={FindDoctor}/>
          <Route path='/diagnosis' exact={true} component={GetDiagnosis}/>
          <Route path='/display' exact={true} component={DisplayDoctors}/>
        </Switch>
      </Router>
    )
  }
}

export default Home;