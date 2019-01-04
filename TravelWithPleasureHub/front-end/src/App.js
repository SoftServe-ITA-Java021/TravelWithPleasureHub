import React, { Component } from 'react';
import {BrowserRouter, Route} from "react-router-dom";

import NavBar from "./components/property-rent/NavBar";
import PropertyList from "./components/property-rent/PropertyList";
import {Fragment} from "react";
import Property from "./components/property-rent/Property";
import PropertyUpload from "./components/property-rent/PropertyUpload";

import MeetingNavbar from "./components/meetings/MeetingNavbar";
import GetAllMeetings from "./components/meetings/GetAllMeetings";
import GetMeetingsByDateTime from './components/meetings/GetMeetingsByDateTime'
import GetMeetingsByAddress from './components/meetings/GetMeetingsByAddress'
import GetMeetingsByHeader from './components/meetings/GetMeetingsByHeader'
import CreateMeeting from './components/meetings/CreateMeeting'
import GetCreatedMeetings from './components/meetings/GetCreatedMeetings'
import GetOneMeeting from './components/meetings/GetOneMeeting'

class App extends Component {
	render() {
		return (
			<div>
				<BrowserRouter>
					<Fragment>
						<NavBar />
						<Route exact path="/upload/property" component={PropertyUpload} />
						<Route exact path="/properties/:id" component={Property} />
						<Route exact path="/properties/" component={PropertyList} />

						<Route path="/meetings/" component={MeetingNavbar}/>
						<Route path="/meetings/show-all-meetings/" component={GetAllMeetings}/>
						<Route exact path="/meetings/show-all-meetings-by-date" component={GetMeetingsByDateTime}/>
						<Route path="/meetings/show-all-meetings-by-location" component={GetMeetingsByAddress}/>
						<Route path="/meetings/show-all-meetings-by-header" component={GetMeetingsByHeader}/>
						<Route path="/meetings/add-meeting" component={CreateMeeting}/>
						<Route path="/meetings/show-all-created-meetings" component={GetCreatedMeetings}/>
						<Route path="/meetings/show-meeting/:id" exact component={GetOneMeeting}/>

					</Fragment>

				</BrowserRouter>
			</div>
		);
	}
}

export default App;
