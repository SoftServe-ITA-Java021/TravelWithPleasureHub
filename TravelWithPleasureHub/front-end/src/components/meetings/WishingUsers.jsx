import React, {Component} from "react";
import axios from "axios";
// import showList from './ShowMeetingsList'
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"
import {NavLink} from "react-router-dom";


export default class WishingUsers extends Component {
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
                    watching users that want to go with you
                </div>
                {value.users.map(item => (
                    <NavLink className="nav-link" to={`/profile`} key={item.id}>
                        <li className="list-group-item list-group-item-action flex-column align-items-start">
                            {item.firstName}{" " + item.secondName}
                            <button type="submit" className="close" aria-label="Close"
                                    onClick={(e) => this.reject(item.id, e)}>
                                <span aria-hidden="true">&#8211;</span>
                            </button>
                            <button type="submit" className="close" aria-label="Close"
                                    onClick={(e) => this.submit(item.id, e)}>
                                <span className="badge badge-light">&#43;</span>
                            </button>
                        </li>
                    </NavLink>

                ))}
            </div>
            }
        </div>
    }

    componentDidMount() {
        axios.get(`http://localhost:9000/api/meetings/wishing-users/${this.props.match.params.id}`)
            .then(json => (this.setState({users: json.data, isDownloaded: true})));
    }


    submit(param, e) {
        e.preventDefault();
        axios.get("http://localhost:9000/api/meetings/confirm-meeting/", {
            headers: {
                'Access-Control-Allow-Credentials': 'include'
            },
            params: {
                meetingId: this.props.match.params.id,
                wishingUserId: param
            }
        }).then(() => (axios.get(`http://localhost:9000/api/meetings/wishing-users/${this.props.match.params.id}`)
            .then(json => (this.setState({users: json.data, isDownloaded: true})))))
    }

    reject(param, e) {
        e.preventDefault();
        axios.get("http://localhost:9000/api/meetings/reject/", {
            headers: {
                'Access-Control-Allow-Credentials': 'include'
            },
            params: {
                meetingId: this.props.match.params.id,
                wishingUserId: param
            }
        }).then(() => (axios.get(`http://localhost:9000/api/meetings/wishing-users/${this.props.match.params.id}`)
            .then(json => (this.setState({users: json.data, isDownloaded: true})))))
    }

}