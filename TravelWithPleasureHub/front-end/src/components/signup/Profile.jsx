import React, {Component} from 'react';
import axios from 'axios';
export default class Profile extends Component{
    constructor(props){
        super(props);

        this.state =
            {
                user: {
                    username: "",
                    firstName: "",
                    secondName: "",
                    email: "",
                    phoneNumber: ""
                },
                changed: false,
                isLoggedOut: false
            };
        this.handleLogout = this.handleLogout.bind(this);
    }


    componentDidMount() {
       axios.get(`http://localhost:8080/${this.props.match.params.id}`,
            {
                headers: {
                    'Access-Control-Allow-Credentials': 'include'
                },
                params:{
                    "email": this.props.email
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
                    Your login: {value.user.username} | <button onClick={this.handleLogout}>LOGOUT</button>
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
            </div>
        )
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
}



