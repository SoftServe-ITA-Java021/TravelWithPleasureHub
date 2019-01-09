import React from 'react';
import {Component} from 'react';
import { ButtonGroup, Button, Modal } from 'react-bootstrap';

class ClientModal extends React.Component{
    render() {
        let { client } = this.props;
        if(client) {
            return(
                <Modal show={this.props.isOpen} onHide={this.props.hide} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title>Login: {client.username}</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <table className="table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>{client.username}</td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td>{client.firstName}</td>
                            </tr>
                            <tr>
                                <td>Last name:</td>
                                <td>{client.secondName}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>{client.email}</td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>{client.phoneNumber}</td>
                            </tr>
                            </tbody>
                        </table>
                    </Modal.Body>
                </Modal>
            )
        }
        return(<p></p>)
    }
}
class Client extends React.Component{
    render() {
        var blockButton = "Block";
        var { client } = this.props;
        switch (client.enabled) {
            case false:
                blockButton = "Unblock";
        }
        return (
            <tr>
                <td>{client.id}</td>
                <td>
                    <button className="btn btn-link"
                            onClick={(e) => {e.preventDefault(); this.props.showClientModal(client.id);}}> {client.username} </button>
                </td>
                <td>{client.firstName} {client.secondName}</td>
                <td>
                    <ButtonGroup>
                        <Button bsStyle="danger"
                                onClick={(e) => {e.preventDefault(); this.props.blockClient(client.id);}}>
                            {blockButton}
                        </Button>
                    </ButtonGroup>
                </td>
            </tr>
        )
    }
}


export default function (props) {
    return (
        <div className="container">
            <h1>Clients:</h1>
            <table className="table">
                <thead>
                <tr>
                    <th>Client id</th>
                    <th>Login</th>
                    <th>Full name</th>
                    <th>Registration</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                {props.clients.map((client) => {
                    return (
                        <Client key={client.id}
                                client={client}
                                showClientModal={props.showClientModal}
                                blockClient={props.blockClient}/>
                    )
                })}
                </tbody>
            </table>
            <ClientModal client={props.client} isOpen={props.isClientModalOpen} hide={props.hideClientModal} />
        </div>
    )
};