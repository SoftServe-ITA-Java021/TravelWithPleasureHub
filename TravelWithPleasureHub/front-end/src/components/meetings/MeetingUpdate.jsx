import React, {Component} from "react";
import axios from "axios";
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"


export default class MeetingUpdate extends Component {
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

                id: this.props.match.params.id,
                header: "",
                meetingType: "walking",
                content: "",
                location: "",
                timeOfAction: "",
                ownerId: -1,

                isUpdated: false
            };
        this.headerChange = this.headerChange.bind(this);
        this.meetingTypeChange = this.meetingTypeChange.bind(this);
        this.contentChange = this.contentChange.bind(this);
        this.locationChange = this.locationChange.bind(this);
        this.timeOfActionChange = this.timeOfActionChange.bind(this);

        this.headerBody = this.headerBody.bind(this);
        this.meetingTypeBody = this.meetingTypeBody.bind(this);
        this.contentBody = this.contentBody.bind(this);
        this.locationBody = this.locationBody.bind(this);
        this.timeOfActionBody = this.timeOfActionBody.bind(this);

        this.sendRequest = this.sendRequest.bind(this);
    }

    render() {
        return <div className="background">
            <MeetingNavbar/>
            <div className="container meetingForm">

                <div className="alert alert-light row h-100 justify-content-center align-items-center">Editing of
                    meeting
                </div>

                {!this.state.isUpdated ?
                    <div className="row h-100 justify-content-center align-items-center">
                        <form>
                            <div className="form-group">
                                {this.headerBody()}
                                {this.meetingTypeBody()}
                                {this.contentBody()}
                                {this.locationBody()}
                                {this.timeOfActionBody()}
                            </div>
                            <div className="form-row text-center">
                                <div className="col-12">
                                    <button
                                        className="btn btn-primary center-block"
                                        type="submit"
                                        onClick={this.sendRequest}> Update
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                    :
                    <div className="alert alert-info row h-100 justify-content-center align-items-center">Meeting
                        was
                        updated
                    </div>

                }
            </div>
        </div>
    }

    componentWillMount() {
        axios.get(`http://localhost:9000/api/meetings/${this.props.match.params.id}`,
        ).then(response => {
            this.setState({
                meeting: response.data
            })
        })
    }

    sendRequest(e) {
        e.preventDefault();
        let value = this.state;
        let formData = new FormData();
        formData.append("id", value.id);
        formData.append("header", value.header.length > 0 ? value.header : value.meeting.header);
        formData.append("meetingType", value.meetingType.length > 0 ? value.meetingType : value.meeting.meetingType);
        formData.append("content", value.content.length > 0 ? value.content : value.meeting.content);
        formData.append("location", value.location.length > 0 ? value.location : value.meeting.location);
        formData.append("timeOfAction", value.timeOfAction.length > 0 ? value.timeOfAction : value.meeting.timeOfAction.substring(0, 16));
        formData.append("links", value.meeting.links.toString());
        formData.append("ownerId", JSON.stringify(value.meeting.ownerId));
        formData.append("confirmedUserIds", value.meeting.confirmedUserIds.toString());
        formData.append("wishingUserIds", value.meeting.wishingUserIds.toString());

        axios.put("http://localhost:9000/api/meetings",
            formData
        ).then(response => {
            if (response.status === 200) {
                this.setState({
                    isUpdated: true
                })
            }
        })
    }

    headerBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Header:</label>
            <input
                required
                type="text"
                className="form-control"
                defaultValue={this.state.meeting.header}
                onChange={this.headerChange}
                placeholder="Enter header"
            />
        </div>
    }

    meetingTypeBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Meeting type:</label>
            <select className="form-control" value={this.state.meetingType}
                    onChange={this.meetingTypeChange}>
                <option
                    value="Walking">
                    Walking
                </option>
                <option
                    value="Theatre">
                    Theatre
                </option>
                <option
                    value="Cinema">
                    Cinema
                </option>
                <option
                    value="Concert">
                    Concert
                </option>
                <option
                    value="Football_match">
                    Football match
                </option>
                <option
                    value="Other">
                    Other
                </option>
            </select>
        </div>
    }

    contentBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Description:</label>
            <textarea
                className="form-control"
                defaultValue={this.state.meeting.content.toString()}
                onChange={this.contentChange}
                placeholder="Enter content of meeting"
            />
        </div>
    }

    locationBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Location:</label>
            <input
                required
                type="text"
                className="form-control"
                defaultValue={this.state.meeting.location}
                onChange={this.locationChange}
                placeholder="Enter location"
            />
            <small className="form-text text-muted">
                Please, enter location according next format: "Country, City, Street, etc".
            </small>
        </div>
    }

    timeOfActionBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Meeting's date and time:</label>
            <input
                required
                type="datetime-local"
                className="form-control"
                value={this.state.timeOfAction}
                onChange={this.timeOfActionChange}
            />
        </div>
    }

    headerChange(event) {
        this.setState({
            header: event.target.value
        })
    }

    meetingTypeChange(event) {
        this.setState({
            meetingType: event.target.value
        })
    }

    contentChange(event) {
        this.setState({
            content: event.target.value
        })
    }

    locationChange(event) {
        this.setState({
            location: event.target.value
        })
    }

    timeOfActionChange(event) {
        this.setState({
            timeOfAction: event.target.value
        })
    }
}

