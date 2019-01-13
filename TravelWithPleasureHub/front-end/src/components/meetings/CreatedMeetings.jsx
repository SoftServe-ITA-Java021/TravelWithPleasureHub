import React, {Component} from "react";
import axios from "axios";
import showList from './ShowMeetingsList'
import MeetingNavbar from "./MeetingNavbar";
import "./css/style.css"


export default class CreatedMeetings extends Component {
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
				]
			};

	}

	render() {
		const value = this.state;
		return <div className="background">
				<MeetingNavbar/>
				<div className="container meetingForm">
					<div
						className="alert alert-light bg-light row h-100 justify-content-center align-items-center"> You're
						watching meetings where you're organizer
					</div>
					{showList(value.meetings)}
				</div>
			</div>
	}


	componentDidMount() {
		axios.get(`http://localhost:8080/api/meetings`,
			{
				params: {
					owner: "1"
				}
			})
			.then(json => this.setState({meetings: json.data}));
	}

}