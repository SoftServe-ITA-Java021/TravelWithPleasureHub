import React, {Component} from "react";
import axios from "axios";
import showList from './ShowList'


export default class CreatedMeetings extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                meetings: [
                    {
                        id: -1,
                        header: "",
                        meetingType: -1,
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
            <div className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                watching meetings where you're organizer
            </div>
            {showList(value.meetings)}
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    owner: "2"
                }
            })
            .then(json => this.setState({meetings: json.data}));
    }

}