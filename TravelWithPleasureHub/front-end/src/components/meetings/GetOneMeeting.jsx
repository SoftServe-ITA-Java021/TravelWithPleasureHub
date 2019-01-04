import React, {Component} from "react";
import axios from "axios/index";

export default class GetOneMeeting extends Component {
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

                status: "",
                changed: false
            };
    }

    render() {
        const value = this.state;
        return <div>
            {value.changed ?

                <div className="jumbotron">
                    <h1 className="display-4 row h-100 justify-content-center align-items-center">{value.meeting.header}</h1>
                    <p className="lead row h-100 justify-content-center align-items-center">Type of
                        meeting: {value.meeting.meetingType}</p>
                    <p className="lead row h-100 justify-content-center align-items-center">Description: {value.meeting.content}</p>
                    <p className="lead row h-100 justify-content-center align-items-center">Address: {value.meeting.location}</p>
                    <p className="lead row h-100 justify-content-center align-items-center">Time: {value.meeting.timeOfAction.replace("T", " ")}</p>
                    <p className="lead row h-100 justify-content-center align-items-center">Who's going to meet
                        : {value.meeting.confirmedUserIds}</p>
                    <div className="form-row text-center">
                        <div className="col-12">
                            <button type="submit"
                                    className="btn btn-success center-block">
                                Send a request for participation
                            </button>
                        </div>
                    </div>
                </div>
                : "gg"}
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/api/meetings/${this.props.match.params.id}`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({meeting: json.data, changed: true, status: json.status}));
    }
}