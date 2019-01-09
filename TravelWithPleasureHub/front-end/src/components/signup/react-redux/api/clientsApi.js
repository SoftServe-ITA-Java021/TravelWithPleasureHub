import $ from 'jquery';
import getClients from '../actions/clientsActions';
import blockClient from '../actions/clientsActions';
import store from '../store';
export default {
    getClients: function () {
        let url = 'http://localhost:8080/clients/';
        $.ajax({
            url: url,
            type: "GET",
            success: function (data) {
                store.dispatch(getClients.getClients(data));
            }
        });
    },
    blockClient: function (userId) {
        let url = 'http://localhost:8080/clients/' + userId + '0345';
        $.ajax({
            url: url,
            type: 'PUT',
            success: function () {
                store.dispatch(blockClient.blockClient(userId));
            }
        });
    },

}
;