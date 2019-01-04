import React, {Component} from "react";
import axios from "axios";
import showList from './ShowList'


export default class GetAllMeetings extends Component {
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
        return <div>
            <div className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                watching all meetings
            </div>
            {value.meetings[0].id !== -1 && showList(value.meetings)}
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({meetings: json.data}));
	        // .then(json => console.log(json))
    }

}