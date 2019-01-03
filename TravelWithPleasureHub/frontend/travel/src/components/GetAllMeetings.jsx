import React, {Component} from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css'
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
                        meetingType: -1,
                        content: "",
                        location: "",
                        links: [],
                        timeOfAction: "",
                        ownerId: -1,
                        confirmedUserIds: [],
                        wishingUserIds: [],
                    }
                ],
                showAll: false,
            };
        this.handlerForAllMeetings = this.handlerForAllMeetings.bind(this);

    }

    render() {
        const value = this.state;
        return <div>
            <div className="alert alert-info row h-100 justify-content-center align-items-center"> You're watching all meetings
            </div>
            {showList(value.meetings)}
        </div>
    }


    componentDidMount() {
        axios.get(`http://localhost:9000/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({meetings: json.data}));
    }


    handlerForAllMeetings() {
        this.setState({showAll: !this.state.showAll});
    }

}