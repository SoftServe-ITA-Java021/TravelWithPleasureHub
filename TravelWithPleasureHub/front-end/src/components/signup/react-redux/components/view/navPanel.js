import {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button} from'react-bootstrap';
import $ from 'jquery';
import React,{Component} from 'react';
import profileApi from '../../api/profileApi';
import {NavLink} from "react-router-dom";

export class NavBarAdmin extends React.Component{
    render() {
        return (
            <Navbar inverse>
    <Navbar.Header>
        <Navbar.Brand>
            <NavLink  to="/">Travel With Pleasure</NavLink>
        </Navbar.Brand>
        <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
        <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
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
            <NavItem href="#/clients">Clients</NavItem>
        </Nav>
        <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark" pullRight>
            <NavDropdown title={this.props.currentUser.username} id="basic-nav-dropdown">
            <MenuItem href="#/profile">
                Profile
                <span className="glyphicon glyphicon-user pull-right"/>
            </MenuItem>
            <MenuItem href="#/profile/change">
                Change
                <span className="glyphicon glyphicon-option-horizontal pull-right"/>
            </MenuItem>
            <MenuItem divider/>
            <MenuItem onClick={this.props.logout}> Logout <span
    className="glyphicon glyphicon-log-out pull-right"/></MenuItem>
        </NavDropdown>
        </Nav>
    </Navbar.Collapse>
</Navbar>
)
}
}
export class NavBarGuest extends React.Component{
    constructor(props){
        super(props);

        this.handleLogin =this.handleLogin.bind(this);
    }
    handleLogin() {
        this.props.login($("#loginForm").serialize());
    }
   render() {
        return (
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <NavLink to="/">Travel With Pleasure</NavLink>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
                        <div className="container">
                            <div className="collapse navbar-collapse" id="menu">
                                <ul className="navbar-nav mr-auto">
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/tickets">Ticket search</NavLink>
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
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark" pullRight>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showSignUp();
                                     }}>
                            <span className="glyphicon glyphicon-user"></span> Sign up
                        </NavItem>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showLogin();
                                     }}>
                            <span className="glyphicon glyphicon-log-in"></span> Login
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}
class NavBarUser extends React.Component{
    render() {
        return (
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <NavLink  to="/">Travel With Pleasure</NavLink>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
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
                    <Nav className="navbar fixed-top navbar-expand-md navbar-dark bg-dark" pullRight>
                        <NavDropdown title={this.props.currentUser.username} id="basic-nav-dropdown">
                            <MenuItem href="#/profile">
                                Profile
                                <span className="glyphicon glyphicon-user pull-right"/>
                            </MenuItem>
                            <MenuItem href="#/profile/change">
                                Change
                                <span className="glyphicon glyphicon-option-horizontal pull-right"/>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem onClick={this.props.logout}>
                                Logout <span className="glyphicon glyphicon-log-out pull-right"/>
                            </MenuItem>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}
export class LoginForm extends React.Component{
    constructor(props){
        super(props);

        this.handleLogin = this.handleLogin.bind(this);
    }
    handleLogin() {
        this.props.login($("#loginForm").serialize());
    }
    render() {
        return (
            <form role="form" method="post" id="loginForm"
                  onSubmit={(e) => {e.preventDefault(); this.handleLogin();}}>
                <Modal.Body>
                    <div className="form-group">
                        <label>Login:</label>
                        <input className="form-control" id="login" placeholder="Enter login" name="email"/>
                    </div>
                    <div className="form-group">
                        <label> Password:</label>
                        <input type="password" className="form-control" id="pwd" placeholder="Enter password"
                               name="password"/>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <button type="submit" className="btn btn-primary"> Submit</button>
                </Modal.Footer>
            </form>
        )
    }
}
export class SignUpForm extends React.Component{
    constructor(props){
        super(props);

        this.isFormValid = this.isFormValid.bind(this);
        this.handleSignUp = this.handleSignUp.bind(this);
    }
    isFormValid(form) {
        let isValid = true;
        if (form.login == '') {
            $("#login-error").html("<br/><div class='alert alert-danger'>Login cannot be empty!</div>");
            isValid = false;
        } else {

        }
        var regExpEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,13}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!regExpEmail.test(form.email)) {
            $("#email-error").html("<br/><div class='alert alert-danger'>Not valid email!</div>");
            isValid = false;
        } else {
            profileApi.isLoginUnique(form.email)
                .then(data => {
                    if (data) {
                        $("#email-error").html("");
                    } else {
                        $("#email-error").html("<br/><div class='alert alert-danger'>Email is not unique!</div>");
                        isValid = false;
                    }
                });
            $("#email-error").html("");
        }
        var regExpPhone = /(380+[0-9]{9})/;
        if (!regExpPhone.test(form.phoneNumber)) {
            $("#phone-error").html("<br/><div class='alert alert-danger'>Phone is not valid!</div>");
            isValid = false;
        } else {
            $("#phone-error").html("");
        }
        if (form.password == '') {
            $("#password-error").html("<br/><div class='alert alert-danger'>Password cannot be empty!</div>");
            isValid = false;
        } else {
            $("#password-error").html("");
        }
        return isValid;
    }
    handleSignUp() {
        let form = {
            username: $("#login").val(),
            firstName: $("#firstName").val(),
            secondName: $("#secondName").val(),
            email: $("#email").val(),
            phoneNumber: $("#phoneNumber").val(),
            password: $("#password").val(),
            status: "true",
            role: 'ROLE_USER'
        };
        if (this.isFormValid(form)) {
            profileApi.signUp(form);
        }
    }
    render() {
        return (

            <form id="sign-form" role="form" onSubmit={(e) => {e.preventDefault(); this.handleSignUp();}}>
                <Modal.Body>
                    <div className="form-group">
                        <label>First name:</label>
                        <input className="form-control" id="firstName" placeholder="Enter first name"/>
                        <div id="login-error"></div>
                    </div>
                    <div className="form-group">
                        <label>Second name:</label>
                        <input className="form-control" id="secondName" placeholder="Enter second name"/>
                        <div id="login-error"></div>
                    </div>
                    <div className="form-group">
                        <label>Login:</label>
                        <input className="form-control" id="login" placeholder="Enter username"/>
                        <div id="login-error"></div>
                    </div>
                    <div className="form-group">
                        <label>Email:</label>
                        <input className="form-control" id="email" placeholder="Enter email"/>
                        <div id="email-error"></div>
                    </div>
                    <div className="form-group">
                        <label>Phone:</label>
                        <input className="form-control" id="phoneNumber" placeholder="Enter phone"/>
                        <div id="phone-error"></div>
                    </div>
                    <div className="form-group">
                        <label> Password:</label>
                        <input type="password" className="form-control" id="password" placeholder="Enter password"/>
                        <div id="password-error"></div>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <button type="submit" className="btn btn-primary" data-toggle="collapse" data-target="#sign-form"> Sign up</button>

                </Modal.Footer>
            </form>
        )
    }
}

export default function (props) {
    let NavBar = <NavBarGuest showLogin={props.showLogin} showSignUpModal={props.showSignUp}/>;
    switch (props.userState.currentUserRole) {
        case 'ROLE_USER' :
            NavBar =
                <NavBarUser currentUser={props.userState.currentUser} logout={props.logout}/>;
            break;
        case 'ROLE_ADMIN' :
            NavBar =
                <NavBarAdmin currentUser={props.userState.currentUser} logout={props.logout}/>;
            break;
        default:
            break;
    }
    return <div>
        {NavBar}
        <Modal show={props.userState.isLoginOpen} onHide={props.showLogin} bsSize="lg">
            <Modal.Header closeButton>
                <Modal.Title> <span className="glyphicon glyphicon-log-in"></span> Login </Modal.Title>
            </Modal.Header>
            <LoginForm login={props.login}/>
        </Modal>
        <Modal show={props.userState.isSignUpOpen} onHide={props.showSignUp} bsSize="lg">
            <Modal.Header closeButton>
                <Modal.Title> <span className="glyphicon glyphicon-log-in"></span> Sign up </Modal.Title>
            </Modal.Header>
            <SignUpForm isLoginUnique={props.isLoginUnique} signUp={props.signUp}/>
        </Modal>
    </div>
};