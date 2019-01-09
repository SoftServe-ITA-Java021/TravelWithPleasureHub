import types from '../actions/actionTypes';

let initialUserState = {
    users: [],
    user: [],
    currentUser: null,
    currentUserRole: null,
    isLoginOpen: false
};
 let singleRole = function (user) {
    if (user.role.includes('ROLE_ADMIN')){
        return 'ROLE_ADMIN';
    }else {
        return 'ROLE_USER';
    }
};

export default function (state = initialUserState, action) {
    switch (action.type){
        case types.LOGIN:
            return Object.assign({},state,{
                currentUser: action.user,
                currentUserRole: singleRole(action.user),
                isLoginOpen: false
            });
        case types.LOGOUT:
            return Object.assign({},state,{
                currentUser: null,
                currentUserRole: null
            });
        case types.SHOW_LOGIN:
            return Object.assign({}, state,{
                isLoginOpen: !state.isLoginOpen
            });
        default:
            return state;
    }
}