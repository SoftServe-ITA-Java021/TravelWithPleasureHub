import React, {Component} from "react";
import {NavLink} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css'

export default class MeetingNavbar extends Component {

    render() {
        return <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <NavLink className="navbar-brand" to="/">Main</NavLink>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"/>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavDropdown">
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <NavLink className="nav-link" to="/show-all-meetings">
                            <button className="btn btn-secondary">
                                View all meetings
                            </button>

                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" to="/show-all-meetings-by-date">
                            <button className="btn btn-secondary">
                                Find meetings by date and time
                            </button>
                        </NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink className="nav-link" to="/show-all-meetings-by-location">
                            <button className="btn btn-secondary">
                                Find meetings by address
                            </button>
                        </NavLink>
                    </li>
                    <li className="nav-item dropdown">
                        <NavLink className="nav-link" to="/show-all-meetings-by-header">
                            <button className="btn btn-secondary">
                                Find meetings by header
                            </button>
                        </NavLink>
                    </li>
                    <li className="nav-item dropdown">
                        <NavLink className="nav-link" to="/sign-up">
                            <button className="btn btn-secondary">
                                View your meetings
                            </button>
                        </NavLink>
                    </li>
                    <li className="nav-item dropdown">
                        <NavLink className="nav-link" to="/add-meeting">
                            <button className="btn btn-success">
                                Create meeting
                            </button>
                        </NavLink>
                    </li>

                </ul>
            </div>
        </nav>

    }
}