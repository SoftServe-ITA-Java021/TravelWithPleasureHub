let React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button } = require('react-bootstrap');
var { showLogin } = require('../../actions/userActions');
var userApi = require('../../api/userApi');
var $ = require('jquery');

const NavBarAdmin = React.createClass({
    render : function() {
        return(
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#/">I-shop</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavItem href="#">Clients</NavItem>
                    </Nav>
                    <Nav pullRight>
                        <NavItem href="#">{this.props.login}</NavItem>
                        <NavItem href="#"
                                 onClick={this.props.logout} >
                            Logout
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});
const NavBarGuest = React.createClass({
    handleLogin : function() {
        userApi.login($("#loginForm").serialize());
    },
    render : function() {
        return(
            <div>
                <Navbar inverse>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <a href="#/">I-shop</a>
                        </Navbar.Brand>
                        <Navbar.Toggle />
                    </Navbar.Header>
                    <Navbar.Collapse>
                        <Nav pullRight>
                            <NavItem href="#">Sign up</NavItem>
                            <NavItem href="#"
                                     onClick={(e) => {
                                         e.preventDefault();
                                         userApi.login();
                                     }}>
                                Login
                            </NavItem>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                <div className="container">
                    <form role="form" action="/j_spring_security_check" method="post" id="loginForm" onSubmit={(e) => {e.preventDefault(); this.handleLogin();}} >
                        <div className="form-group">
                            <label for="login">Login:</label>
                            <input className="form-control" id="login" placeholder="Enter login" name="j_username" />
                        </div>
                        <div className="form-group">
                            <label for="pwd"> Password:</label>
                            <input type="password" className="form-control" id="pwd" placeholder="Enter password" name="j_password" />
                        </div>
                        <button type="submit" className="btn btn-default"> Submit</button>
                    </form>
                </div>
            </div>
        )
    }
});
const NavBarUser = React.createClass({
    render : function() {
        return(
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#/">I-shop</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav pullRight>
                        <NavItem href="#">{this.props.login}</NavItem>
                        <NavItem href="/j_spring_security_logout"
                                 onClick={this.props.logout} >
                            Logout
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});

var Navigation = React.createClass({
    render : function () {
        var NavBar = NavBarGuest;
        switch (this.props.currentUserRole) {
            case 'ROLE_USER' :
                NavBar = NavBarUser;
                break;
            case 'ROLE_ADMIN' :
                NavBar = NavBarAdmin;
                break;
            case null : break;
        }

    }
});

const mapStateToProps = function(store) {
    return {
        currentUser : store.userState.currentUser,
        currentUserRole : store.userState.currentUserRole,
        isLoginOpen : store.userState.isLoginOpen
    }
};
module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(Navigation);