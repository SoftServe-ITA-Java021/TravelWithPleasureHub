import React,{Component} from'react'
import {connect} from"react-redux"
import Profile from '../view/profile';

class ProfileContainer extends React.Component{
    render() {
        return (
            <Profile currentUser={this.props.currentUser}/>
        )
    }
}

const mapStateToProps = function (store) {
    return {
        currentUser: store.userState.currentUser
    }
};

export default connect(mapStateToProps)(ProfileContainer);