import React, {Component} from "react";
import axios from "axios";
import showList from './ShowList'


export default class GetCreatedMeetings extends Component {
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
        return <div>
            <div className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                watching meetings where you're organizer
            </div>
            {value.meetings[0].id !== -1 && showList(value.meetings)}
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                },
                params: {
                    owner: "2"
                }
            })
            .then(json => this.setState({meetings: json.data}));
    }

}