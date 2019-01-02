var types = require('./actionTypes');

module.exports = {
    getClients: function (clients) {
        return {
            type: types.GET_CLIENTS,
            clients
        }
    },
    blockClient: function (clientId) {
        return{
            type: types.BLOCK_CLIENT,
            clientId
        }
    },

    showClientModal: function (clientId) {
        return{
            type: types.SHOW_CLIENT_MODAL,
            clientId
        }
    },

    hideClientModal: function () {
        return{
            type: types.HIDE_CLIENT_MODAL
        }
    }
};