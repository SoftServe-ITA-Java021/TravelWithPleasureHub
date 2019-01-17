import React, {Component} from 'react';
import axios from 'axios';
import $ from 'jquery';
export default class Profile extends Component{
    constructor(props){
        super(props);

        this.state =
            {
                user: {
                    id: -1,
                    username: "",
                    firstName: "",
                    secondName: "",
                    email: "",
                    phoneNumber: ""
                },
                changed: false,
                isLoggedOut: false
            };

        this.usernameChange = this.usernameChange.bind(this);
        this.firstNameChange = this.firstNameChange.bind(this);
        this.secondNameChange= this.secondNameChange.bind(this);
        this.phoneNumberChange= this.phoneNumberChange.bind(this);

        this.usernameBody = this.usernameBody.bind(this);
        this.firstNameBody = this.firstNameBody.bind(this);
        this.secondNameBody = this.secondNameBody.bind(this);
        this.phoneNumberBody = this.phoneNumberBody.bind(this);

        this.handleLogout = this.handleLogout.bind(this);
        this.handleSubmitChange = this.handleSubmitChange.bind(this);
        this.isProfileValid = this.isProfileValid.bind(this);

    }


    componentDidMount() {
<<<<<<< HEAD
        axios.get(`http://localhost:8080/profile`,
=======
       axios.get(`http://localhost:8080/${this.props.match.params.id}`,
>>>>>>> origin/dev
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                }
            })
            .then(json => this.setState({user: json.data, changed: true, status: json.status}));
    }

    render(){
        const value = this.state;
        return(
            <div>
                {!this.state.isLoggedOut ?<div className="container">
                    <h2 className="page-header">
                        Your login: {value.user.username} | <button className="btn btn-default" onClick={this.handleLogout}>LOGOUT</button> | <button className="btn btn-warning"
                                                                                                                                                      data-toggle="collapse"
                                                                                                                                                      aria-expanded="false"
                                                                                                                                                      aria-controls="changeProfile"
                                                                                                                                                      data-target="#changeProfile">Change Profile</button>
                    </h2>
                    <table className="table">
                        <tbody>
                        <tr>
                            <td>Name:</td>
                            <td>{value.user.firstName}</td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td>{value.user.secondName}</td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                            <td>{value.user.email}</td>
                        </tr>
                        <tr>
                            <td>Phone:</td>
                            <td>{value.user.phoneNumber}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>: ""}
                <div id="changeProfile" className="collapse">
                    <div className="container">
                        <h2 className="page-header">Your login: {value.username}</h2>
                        <form onSubmit={this.handleSubmitChange}>
                            {this.usernameBody()}
                            {this.firstNameBody()}
                            {this.secondNameBody()}
                            {this.phoneNumberBody()}
                            <button type="submit" className="btn btn-success">Save</button>
                            &nbsp;
                            <button className="btn btn-danger" onClick={this.cancel }>Cancel</button>
                            &nbsp;
                        </form>
                    </div>
                </div>
            </div>
        )
    }

    isProfileValid(form){
        let isValid = true;
        if (form.firstName === '') {
            $("#fName-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>First name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#fName-error").html("");
        }
        if (form.secondName === '') {
            $("#sName-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Second name cannot be empty!</div>");
            isValid = false;
        } else {
            $("#sName-error").html("");
        }
        if (form.username === '') {
            $("#username-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Username cannot be empty!</div>");
            isValid = false;
        } else {
            $("#username-error").html("");
        }
        let regExpPhone = /(380+[0-9]{9})/;
        if (!regExpPhone.test(form.phoneNumber)) {
            $("#phoneNumber-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Phone is not valid!</div>");
            isValid = false;
        } else {
            $("#phoneNumber-error").html("");
        }
        if (form.password === '') {
            $("#password-error").fadeOut(3000).html("<br/><div class='alert alert-danger'>Password cannot be empty!</div>");
            isValid = false;
        } else {
            $("#password-error").html("");

        }
        return isValid;
    }

    handleLogout(e){
        e.preventDefault();
        axios.get("http://localhost:8080/logout").then(
            response => {
                if (response.status === 200){
                    this.setState({
                        email: "",
                        isLoggedOut: true
                    })
                }
            }
        )
    }

    handleSubmitChange(e){
        e.preventDefault();
        let user = this.state.user;
        let changeUser =new FormData();
        changeUser.append("id",user.id);
        changeUser.append("username",$("#username").val());
        changeUser.append("firstName",$("#firstName").val());
        changeUser.append("secondName",$("#secondName").val());
        changeUser.append("email",user.email);
        changeUser.append("phoneNumber",$("#phoneNumber").val());
        changeUser.append("password",user.password);
        changeUser.append("status","true");
        changeUser.append("role","ROLE_USER");
        let form = {
            username: $("#username").val(),
            firstName: $("#firstName").val(),
            secondName:$("#secondName").val(),
            phoneNumber:$("#phoneNumber").val(),
        };
        if (this.isProfileValid(form)){
            fetch("http://localhost:8080/change",
                {
                    method: "PUT",
                    body: changeUser
                })
        }
    }

    usernameBody(){
        return <div className="form-group">
            <label>Username:</label>
            <input
                type="text"
                className="form-control"
                id="username"
                value={this.state.username}
                onChange={this.usernameChange}
                placeholder="Enter new username"/>
            <div id="username-error"></div>
        </div>
    }
    firstNameBody(){
        return   <div className="form-group">
            <label>First name:</label>
            <input
                type="text"
                className="form-control"
                id="firstName"
                value={this.state.firstName}
                onChange={this.firstNameChange}
                placeholder="Enter new first name"/>
            <div id="fName-error"></div>
        </div>
    }

    secondNameBody(){
        return  <div className="form-group">
            <label>Second name:</label>
            <input type="text"
                   className="form-control"
                   id="secondName"
                   value={this.state.secondName}
                   onChange={this.secondNameChange}
                   placeholder="Enter new second name"/>
            <div id="sName-error"></div>
        </div>
    }

    phoneNumberBody(){
        return  <div className="form-group">
            <label>Phone:</label>
            <input type="text"
                   className="form-control"
                   id="phoneNumber"
                   value={this.state.phoneNumber}
                   onChange={this.phoneNumberChange}
                   defaultValue={this.state.phoneNumber}
                   placeholder="Enter new phone number"/>
            <div id="phoneNumber-error"></div>
        </div>
    }


    usernameChange(event){
        this.setState({username: event.target.value})
    }
    firstNameChange(event){
        this.setState({firstName: event.target.value})
    }

    secondNameChange(event){
        this.setState({secondName: event.target.value})
    }

    phoneNumberChange(event){
        this.setState({phoneNumber: event.target.value})
    }




}
