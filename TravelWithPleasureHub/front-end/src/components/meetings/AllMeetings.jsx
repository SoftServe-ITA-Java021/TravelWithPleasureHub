import React, {Component} from "react";
import showList from './ShowMeetingsList'
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"


export default class AllMeetings extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                meetings: [
                    {
                        id: -1,
                        header: "",
                        location: "",
                        timeOfAction: "",
                    }
                ]
            };

    }

    render() {
        const value = this.state;
        return <div className="background">
            <MeetingNavbar/>
            <div className="container meetingForm">

                <div
                    className="container alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                    watching all meetings
                </div>
                {value.meetings.length > 0 && value.meetings[0].id !== -1 && showList(value.meetings)}
            </div>
        </div>
    }


    componentWillMount() {
        fetch(`http://localhost:8080/api/meetings`)
            .then(data => data.json())
            .then(json => this.setState({meetings: json}));
    }

}