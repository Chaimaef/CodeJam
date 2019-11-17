import React, { Component } from 'react';
import { BrowserRouter as Router, withRouter } from 'react-router-dom';
import AppNavBar from './AppNavBar';
import './DisplayDoctors.css';

class DisplayDiagnosis extends Component {

    constructor(props) {
        super(props);
        this.state = {
            diagnosis: null
        };
        this.getDiagnosis = this.getDiagnosis.bind(this);
        const list = this.getDiagnosis(this.props.location.state.id);
        this.setState({ diagnosis: list });
    }


    getDiagnosis(item) {
       fetch('http://localhost:8080/api/doctors/' + item.speciality + '/' + item.city)
            .then(response => response.json())
            .then(response => {
                this.setState({ diagnosis: response });
            })
    }


    render() {
        const diagnosis = this.state.diagnosis;
        console.log(this.state.diagnosis);
        //
        return (
            <div>
                <Router>
                    <div>
                        <AppNavBar />
                    </div>
                </Router>
                <body>
                    <div>

                    {diagnosis !== null ?
                                    ( <div> {diagnosis.map(symtpom =>
                                        <div>
                                          {symtpom.Name}
                                        </div>
                                      )} </div> )
                                    : (<div>loading...</div>)
                                }

                    </div>

                </body>
            </div>
        );

    }
}

export default withRouter(DisplayDiagnosis);