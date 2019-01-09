import types from '../actions/actionTypes';

 let singleRole = function (user) {
    if (user.role.includes('ROLE_ADMIN')){
        return 'ROLE_ADMIN';
    }else
    {
        return 'ROLE_USER';
    }
};
let initialUserState = {
    currentUser: null,
    currentUserRole: null,
    isLoginOpen: false,
    isSignUpOpen: false,
    isChangePasswordOpen: false
};

export default function (state = initialUserState, action) {
    switch (action.type){
        case types.LOGIN:
            return Object.assign({},state,{
                currentUser: action.user,
                currentUserRole: singleRole(action.user),
                isLoginOpen: false,
                isSignUpOpen: false
            });
        case types.LOGOUT:
            return Object.assign({},state,{
                currentUser: null,
                currentUserRole: false
            });
        case types.SHOW_LOGIN:
            return Object.assign({},state,{
                isLoginOpen: !state.isLoginOpen
            });
        case types.SHOW_SIGN_UP:
            return Object.assign({},state,{
                isSignUpOpen: !state.isSignUpOpen
            });
        case types.CHANGE_PROFILE:
            return Object.assign({},state,{
                currentUser: action.profile,
                isChangePasswordOpen: !state.isChangePasswordOpen
            });
        case types.SHOW_CHANGE_PASSWORD :
            return Object.assign({}, state, {
                isChangePasswordOpen: !state.isChangePasswordOpen
            });
        default:
            return state;
    }
}