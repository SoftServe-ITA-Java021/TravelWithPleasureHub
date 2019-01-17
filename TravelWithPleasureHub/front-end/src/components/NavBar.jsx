import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
import $ from 'jquery';
import axios from 'axios';

class NavBar extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: -1,
            username: '',
            firstName: '',
            secondName: '',
            phoneNumber: '',
            email: '',
            password: '',
            role: 'ROLE_USER',
            status: false,
            isRegistered: false,
            isLoggedIn: false
        };

        this.usernameChange = this.usernameChange.bind(this);
        this.firstNameChange = this.firstNameChange.bind(this);
        this.secondNameChange = this.secondNameChange.bind(this);
        this.emailChange = this.emailChange.bind(this);
        this.passwordChange = this.passwordChange.bind(this);
        this.phoneNumberChange = this.phoneNumberChange.bind(this);

        this.usernameBody = this.usernameBody.bind(this);
        this.firstNameBody = this.firstNameBody.bind(this);
        this.secondNameBody = this.secondNameBody.bind(this);
        this.emailBody = this.emailBody.bind(this);
        this.passwordBody = this.passwordBody.bind(this);
        this.phoneNumberBody = this.phoneNumberBody.bind(this);


        this.profileShow = this.profileShow.bind(this);
        this.passwordChangeForm = this.passwordChangeForm.bind(this);
        this.sendSignUpRequest = this.sendSignUpRequest.bind(this);
        this.sendLoginRequest = this.sendLoginRequest.bind(this);
        this.handleChoice = this.handleChoice.bind(this);
        this.isFormValid = this.isFormValid.bind(this);
        this.isEmailUnique = this.isEmailUnique.bind(this);
        this.chatConnect = this.chatConnect.bind(this);
    }
    render(){
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
                                    <NavLink className="nav-link" to="/tickets">Purchase a plane ticket</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink className="nav-link" to="/properties">Rent a property</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink className="nav-link" to="/meetings/show-all-meetings">Arrange a meeting</NavLink>
                                </li>
                                {!this.state.isLoggedIn ?"" :<li>
                                    <NavLink className="nav-link" to="/profile">Profile</NavLink>
                                </li>}
                            </ul>
                            <NavLink className="btn btn-outline-warning" to="/chat">
                                <span className="glyphicon glyphicon-envelope"></span>
                                Messages
                            </NavLink>
                            <button className="btn btn-outline-warning" onClick={(e) => {
                                e.preventDefault();
                                this.chatConnect();
                            }}>Chat</button>
                        </div>
                    </div>
                    {!this.state.isLoggedIn? <button
                        className="btn btn-outline-warning"
                        data-toggle="collapse"
                        data-target="#signup"
                        aria-expanded="false"
                        aria-controls="signup"
                    > SIGN UP
                    </button>:""}
                    {!this.state.isLoggedIn ?<button
                        className="btn btn-outline-warning"
                        data-toggle="collapse"
                        data-target="#signin"
                        aria-expanded="false"
                        aria-controls="signin"
                    > LOGIN
                    </button>:""}
                </nav>
                <div id="signup" className="collapse">

                    <div className="row h-100 justify-content-center align-items-center">
                        <form>
                            <div className="form-group">
                                {this.usernameBody()}
                                {this.firstNameBody()}
                                {this.secondNameBody()}
                                {this.emailBody()}
                                {this.phoneNumberBody()}
                                {this.passwordBody()}
                            </div>
                            <div className="form-row text-center">
                                <div className="col-12">
                                    <button
                                        className="btn btn-primary center-block"
                                        type="submit"
                                        data-toggle="collapse"
                                        data-target="#signup"
                                        aria-expanded="false"
                                        aria-controls="signup"
                                        onClick={this.sendSignUpRequest}> SIGN UP
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div id="signin" className="collapse" >
                    <div className="alert alert-info row h-100 justify-content-center align-items-center" >
                        <form action="http://localhost:8080/j_spring_security_check" method="post"
                              onSubmit={(e) => {
                                  e.preventDefault();
                                  this.sendLoginRequest();
                              }}>
                            <div className="form-group">
                                {this.emailBody()}
                                {this.passwordBody()}
                            </div>
                            <div className="form-row text-center">
                                <div className="col-12">
                                    <button
                                        className="btn btn-primary center-block"
                                        data-toggle="collapse"
                                        data-target="#signin"
                                        aria-expanded="false"
                                        aria-controls="signin"
                                        type="submit"> LOGIN
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        );
    }

    usernameChange(event) {
        this.setState({username: event.target.value})
    }

    firstNameChange(event) {
        this.setState({firstName: event.target.value})
    }

    secondNameChange(event) {
        this.setState({secondName: event.target.value})
    }

    phoneNumberChange(event) {
        this.setState({phoneNumber: event.target.value})
    }

    emailChange(event) {
        this.setState({email: event.target.value})
    }

    passwordChange(event) {
        this.setState({password: event.target.value})
    }

    usernameBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Username:</label>
            <input
                required
                type="text"
                className="form-control"
                value={this.state.username}
                onChange={this.usernameChange}
                placeholder="Enter username"
            />
            <div id="username-error"></div>
        </div>
    }

    firstNameBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>First name:</label>
            <input
                required
                type="text"
                className="form-control"
                value={this.state.firstName}
                onChange={this.firstNameChange}
                placeholder="Enter First Name"
            />
            <div id="fName-error"></div>
        </div>
    }

    secondNameBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Last name:</label>
            <input
                required
                type="text"
                className="form-control"
                value={this.state.secondName}
                onChange={this.secondNameChange}
                placeholder="Enter Second Name"
            />
            <div id="sName-error"></div>
        </div>
    }

    phoneNumberBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Phone:</label>
            <input
                required
                type="text"
                className="form-control"
                value={this.state.phoneNumber}
                onChange={this.phoneNumberChange}
                placeholder="+380-11-111-1111"
            />
            <div id="phoneNumber-error"></div>
        </div>
    }

    emailBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>E-mail:</label>
            <input
                required
                type="email"
                className="form-control"
                value={this.state.email}
                onChange={this.emailChange}
                placeholder="Enter E-mail"
                name="j_username"
            />
            <div id="email-error"></div>
        </div>
    }

    passwordBody() {
        return <div className="form-group row h-100 justify-content-center align-items-center">
            <label>Password:</label>
            <input
                required
                type="password"
                className="form-control"
                value={this.state.password}
                onChange={this.passwordChange}
                placeholder="Enter password"
                name="j_password"
            />
            <div id="password-error"></div>
        </div>
    }

    sendSignUpRequest(e) {
        e.preventDefault();
        let value = this.state;
        let formData = new FormData();
        formData.append("username", value.username);
        formData.append("firstName", value.firstName);
        formData.append("secondName", value.secondName);
        formData.append("phoneNumber", value.phoneNumber);
        formData.append("email", value.email);
        formData.append("password", value.password);
        formData.append("role", this.state.role);
        formData.append("status", this.state.status);
        let form = {
            username: value.username,
            firstName: value.firstName,
            secondName: value.secondName,
            phoneNumber: value.phoneNumber,
            email: value.email,
            password: value.password,
        };

        if (this.isFormValid(form)) {
            fetch("http://localhost:8080/registration",
                {
                    method: "POST",
                    body: formData
                }
            ).then(response => {
                if (response.status === 403) {
                    this.setState({
                        status: true,
                        isRegistered: true
                    })
                }
            })
        }
    }

    isFormValid(form) {
        let isValid = true;
        if (form.firstName == '') {
            $("#fName-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>First name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#fName-error").html("");
        }
        if (form.secondName == '') {
            $("#sName-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Second name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#sName-error").html("");
        }
        if (form.username == '') {
            $("#username-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Username cannot be empty!</div>");
            isValid = false;
        } else {
            $("#username-error").html("");
        }
        let regExpEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,13}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!regExpEmail.test(form.email)) {
            $("#email-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Not valid email!</div>");
            isValid = false;
        } else {
            this.isEmailUnique(form.email)
                .then(data => {
                    if (data) {
                        $("#email-error").html("");
                    } else {
                        $("#email-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>E-mail is not unique!</div>");
                        isValid = false;
                    }
                });
        }
        let regExpPhone = /(380+[0-9]{9})/;
        if (!regExpPhone.test(form.phoneNumber)) {
            $("#phoneNumber-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Phone is not valid!</div>");
            isValid = false;
        } else {
            $("#phoneNumber-error").html("");
        }
        if (form.password == '') {
            $("#password-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Password cannot be empty!</div>");
            isValid = false;
        } else {
            $("#password-error").html("");

        }
        return isValid;
    }

    sendLoginRequest() {
        let value = this.state;
        let formData = new FormData();
        formData.append("j_username", value.email);
        formData.append("j_password", value.password);
        axios.post("http://localhost:8080/login",
            formData, {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            }
        ).then(response => {
            if (response.status === 200)
                this.setState({
                    isLoggedIn: true
                })

        })
    }

    passwordChangeForm() {

    }

    profileShow() {

    }

    handleChoice(e) {
        e.preventDefault();
        this.setState(
            {isRegistered: true}
        )
    }

    isEmailUnique(email) {
        return new Promise(function (resolve, reject) {
            $.ajax({
                url: "http://localhost:8080/loginCheck",
                type: 'GET',
                data: {email: email},
                success(data) {
                    resolve(data);
                }
            });
        });
    }
    chatConnect(){
        window.location.replace("http://localhost:8080");
    }
}

export default NavBar;