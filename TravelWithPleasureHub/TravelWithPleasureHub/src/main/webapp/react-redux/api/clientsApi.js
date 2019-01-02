var $ = require('jquery');
var { getClients, blockClient } = require('../actions/clientsActions');
var store = require('../store');

module.exports = {
    getClients: function () {
        var url = '/clients/';
        $.ajax({
            url: url,
            type: "GET",
            success: function (data) {
                store.dispatch(getClients(data));
            }
        });
    },
    blockClient: function (userId) {
        var url = '/clients/' + userId + '0345';
        $.ajax({
            url: url,
            type: 'PUT',
            success: function () {
                store.dispatch(blockClient(userId));
            }
        });
    },

}
;