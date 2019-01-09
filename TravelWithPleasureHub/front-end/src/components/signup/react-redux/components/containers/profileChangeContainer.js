import React,{Component} from'react'
import {bindActionCreators} from'redux'
import {connect} from"react-redux"
import ProfileChange from'../view/profileChange'
import profileApi from'../../api/profileApi'
import  showChangePassword  from'../../actions/profileActions'

export class ProfileChangeContainer extends React.Component{
    render() {
        return (
            <ProfileChange currentUser={this.props.currentUser}
                           handleChange={profileApi.changeProfile}
                           isChangePasswordOpen={this.props.isChangePasswordOpen}
                           showChangePassword={this.props.showChangePassword}/>
        )
    }
}
const mapStateToProps = function (store) {
    return {
        currentUser: store.userState.currentUser,
        isChangePasswordOpen : store.userState.isChangePasswordOpen
    }
};
const mapDispatchToProps = (dispatch) => bindActionCreators({
    showChangePassword: showChangePassword.showChangePassword
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(ProfileChangeContainer);