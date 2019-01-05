import React, {Component} from "react";
import axios from "axios/index";

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

                status: "",
                changed: false,
                isSent: false
            };
        this.sendRequest = this.sendRequest.bind(this);
    }


    render() {
        const value = this.state;
        return <div className="container">
            <div className="jumbotron">
                <h1 className="display-4 row h-100 justify-content-center align-items-center">{value.meeting.header}</h1>
                <p className="lead row h-100 justify-content-center align-items-center">Type of
                    meeting: {value.meeting.meetingType}</p>
                <p className="lead row h-100 justify-content-center align-items-center">Description: {value.meeting.content}</p>
                <p className="lead row h-100 justify-content-center align-items-center">Address: {value.meeting.location}</p>
                <p className="lead row h-100 justify-content-center align-items-center">Time: {value.meeting.timeOfAction.replace("T", " ")}</p>
                <p className="lead row h-100 justify-content-center align-items-center">Who's going to meet
                    : {value.meeting.confirmedUserIds}</p>

                {value.meeting.meetingType.toUpperCase() !== 'WALKING' && value.meeting.meetingType.toUpperCase() !== 'OTHER' ?
                    <h1 className="lead row h-100 justify-content-center align-items-center">
                        <div className="btn-group dropright ">
                            <button type="button" className="btn btn-secondary dropdown-toggle center-block"
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
                <div className="form-row text-center">
                    <div className="col-12">
                        <button type="submit"
                                className="btn btn-success center-block"
                                onClick={this.sendRequest}>
                            Send a request for participation
                        </button>
                    </div>
                </div>
                {value.isSent ?
                    <p className="lead row h-100 justify-content-center align-items-center"> Request has been
                        sent </p> : ""}
            </div>


        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:9000/api/meetings/${this.props.match.params.id}`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({meeting: json.data, changed: true, status: json.status}));
    }

    sendRequest(e) {
        e.preventDefault();
        let value = this.state;
        let formData = new FormData();
        formData.append("meetingId", value.meeting.id);
        formData.append("userId", "3");

        axios.post("http://localhost:9000/api/meetings/request-for-meeting/",
            formData
        ).then(() => {
            this.setState({
                status: "Success",
                isSent: true
            })

        })
    }
}