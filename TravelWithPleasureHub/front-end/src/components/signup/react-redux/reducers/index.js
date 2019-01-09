import {combineReducers} from 'redux';
import profileReducer from'./profileReducer';
import clientsReducer from'./clientReducer';

export default combineReducers({
    userState: profileReducer,
    clientsState: clientsReducer,
});