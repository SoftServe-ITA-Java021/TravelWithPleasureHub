import types from './actionTypes';
 export default {
  login: function (user) {
      return{
          type: types.LOGIN,
          user
      }
  },

  logout: function () {
      return {
          type: types.LOGOUT
      }
  },

   signUp: function (user) {
       return{
           type: types.SIGN_UP,
           user
       }
   },

   showLogin: function () {
       return{
           type: types.SHOW_LOGIN
       }
   },

   showSignUp: function () {
       return{
           type: types.SHOW_SIGN_UP
       }
   },

    changeProfile: function (profile) {
        return{
            type: types.CHANGE_PROFILE,
            profile
        }
    },
     showChangePassword: function () {
        return{
            type: types.SHOW_CHANGE_PASSWORD
        }
    },
};
