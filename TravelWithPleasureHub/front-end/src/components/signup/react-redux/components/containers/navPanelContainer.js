import React,{Component} from'react'
import {bindActionCreators} from'redux'
import {connect} from"react-redux"
import  showLogin from'../../actions/profileActions'
import  showSignUp from'../../actions/profileActions'
import profileApi from'../../api/profileApi'
import NavPanel from'../view/navPanel'

class  NavigationPanel extends React.Component{
    render() {
        return(
            <div>
                <NavPanel
                          userState={this.props.userState}
                          showLoginModal={this.props.showLogin}
                          showSignUpModal={this.props.showSignUp}
                          login={profileApi.login}
                          signUp={profileApi.signUp}
                          isLoginUnique={profileApi.isLoginUnique}
                          logout={profileApi.logout}/>

                {this.props.children}

            </div>

        )
    }
}

const mapStateToProps = function(store) {
    return {
        userState : store.userState
    }
};
const mapDispatchToProps = (dispatch) => bindActionCreators({
    showLogin:showLogin.showLogin, showSignUp: showSignUp.showSignUp
}, dispatch);

export default connect(
    mapStateToProps, mapDispatchToProps)(NavigationPanel);