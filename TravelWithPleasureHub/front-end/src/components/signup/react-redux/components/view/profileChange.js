import React,{Component} from 'react';
import $ from'jquery';
import { Modal } from 'react-bootstrap';

export class ProfileChange extends React.Component{
    constructor(props){
        super(props);

        this.isProfileValid = this.isProfileValid.bind(this);
        this.isPasswordFormValid = this.isPasswordFormValid.bind(this);
        this.handleSubmitChange = this.handleSubmitChange.bind(this);
        this.handleChangePassword = this.handleChangePassword.bind(this);
        this.cancel = this.cancel.bind(this);
    }
    isProfileValid(profile) {
        let isValid = true;
        if (profile.firstName == '') {
            $("#name-error").html("<br/><div class='alert alert-danger'>Name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#name-error").html("");
        }
        if (profile.secondName == '') {
            $("#lastName-error").html("<br/><div class='alert alert-danger'>Last name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#lastName-error").html("");
        }
        let regExpEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,13}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!regExpEmail.test(profile.email)) {
            $("#email-error").html("<br/><div class='alert alert-danger'>Not valid email!</div>");
            isValid = false;
        } else {
            $("#email-error").html("");
        }
        let regExpPhone = /(380+[0-9]{9})/;
        if (!regExpPhone.test(profile.phoneNumber)) {
            $("#phone-error").html("<br/><div class='alert alert-danger'>Phone is not valid!</div>");
            isValid = false;
        } else {
            $("#phone-error").html("");
        }
        return isValid;
    }
    isPasswordFormValid(password, oldPassword, newPassword, newPasswordCopy) {
        var isValid = true;
        if (oldPassword != password) {
            $("#oldPassword-error").html("<br/><div class='alert alert-danger'>Incorrect password!</div>");
            isValid = false;
        } else {
            $("#oldPassword-error").html("");
        }
        if (newPassword == '') {
            $("#newPassword-error").html("<br/><div class='alert alert-danger'>New password cannot be empty!</div>");
            isValid = false;
        } else if (newPassword != newPasswordCopy) {
            $("#newPassword-error").html("");
            $("#newPasswordCopy-error").html("<br/><div class='alert alert-danger'>Passwords aren't same!</div>");
            isValid = false;
        } else {
            $("#newPassword-error").html("");
        }
        return isValid;
    }
    handleSubmitChange(e) {
        e.preventDefault();
        var user = this.props.user;
        let changeUser = {
            id: user.id,
            username: user.username,
            firstName: $("#firstName").val(),
            secondName: $("#lastName").val(),
            email: $("#email").val(),
            password: user.password,
            phoneNumber: $("#phone").val(),
            role: user.role,
            status: user.status,
        };
        if (this.isProfileValid(changeUser)) {
            this.props.handleChange(changeUser);
      }
    }
    handleChangePassword(e) {
        e.preventDefault();
        let user = this.props.user;
        let oldPassword = $("#oldPassword").val();
        let newPassword = $("#newPassword").val();
        let newPasswordCopy = $("#newPasswordCopy").val();
        if (this.isPasswordFormValid(user.password, oldPassword, newPassword, newPasswordCopy)) {
            user.password = newPassword;
            this.props.handleChange(user);
        }
    }
    cancel(e) {
        e.preventDefault();
        console.log("fix")
    }
    render() {
        let { user } = this.props;
        return (
            <div className="container">
                <h2 className="page-header">
                    Your login: {user.username}
                </h2>
                <br/>
                <form role="form" onSubmit={this.handleSubmitChange}>
                    <div className="form-group">
                        <label for="firstName">Name:</label>
                        <input type="text" className="form-control" id="firstName" defaultValue={user.firstName}/>
                        <div id="name-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="lastName">Last name:</label>
                        <input type="text" className="form-control" id="lastName" defaultValue={user.secondName}/>
                        <div id="lastName-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="email">Email:</label>
                        <input type="email" className="form-control" id="email" defaultValue={user.email}/>
                        <div id="email-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" className="form-control" id="phone" defaultValue={user.phoneNumber}/>
                        <div id="phone-error"></div>
                    </div>
                    <button type="submit" className="btn btn-default">Save</button>
                    &nbsp;
                    <button className="btn btn-danger" onClick={this.cancel }>Cancel</button>
                    &nbsp;
                    <button type="button" className="btn btn-primary" onClick={this.props.showChangePassword}>Change
                        password
                    </button>
                </form>

                <Modal show={this.props.isChangePasswordOpen} onHide={this.props.showChangePassword} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title>
                            Change Password <span className="glyphicon glyphicon-repeat"></span>
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form role="form" onSubmit={this.handleChangePassword}>
                            <div className="form-group">
                                <label for="oldPassword">Old password:</label>
                                <input type="password" className="form-control" id="oldPassword"/>
                                <div id="oldPassword-error"></div>
                            </div>
                            <div className="form-group">
                                <label for="newPassword">New password:</label>
                                <input type="password" className="form-control" id="newPassword"/>
                                <div id="newPassword-error"></div>
                            </div>
                            <div className="form-group">
                                <label for="newPasswordCopy">Repeat:</label>
                                <input type="password" className="form-control" id="newPasswordCopy"/>
                                <div id="newPasswordCopy-error"></div>
                            </div>
                            <button type="submit" className="btn btn-default">Change</button>
                        </form>
                    </Modal.Body>
                </Modal>
            </div >
        )
    }
}

export default function (props) {
    return (
        <ProfileChange user={props.currentUser}
                       handleChange={props.handleChange}
                       showChangePassword={props.showChangePassword}
                       isChangePasswordOpen={props.isChangePasswordOpen}/>
    )
};
