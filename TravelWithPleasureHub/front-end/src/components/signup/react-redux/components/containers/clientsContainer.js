import React, {Component} from 'react';
import {bindActionCreators} from'redux';
import {connect} from'react-redux';
import clientsApi from'../../api/clientsApi';
import Clients from'../view/clients';
import  showClientModal from'../../actions/clientsActions';
import hideClientModal from '../../actions/clientsActions';

class ClientsContainer extends  React.Component{
    constructor(props){
        super(props);

        this.componentDidMount = this.componentDidMount.bind(this);
    }
    componentDidMount() {
        clientsApi.getClients();
    }
    render() {
        if(this.props.userState.currentUserRole != "ROLE_ADMIN") {
            return(
                <div className="container text-center">
                    404
                </div>
            )
        }
        if(this.props.children) {
            return(
                <div>
                    {this.props.children}
                </div>
            )
        }
        return(
            <Clients clients={this.props.clients}
                     client={this.props.client}
                     showClientModal={this.props.showClientModal}
                     hideClientModal={this.props.hideClientModal}
                     isClientModalOpen={this.props.isClientModalOpen}
                     blockClient={clientsApi.blockClient}  />
        )
    }
}
const mapStateToProps = function (store) {
    return {
        clients: store.clientsState.clients,
        client: store.clientsState.client,
        isClientModalOpen: store.clientsState.isClientModalOpen,
        userState : store.userState
    }
};
const mapDispatchToProps = (dispatch) => bindActionCreators({
    showClientModal: showClientModal.showClientModal, hideClientModal: hideClientModal.hideClientModal
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(ClientsContainer);

