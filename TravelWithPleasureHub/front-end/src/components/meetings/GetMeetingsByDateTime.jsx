import React, {Component} from "react";
import axios from "axios";
import showList from './ShowList'

export default class GetMeetingsByDateTime extends Component {
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
                datetime: ""
            };
        this.handleChange = this.handleChange.bind(this);
        this.inputData = this.inputData.bind(this);
    }

    render() {
        const value = this.state;
        return <div>
            {this.inputData()}
            {value.showAll ?
                <div className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're watching
                    meetings after next date and time:
                    {" " + value.datetime.toString().replace("T", " ")} </div> : ""}
            {value.showAll && showList(value.meetings)}
        </div>
    }

    inputData() {
        return <div className="row h-100 justify-content-center align-items-center alert-light bg-light">
            <form className="form-inline align-center">
                <div className="form-group">
                    <label htmlFor="inputDatetime">Date and time:</label>
                    <input
                        type="datetime-local"
                        className="form-control mx-sm-3"
                        value={this.state.datetime}
                        onChange={this.handleChange}
                    />
                </div>
            </form>
        </div>
    }

    handleChange(event) {
        let date = event.target.value;
        console.log(date);
        axios.get(`http://localhost:8080/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                },
                params: {
                    'time': date
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                datetime: date,
                hasDate: true,
                showAll: true
            }));
    }
}