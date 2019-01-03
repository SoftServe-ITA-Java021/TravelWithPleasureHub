import React, {Component} from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css'
import showList from './ShowList'


export default class GetMeetingsByAddress extends Component {
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
                location: ""
            };
        this.handleChange = this.handleChange.bind(this);
        this.inputData = this.inputData.bind(this);
    }

    render() {
        const value = this.state;
        return <div>
            {this.inputData()}
            {value.showAll ?
                <div className="alert alert-info row h-100 justify-content-center align-items-center"> You're watching
                    meetings with address:
                    {" " + value.header} </div> : ""}
            {value.location.length > 0 && value.showAll && showList(value.meetings)}
        </div>
    }

    inputData() {
        return <div className="row h-100 justify-content-center align-items-center">
            <form className="form-inline align-center">
                <div className="form-group">
                    <label htmlFor="inputDatetime">Address:</label>
                    <input
                        type="text"
                        className="form-control mx-sm-3"
                        value={this.state.location}
                        onChange={this.handleChange}
                    />
                </div>
            </form>
        </div>
    }

    handleChange(event) {
        let locale = event.target.value;
        axios.get(`http://localhost:9000/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                },
                params: {
                    'location': locale
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                location: locale,
                hasDate: true,
                showAll: true
            }));
    }
}