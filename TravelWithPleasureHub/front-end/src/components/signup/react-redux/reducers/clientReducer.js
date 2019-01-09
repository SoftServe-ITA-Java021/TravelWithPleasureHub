import types from '../actions/actionTypes';

const initialClientsState = {
    clients: [],
    clientHistory: null,
    client: [],
    isClientModalOpen: false
};

let findClient = function(clientId, clients) {
    let newClient = {};
    clients.forEach((client) => {
        if(client.id == clientId) {
            newClient = client
        }
    });
    return newClient;
};
let filterBlock = function(userId, clients) {
    let newClients = [];
    clients.forEach((client) => {
        if(client.id == userId) {
            client.enabled = !client.enabled;
        }
        newClients.push(client);
    });
    return newClients;
};
export default function (state = initialClientsState, action) {
    switch (action.type) {
        case types.GET_CLIENTS:
            return Object.assign({}, state, {
                clients: action.clients
            });
        case types.BLOCK_CLIENT:
            return Object.assign({}, state, {
                clients : filterBlock(action.clientId, state.clients)
            });
        case types.SHOW_CLIENT_MODAL:
            return Object.assign({}, state, {
                client: findClient(action.clientId, state.clients),
                isClientModalOpen: true
            });
        case types.HIDE_CLIENT_MODAL:
            return Object.assign({}, state, {
                isClientModalOpen: false,
                client: null
            });
        default :
            return state;
    }
};
