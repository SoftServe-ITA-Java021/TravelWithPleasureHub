package com.kh021j.travelwithpleasurehub.Registration;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class UserValidator {

    @Autowired
    private UserDAO userDAO;

    public boolean supports(Class<?> clazz) {
        return clazz == User.class;
    }

    public void validate(Object target, Errors errors) {
        User userForm = (User) target;

        // Check the fields of User
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.appUserForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.appUserForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.appUserForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.appUserForm.gender");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.appUserForm.countryCode");

        if (!errors.hasFieldErrors("userName")) {
            User dbUser = userDAO.findUserByName(userForm.getUsername());
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("userName", "Duplicate.appUserForm.userName");
            }
        }
    }
}
