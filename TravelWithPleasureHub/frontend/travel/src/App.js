import React, {Component} from 'react';
import './App.css';
import './components/GetAllMeetings'
import MeetingNavbar from "./components/MeetingNavbar";

import {BrowserRouter, Route} from 'react-router-dom'
import GetAllMeetings from "./components/GetAllMeetings";
import GetMeetingsByDateTime from './components/GetMeetingsByDateTime'
import GetMeetingsByAddress from './components/GetMeetingsByAddress'
import GetMeetingsByHeader from './components/GetMeetingsByHeader'
import CreateMeeting from './components/CreateMeeting'

class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <MeetingNavbar/>
                    <Route path="/show-all-meetings/" component={GetAllMeetings}/>
                    <Route exact path="/show-all-meetings-by-date" component={GetMeetingsByDateTime}/>
                    <Route path="/show-all-meetings-by-location" component={GetMeetingsByAddress}/>
                    <Route path="/show-all-meetings-by-header" component={GetMeetingsByHeader}/>
                    <Route path="/add-meeting" component={CreateMeeting}/>
                </div>
            </BrowserRouter>
        );
    }
}

export default App;