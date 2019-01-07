import React, {Component} from "react";
import axios from "axios";
import showList from './ShowList'

export default class MeetingsFind extends Component {
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
                showAll: false,
                header: "",
                location: "",
                datetime: ""

            };
        this.handleChangeDatetime = this.handleChangeDatetime.bind(this);
        this.handleChangeHeader = this.handleChangeHeader.bind(this);
        this.handleChangeLocation = this.handleChangeLocation.bind(this);

        this.inputData = this.inputData.bind(this);
    }

    render() {
        const value = this.state;
        return <div>
            {this.inputData()}
            <div className="container">
                {value.showAll ?
                    <div
                        className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
                        watching
                        meetings with:
                        <ul>
                            {value.header === "" ? "" : <li>title: {value.header}</li>}
                            {value.location === "" ? "" : <li>address: {value.location}</li>}
                            {value.datetime === "" ? "" :
                                <li>date and time: {value.datetime.toString().replace("T", " ")}</li>}
                        </ul>
                    </div> : " "}


                {value.showAll && (value.header.length > 0 || value.location.length > 0 || value.datetime.length > 0)
                && showList(value.meetings)}
            </div>
        </div>
    }

    inputData() {
        return <div className="row h-100 justify-content-center align-items-center alert-light">
            <form className="form-inline align-center">
                <div className=" form-row">
                    <label htmlFor="inputText">Title:</label>
                    <input
                        placeholder="Title of meeting"
                        type="text"
                        className="form-control mx-sm-3"
                        value={this.state.header}
                        onChange={this.handleChangeHeader}
                    />

                    <label htmlFor="inputText">Address:</label>
                    <input
                        type="text"
                        placeholder="Place for meeting"
                        className="form-control mx-sm-3"
                        value={this.state.location}
                        onChange={this.handleChangeLocation}
                    />

                    <label htmlFor="inputDatetime">Until which date:</label>
                    <input
                        type="datetime-local"
                        className="form-control mx-sm-3"
                        value={this.state.datetime}
                        onChange={this.handleChangeDatetime}
                    />
                </div>
            </form>
        </div>
    }


    handleChangeHeader(event) {
        let header = event.target.value;
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    'headerFilter': header,
                    'locationFilter': this.state.location,
                    'timeFilter': this.state.datetime === "" ? '9' : this.state.datetime
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                header: header,
                showAll: true
            }));
    }

    handleChangeLocation(event) {
        let location = event.target.value;
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    'headerFilter': this.state.header,
                    'locationFilter': location,
                    'timeFilter': this.state.datetime === "" ? '9' : this.state.datetime
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                location: location,
                showAll: true
            }));
    }

    handleChangeDatetime(event) {
        let date = event.target.value;
        console.log(date);
        axios.get(`http://localhost:8080/api/meetings`,
            {
                params: {
                    'headerFilter': this.state.header,
                    'locationFilter': this.state.location,
                    'timeFilter': date === "" ? '9' : date
                }
            })
            .then(json => this.setState({
                meetings: json.data,
                datetime: date,
                showAll: true
            }));
    }

}