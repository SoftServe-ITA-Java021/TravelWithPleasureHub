import React, {Component} from "react";
import axios from "axios";
import showList from './ShowMeetingsList'
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"


export default class MeetingsHistory extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                meetings: [
                    {
                        id: -1,
                        header: "",
                        location: "",
                        timeOfAction: ""
                    }
                ],
                confirmed: false,
                wishing: false
            };
        this.confirmed = this.confirmed.bind(this);
        this.wishing = this.wishing.bind(this);

    }

    render() {
        const value = this.state;
        return <div className="background">
            <MeetingNavbar/>
            <div className="container meetingForm">
                <div className="form-row text-center">
                    <div className="col-12">
                        <div className="btn-group btn-group-toggle" data-toggle="buttons">
                            <button type="submit"
                                    className="btn btn-secondary"
                                    onClick={this.wishing}>
                                Wishing meetings
                            </button>
                            <button type="submit"
                                    className="btn btn-secondary"
                                    onClick={this.confirmed}>
                                Confirmed meetings
                            </button>
                        </div>
                    </div>
                </div>
                {(value.confirmed || value.wishing) && <div
                    className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                    watching meetings where you are {value.confirmed ? " confirmed" : "wishing want to be"} participant
                </div>}
                {value.meetings.length > 0 && value.meetings[0].id !== -1 && showList(value.meetings)}
            </div>
        </div>
    }


    confirmed(e) {
        e.preventDefault();
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    confirmedHistoryByUser: "2"
                }
            })
            .then(json => this.setState({meetings: json.data, confirmed: true, wishing: false}));
    }

    wishing(e) {
        e.preventDefault();
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    wishingHistoryByUser: "2"
                }
            })
            .then(json => this.setState({meetings: json.data, confirmed: false, wishing: true}));
    }

}