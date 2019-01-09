import React ,{Component}from 'react';
export class Profile extends React.Component{
    render() {
        var user = this.props.user;
        return(
            <div className="container">
                <h2 className="page-header">
                    Your login: {user.username}
                </h2>
                <table className="table">
                    <tbody>
                    <tr>
                        <td>Username:</td>
                        <td>{user.username}</td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>{user.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td>{user.secondName}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>{user.email}</td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td>{user.phoneNumber}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}
export default function (props) {
    return (
        <Profile user={props.currentUser}/>
    )
};