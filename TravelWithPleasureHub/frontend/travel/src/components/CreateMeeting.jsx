import React, {Component} from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css'
import showList from './ShowList'


export default class CreateMeeting extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                id: -1,
                header: "",
                meetingType: 0,
                content: "",
                location: "",
                links: [],
                timeOfAction: "",
                ownerId: -1,
                confirmedUserIds: [],
                wishingUserIds: [],
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
        return <div>
            <div className="alert alert-info">Creating of meeting</div>

            <div className="row h-100 justify-content-center align-items-center">
                <form>
                    <div className="form-group">
                        {this.headerBody()}
                        {this.meetingTypeBody()}
                        {this.contentBody()}
                        {this.locationBody()}
                        {this.timeOfActionBody()}
                    </div>
                    <button
                        type="submit"
                        onClick={this.sendRequest}> Create
                    </button>
                </form>
            </div>
        </div>
    }

    sendRequest() {
        let value = this.state;
        axios.post("http://localhost:9000/api/meetings",
            {
                headers:
                    {
                        'Access-Control-Allow-Credentials':
                            'include'
                    },
                body: {
                    header: value.header,
                    meetingType: value.meetingType,
                    content: value.content,
                    location: value.location,
                    links: [],
                    timeOfAction: value.timeOfAction,
                    confirmedUserIds: [],
                    wishingUserIds: [],
                }
            }
        )
    }

    headerBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Header:</label>
            <input
                type="text"
                className="form-control"
                value={this.state.header}
                onChange={this.headerChange}
                placeholder="Enter header"
            />
        </div>
    }

    meetingTypeBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Meeting type:</label>
            <select className="form-control" value={this.state.meetingType} onChange={this.meetingTypeChange}>
                <option
                    value="0">
                    Walking
                </option>
                <option
                    value="1">
                    Theatre
                </option>
                <option
                    value="2">
                    Cinema
                </option>
                <option
                    value="3">
                    Football match
                </option>
            </select>
        </div>
    }

    contentBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Content:</label>
            <textarea
                className="form-control"
                value={this.state.content}
                onChange={this.contentChange}
                placeholder="Enter content of meeting"
            />
        </div>
    }

    locationBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Location:</label>
            <input
                type="text"
                className="form-control"
                value={this.state.location}
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
                type="datetime-local"
                className="form-control"
                value={this.state.timeOfAction}
                onChange={this.timeOfActionChange}
            />
        </div>
    }

    headerChange(event) {
        this.setState({header: event.target.value})
    }

    meetingTypeChange(event) {
        this.setState({meetingType: event.target.value})
    }

    contentChange(event) {
        this.setState({content: event.target.value})
    }

    locationChange(event) {
        this.setState({location: event.target.value})
    }

    timeOfActionChange(event) {
        this.setState({timeOfAction: event.target.value})
    }
}

