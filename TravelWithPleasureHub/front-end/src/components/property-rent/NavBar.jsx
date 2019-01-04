import React, {Component} from 'react';
import {NavLink} from "react-router-dom";

// class NavBar extends Component {
// 	render() {
// 		return (
// 			<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
// 				<button
// 					className="navbar-toggler"
// 					type="button"
// 					data-toggle="collapse"
// 					data-target="#navbarNav"
// 					aria-controls="navbarNav"
// 					aria-expanded="false"
// 					aria-label="Toggle navigation"
// 				>
// 					<span className="navbar-toggler-icon" />
// 				</button>
// 				<div
// 					className="collapse navbar-collapse d-flex justify-content-center"
// 					id="navbarNav"
// 				>
// 					<ul className="navbar-nav ">
// 						<li className="nav-item">
// 							<NavLink activeClassName="active" className="nav-link" to="/properties">
// 								Rent properties
// 							</NavLink >
// 						</li>
// 					</ul>
// 				</div>
// 			</nav>
// 		);
// 	}
// }

class NavBar extends Component {
	render() {
		return (
			<div>
				<nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
					<div className="container">
						<NavLink className="navbar-brand" to="/">Travel With Pleasure</NavLink>
						<button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
							<span className="navbar-toggler-icon"></span>
						</button>

						<div className="collapse navbar-collapse" id="menu">
							<ul className="navbar-nav mr-auto">
								<li className="nav-item">
									<NavLink className="nav-link" to="/tickets">Ticket search</NavLink>
								</li>
								<li className="nav-item">
									<NavLink className="nav-link" to="/properties">Rental property</NavLink>
								</li>
								<li className="nav-item">
									<NavLink className="nav-link" to="/meetings">Arrange a meeting</NavLink>
								</li>
							</ul>
							<NavLink className="btn btn-outline-warning" to="/messages">
								<span className="glyphicon glyphicon-envelope"></span>
								Messages
							</NavLink>
						</div>
					</div>
				</nav>
			</div>
		);
	}
}

export default NavBar;