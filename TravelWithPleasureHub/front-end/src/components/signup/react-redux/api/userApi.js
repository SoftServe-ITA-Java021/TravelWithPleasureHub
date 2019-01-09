import $ from 'jquery';
import login from '../actions/userActions';
import logout from '../actions/userActions';
import store from '../store';

export default {
    login: function (user) {
        $.ajax({
            url: "http://localhost:8080/login",
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Access-Control-Allow-Origin','*');
                xhr.withCredentials = true;
            },
            data: user,
            success: function (data,status) {
                store.dispatch(login.login(data));
            },
            error: ()=>{
                alert('Try again');
            }
        });
    },
    logout: function () {
        var url = 'http://localhost:8080/logout';
        $.get(url,data =>{
            alert('Logout successfull');
            store.dispatch(logout.logout());
        })
    }
};