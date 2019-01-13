import React, {Component} from "react";
import axios from "axios";
// import showList from './ShowMeetingsList'
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"
import {NavLink} from "react-router-dom";


export default class ConfirmedUsers extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                users: [{
                    id: -1,
                    username: "",
                    email: "",
                    firstName: "",
                    secondName: "",
                    additionalInfo: "",
                    phoneNumber: ""
                }],

                isDownloaded: false,
                isConfirmed: false
            };
    }

    render() {
        let value = this.state;
        return <div className="background">
            <MeetingNavbar/>
            {value.isDownloaded &&
            <div className="container meetingForm">
                <div
                    className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                    watching users that are confirmed
                </div>
                {value.users.map(item => (
                    <NavLink className="nav-link" to={`/profile`} key={item.id}>
                        <li className="list-group-item list-group-item-action flex-column align-items-start">
                            {item.firstName}{" " + item.secondName}
                        </li>
                    </NavLink>
                ))}
            </div>
            }
        </div>
    }

    componentDidMount() {
        axios.get(`http://localhost:9000/api/meetings/confirmed-users/${this.props.match.params.id}`)
            .then(json => (this.setState({users: json.data, isDownloaded: true})));
    }

}