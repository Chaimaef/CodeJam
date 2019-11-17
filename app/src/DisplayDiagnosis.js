import React, { Component } from 'react';
import { BrowserRouter as Router, withRouter } from 'react-router-dom';
import AppNavBar from './AppNavBar';
import './DisplayDoctors.css';

class DisplayDiagnosis extends Component {

    constructor(props) {
        super(props);
        this.state = {
            diagnosis: null,
        };
        this.getDiagnosis = this.getDiagnosis.bind(this);
        var list = this.getDiagnosis(this.props.location.state.id);
        this.setState({ diagnosis: list});
    }


    async getDiagnosis(checked) {
        await fetch('http://localhost:8080/api/verdicts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(checked),
        })
            .then(response => response.json())
            .then(response => {
                //console.log("!!!!!!!!!!!!!"+response);
                var temp = (response);
                this.setState({diagnosis : temp});
                //this.state.diagnosis = response;s
                //this.render();
                //console.log(response );
            })
            .catch(err => {
                console.log(err);
            })
    }




    render() {
        const diagnosis = this.state.diagnosis;
        console.log("RENDER:" +  diagnosis);
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
                            (<div> {diagnosis.map(symtpom =>
                                <div>
                                    {symtpom}
                                </div>
                            )} </div>)
                            : (<div>loading...</div>)
                        }

                    </div>

                </body>
            </div>
        );

    }
}

export default withRouter(DisplayDiagnosis);