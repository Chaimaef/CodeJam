import React, { Component } from 'react';
import { BrowserRouter as Router, withRouter } from 'react-router-dom';
import AppNavBar from './AppNavBar';
import './DisplayDoctors.css';

class DisplayDoctors extends Component {

    constructor(props) {
        super(props);
        this.state = {
            doctors: null
        };
        this.getDoctors = this.getDoctors.bind(this);
        const list = this.getDoctors(this.props.location.state.id);
        this.setState({ doctors: list });
    }


    getDoctors(item) {
       fetch('http://localhost:8080/api/doctors/' + item.speciality + '/' + item.city)
            .then(response => response.json())
            .then(response => {
                this.setState({ doctors: response });
                //console.log(this.state.doctors);
            })
    }


    render() {
        //const item = (this.props.location.state.id);
        const doctors = this.state.doctors;
        console.log(this.state.doctors);
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

                        {doctors !== null ?
                            (<table>
                                <thead>
                                <tr>
                                    <th>Clinic name</th>
                                    <th>Address</th>
                                    <th>Phone number</th>
                                </tr>
                                </thead>
                                <tbody>
                                {doctors.map(doctor =>
                                    <tr>
                                        <td>{doctor.clinicName}</td>
                                        <td>{doctor.street}</td>
                                        <td>{doctor.phone}</td>
                                    </tr>
                                )}
                                </tbody>
                            </table>
                            )

                            : (<div>loading...</div>)
                        }

                    </div>

                </body>
            </div>
        );

    }
}

export default withRouter(DisplayDoctors);