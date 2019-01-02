var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var { showLogin, showSignUp } = require('../../actions/profileActions');
var profileApi = require('../../api/profileApi');
var NavPanel = require('../view/navPanel');

var NavigationPanel = React.createClass({
    render : function() {
        return(
            <div>
                <NavPanel
                    userState={this.props.userState}
                    showLoginModal={this.props.showLogin}
                    showSignUpModal={this.props.showSignUp}
                    login={profileApi.login}
                    signUp={profileApi.signUp}
                    isLoginUnique={profileApi.isLoginUnique}
                    logout={profileApi.logout}
                />
                {this.props.children}
            </div>

        )
    }
});

const mapStateToProps = function(store) {
    return {

        userState : store.userState
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    showLogin, showSignUp
}, dispatch);

module.exports = ReactRedux.connect(
    mapStateToProps, mapDispatchToProps)(NavigationPanel);