var Redux = require('redux');
var profileReducer = require('./profileReducer');
var clientsReducer = require('./clientReducer');

module.exports = Redux.combineReducers({
    userState: profileReducer,
    clientsState: clientsReducer,
});