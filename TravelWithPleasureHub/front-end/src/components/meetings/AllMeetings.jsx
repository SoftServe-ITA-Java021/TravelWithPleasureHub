import React, {Component} from "react";
import showList from './ShowList'


export default class AllMeetings extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                meetings: [
                    {
                        id: -1,
                        header: "",
                        meetingType: "walking",
                        content: "",
                        location: "",
                        links: [],
                        timeOfAction: "",
                        ownerId: -1,
                        confirmedUserIds: [],
                        wishingUserIds: [],
                    }
                ]
            };

    }

    render() {
        const value = this.state;
        return <div className="container">
            <div className="container alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                watching all meetings
            </div>
            {value.meetings[0].id !== -1 && showList(value.meetings)}
        </div>
    }


    componentDidMount() {
        fetch(`http://localhost:8080/api/meetings`)
            .then(data => data.json())
            .then(json => this.setState({meetings: json}));
    }

}