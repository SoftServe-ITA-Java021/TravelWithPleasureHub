import React, {Component} from "react";
import axios from "axios/index";
import MeetingNavbar from "./MeetingNavbar";
import {NavLink} from "react-router-dom";

export default class OneMeeting extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                meeting: {
                    id: -1,
                    header: "",
                    meetingType: "walking",
                    content: "",
                    location: "",
                    links: [],
                    timeOfAction: "",
                    ownerId: -1,
                    confirmedUserIds: [],
                    wishingUserIds: []
                },
                user:{
                    id: -1,
                    username: "",
                    email: "",
                    firstName: "",
                    secondName: "",
                    additionalInfo: "",
                    phoneNumber: ""
                },

                changed: false,
                isSent: false,
                isDeleted: false
            };
        this.sendRequest = this.sendRequest.bind(this);
        this.deleteMeeting = this.deleteMeeting.bind(this);
        this.chatConnect = this.chatConnect.bind(this);
        OneMeeting.showInformationAboutMeeting = OneMeeting.showInformationAboutMeeting.bind(this);
    }


    render() {
        const value = this.state;
        return <div className="background">
            <MeetingNavbar/>
            {value.isDeleted && <div className="container meetingForm">
                <div className="alert alert-info row h-100 justify-content-center align-items-center"> Meeting has
                    been
                    deleted
                </div>
            </div>}
            {value.changed && !value.isDeleted && <div className="container meetingForm">
                {value.isSent &&
                <div className="alert alert-info row h-100 justify-content-center align-items-center"> Request has
                    been
                    sent </div>}
                {OneMeeting.showInformationAboutMeeting(value)}

                {value.meeting.meetingType.toUpperCase() !== 'WALKING' && value.meeting.meetingType.toUpperCase() !== 'OTHER' ?
                    <h1 className="lead row h-100 justify-content-center align-items-center">
                        <div className="btn-group dropright ">
                            <button type="button" className="btn btn-secondary dropdown-toggle center-block widthButton"
                                    data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                Links for additional information
                            </button>
                            <div className="dropdown-menu">
                                {value.meeting.links.map((link, i) => (
                                        <a key={i} className="dropdown-item"
                                           href={link}>{link.substring(7, 50).replace("/", "")}</a>
                                    )
                                )}
                            </div>
                        </div>
                    </h1>
                    : ""}
                <NavLink to={`/meetings/show-meeting/confirmed-users/${value.meeting.id}`}>
                    <div className="form-row text-center">
                        <div className="col-12">
                            <button type="submit"
                                    className="btn btn-primary center-block widthButton">
                                Who's going to meet
                            </button>
                        </div>
                    </div>
                </NavLink>

                {value.meeting.ownerId !== 2 &&
                <div className="form-row text-center">
                    <div className="col-12">
                        <NavLink className="nav-link" to={`/profile/${value.meeting.ownerId}`}>
                            <button type="submit"
                                    className="btn btn-primary center-block widthButton">
                                Organizer
                            </button>
                        </NavLink>
                    </div>
                </div>}

                {value.meeting.ownerId !== 2 && <div className="form-row text-center">
                    <div className="col-12">
                        <button type="submit"
                                className="btn btn-primary center-block widthButton"
                                onClick={this.sendRequest}>
                            Send a request for participation
                        </button>
                    </div>
                </div>
                }


                {value.meeting.ownerId === 2 && <div>
                    <div className="form-row text-center">
                        <div className="col-12">
                            <NavLink to={`/meetings/show-meeting/wishing-users/${value.meeting.id}`}>
                                <h1 className="lead row h-100 justify-content-center align-items-center">
                                    <button type="submit"
                                            className="btn btn-primary widthButton">
                                        Wishing people
                                    </button>
                                </h1>
                            </NavLink>
                        </div>
                    </div>
                    {this.state.user.username!=='' || this.state.meeting.ownerId!==-1?<div className="form-row text-center">
                        <div className="col-12">
                            <h1 className="lead row h-100 justify-content-center align-items-center">
                                <button
                                    onClick={(e) => {
                                        e.preventDefault();
                                        this.chatConnect();
                                    }}
                                    className="btn btn-primary widthButton">
                                    Go chat!
                                </button>
                            </h1>
                        </div>
                    </div>:""}

                    <div className="form-row text-right">
                        <div className="col-12">
                            <NavLink to={`/meetings/edit/${value.meeting.id}`}>
                                <button type="submit"
                                        className="btn btn-warning">
                                    Edit
                                </button>
                            </NavLink>
                            <button type="submit"
                                    className="btn btn-danger"
                                    onClick={this.deleteMeeting}>
                                Delete
                            </button>
                        </div>
                    </div>
                </div>}
            </div>}
        </div>
    }


    static showInformationAboutMeeting(value) {
        return <div>
            <h1
                className="display-4 row h-100 justify-content-center align-items-center">{value.meeting.header}</h1>
            <p className="lead row h-100 justify-content-center align-items-center">Type of
                meeting: {value.meeting.meetingType}</p>
            <p className="lead row h-100 justify-content-center align-items-center">Description: {value.meeting.content}</p>
            <p className="lead row h-100 justify-content-center align-items-center">Address: {value.meeting.location}</p>
            <p className="lead row h-100 justify-content-center align-items-center">
                Date: {value.meeting.timeOfAction.substring(0, 22).replace("T", " ").replace("+", " (+") + ")"}
            </p>
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/api/meetings/${this.props.match.params.id}`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({meeting: json.data, changed: true}));
    }
    componentWillMount() {
        axios.get(`http://localhost:8080/api/meetings/confirmed-users/${this.props.match.params.id}`)
            .then(json => (this.setState({users: json.data, isDownloaded: true})));
    }

    sendRequest(e) {
        e.preventDefault();
        let value = this.state;
        let formData = new FormData();
        formData.append("meetingId", value.meeting.id);
        formData.append("userId", "2");

        axios.post("http://localhost:8080/api/meetings/request-for-meeting/",
            formData
        ).then(() => {
            this.setState({
                status: "Success",
                isSent: true
            })

        })
    }

    deleteMeeting(e) {
        e.preventDefault();
        let resp = window.confirm("Are you sure?");
        if (resp) {
            axios.delete(`http://localhost:8080/api/meetings/${this.state.meeting.id}`)
                .then(() => {
                    this.setState({
                        isDeleted: true
                    })
                })
        }
    }
    chatConnect(){
        window.location.replace("http://localhost:8080");
    }
}