import React, {Component} from 'react';
import axios from 'axios';
export default class AnotherProfile extends Component{
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
    }


    componentDidMount() {
        axios.get(`http://localhost:8080/profile/${this.props.match.params.id}`,
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
        const value = this.state.user;
        return(<div className="container">
                <div className="row">
                    <div className="col-md-6  offset-md-0  toppad" >
                        <div className="card">
                            <div className="card-body">
                                <h2 className="card-title">{value.email}</h2>
                                <table className="table table-user-information ">
                                    <tbody>
                                    <tr>
                                        <td>Username:</td>
                                        <td>{value.username}</td>
                                    </tr>
                                    <tr>
                                        <td>First name:</td>
                                        <td>{value.firstName}</td>
                                    </tr>
                                    <tr>
                                        <td>Second name:</td>
                                        <td>{value.secondName}</td>
                                    </tr>
                                    <tr>
                                        <td>Phone:</td>
                                        <td>{value.phoneNumber}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

