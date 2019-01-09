import $ from 'jquery';
import login from '../actions/profileActions'
import logout from '../actions/profileActions'
import changeProfile from '../actions/profileActions';
import store from '../store';

export default {
    login: function (user) {
        $.ajax({
            url: "http://localhost:8080/login",
            type: "POST",
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
            },
            data: user,
            success: function (data) {
                store.dispatch(login.login(data));
            },
            error: () => {
                alert('Try again please!');
            }
        });
    },
    isLoginUnique: function (email) {
        return new Promise(function(resolve, reject) {
            $.ajax({
                url: "http://localhost:8080/loginCheck",
                type: 'GET',
                data: {email: email},
                success: function(data) {
                    resolve(data);
                },
                error: function() {
                    reject();
                }
            });
        });
    },
    logout: function () {
        var url = 'http://localhost:8080/logout';
        $.get(url, () => {
            this.context.router.history.push("/");
            store.dispatch(logout.logout());
        })
    },
    signUp: function (user) {
        $.ajax({
            url: "http://localhost:8080/registration",
            type: "POST",
            data: JSON.stringify(user),
            beforeSend(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(data);
                this.props.push("/");
            }
        });
    },
    changeProfile: function (profile) {
        let url = 'http://localhost:8080/profile/change';
        $.ajax({
            url: url,
            data: JSON.stringify(profile),
            type: "PUT",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(changeProfile.changeProfile(data));
            }
        });
    },
    getProfile: function () {
        return new Promise(function(resolve, reject) {
            $.ajax({
                url: "http://localhost:8080/get",
                type: 'GET',
                success: function() {
                    resolve();
                },
                error: function() {
                    reject();
                }
            });
        });
    }

};