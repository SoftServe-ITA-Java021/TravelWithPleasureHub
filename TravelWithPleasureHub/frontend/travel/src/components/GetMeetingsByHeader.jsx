import React, {Component} from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css'
import showList from './ShowList'


export default class GetMeetingsByHeader extends Component {
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
                        showAdditionalInfo: false
                    }
                ],
                showAll: false,
                header: ""
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
                    meetings with header:
                    {" " + value.header} </div> : ""}
            {value.header.length > 0 && value.showAll && showList(value.meetings)}
        </div>
    }

    inputData() {
        return <div className="row h-100 justify-content-center align-items-center">
            <form className="form-inline align-center">
                <div className="form-group">
                    <label htmlFor="inputDatetime">Header:</label>
                    <input
                        type="text"
                        className="form-control mx-sm-3"
                        value={this.state.header}
                        onChange={this.handleChange}
                    />
                </div>
            </form>
        </div>
    }

    handleChange(event) {
        let header = event.target.value;
        axios.get(`http://localhost:9000/api/meetings`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                },
                params: {
                    'header': header
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                header: header,
                hasDate: true,
                showAll: true
            }));
    }
}