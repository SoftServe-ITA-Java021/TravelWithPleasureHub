var $ = require('jquery');
var { login, logout, changeProfile } = require('../actions/profileActions');
var { hashHistory } = require('react-router');
var store = require('../store');

module.exports = {
    login: function (user) {
        $.ajax({
            url: "/login",
            type: "POST",
            beforeSend: function (xhr) {
                xhr.withCredentials = true;
            },
            data: user,
            success: function (data) {
                store.dispatch(login(data));
            },
            error: () => {
                alert('Try again please!');
            }
        });
    },
    isLoginUnique: function (login) {
        return new Promise(function(resolve, reject) {
            $.ajax({
                url: "/loginCheck",
                type: 'GET',
                data: {login: login},
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
        var url = '/j_spring_security_logout';
        $.get(url, () => {
            hashHistory.replace('/');
            store.dispatch(logout());
        })
    },
    signUp: function (user) {
        $.ajax({
            url: "/signUp",
            type: "POST",
            data: JSON.stringify(user),
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(login(data));
                hashHistory.replace('/profile');
            }
        });
    },
    changeProfile: function (profile) {
        var url = '/profile/change';
        $.ajax({
            url: url,
            data: JSON.stringify(profile),
            type: "PUT",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(changeProfile(data));
            }
        });
    },

};