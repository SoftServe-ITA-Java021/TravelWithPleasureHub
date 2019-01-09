import React, {Component} from 'react';
import {bindActionCreators} from'redux';
import {connect} from'react-redux';
import {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button } from'react-bootstrap';
import  showLogin  from '../../actions/userActions';
import userApi from'../../api/userApi';
import $ from'jquery';
import {NavLink} from "react-router-dom";
import Profile from "../view/profile";
import profileApi from "../../api/profileApi";
import {SignUpForm} from "../view/navPanel";
export class NavBarAdmin extends React.Component{
    render() {
        return(
            <Navbar inverse>
                <Navbar.Header>
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
                        <NavLink to="/">Travel With Pleasure</NavLink>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="container">
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
                    </Nav>
                    <Nav>
                        <NavItem href="#">Clients</NavItem>
                    </Nav>
                    <Nav pullRight>
                        <NavItem href="#">{this.props.username}</NavItem>
                        <NavItem href="#"
                                 onClick={this.props.logout} >
                            Logout
                        </NavItem>

                    </Nav>
                </Navbar.Header>
            </Navbar>
        )
    }
}
export class NavBarGuest extends React.Component{
    constructor(props){
        super(props);
        this.handleLogin = this.handleLogin.bind(this);
    }
    handleLogin() {
        userApi.login($("#loginForm").serialize());
    }
    handleSignUp(){
        profileApi.signUp($("#signUpForm").serialize())
    }
    render(){
        return(
            <div className="form-group row h-100 justify-content-center align-items-center">
                <Navbar inverse>
                    <nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
                        <div className="container">
                            <NavLink className="navbar-brand" to="/">Travel With Pleasure</NavLink>
                            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
                                <span className="navbar-toggler-icon"></span>
                            </button>

                            <div className="collapse navbar-collapse" id="menu">
                                <ul className="navbar-nav mr-auto">
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/tickets">Purchase a plane ticket</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/properties">Rent a property</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/meetings/show-all-meetings">Arrange a meeting</NavLink>
                                    </li>
                                </ul>
                                <NavLink className="btn btn-outline-warning" to="/messages">
                                    <span className="glyphicon glyphicon-envelope"></span>
                                    Messages
                                </NavLink>
                                <button data-toggle="collapse" data-target="#loginForm" className="btn btn-primary center-block">LOG IN</button>
                                <button data-toggle="collapse" data-target="#signUpDiv" className="btn btn-primary center-block">SIGN UP</button>
                            </div>
                        </div>
                    </nav>
                    <Navbar.Collapse>
                        <Nav pullRight>
                            <NavItem href="#" >Sign up</NavItem>
                            <NavItem href="#"
                                     onClick={(e) => {
                                         e.preventDefault();
                                         userApi.login();
                                     }}>
                                Login
                            </NavItem>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>

                <div id="LoginDiv" className="container">
                    <form className="container meetingForm" role="form" action="http://localhost:8080/j_spring_security_check" method="post" id="loginForm" onSubmit={(e) => {e.preventDefault(); this.handleLogin();}} >
                        <div className="form-group">
                            <label>Login:</label>
                            <input className="form-control" id="email1" placeholder="Enter login" name="email" />
                        </div>
                        <div className="form-group">
                            <label> Password:</label>
                            <input type="password" className="form-control" id="password1" placeholder="Enter password" name="password" />
                        </div>
                        <button type="submit" className="btn btn-default" > Submit</button>
                    </form>
                </div>
                <div id="signUpDiv"className="container">
                   <SignUpForm/>
                </div>
            </div>
        )
    }
}
export class NavBarUser extends React.Component{
    render() {
        return(<div>
            <Navbar inverse>
                <Navbar.Header>
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
                        <Navbar.Brand>
                        <NavLink className="navbar-brand" to="/">Travel With Pleasure</NavLink>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        </Navbar.Brand>
                        <div className="container">
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
                                <Navbar.Header/>
                                    <Nav pullRight>
                                        <NavItem href="#">{this.props.login}</NavItem>
                                        <NavItem className="nav-link" href="/"
                                                 onClick={this.props.logout} >
                                            Logout
                                        </NavItem>
                                    </Nav>
                            </div>
                        </div>
                    </Nav>
                </Navbar.Header>
            </Navbar>
            </div>
        )
    }
}

class Navigation extends React.Component{
    render() {
        switch (this.props.currentUserRole) {
            case 'ROLE_USER' :
           return <div><NavBarUser/>{this.props.children}
               <Modal show={this.isLoginOpen} onHide={this.props.showLogin} bsSize="large">
                   <Modal.Header closeButton>
                       <Modal.Title> Sign UP <span className="glyphicon glyphicon-shopping-cart"></span> </Modal.Title>
                   </Modal.Header>
                   <Modal.Body>
                       <p> Amount : {this.props.currentUser}</p>
                       <Profile productsMap={this.props.currentUser}/>
                   </Modal.Body>
                   <Modal.Footer>

                       <Button onClick={this.props.showSignUp}>Close</Button>
                   </Modal.Footer>
               </Modal>
           </div>;
                break;
            case 'ROLE_ADMIN' :
            return <div><NavBarAdmin/>{this.props.children}</div>;
            case null : return <div><NavBarGuest/>{this.props.children}</div>;
            default: return <div><NavBarGuest/>{this.props.children}</div>;
        }
    }
}

const mapStateToProps = function(store) {
    return {
        currentUser : store.userState.currentUser,
        currentUserRole : store.userState.currentUserRole,
        isLoginOpen : store.userState.isLoginOpen
    }
};
const mapDispatchToProps = (dispatch) => bindActionCreators({
    showLogin: showLogin.showLogin
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(Navigation);