package com.kh021j.travelwithpleasurehub.validator;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class UserValidator implements Validator{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Required");
        if (user.getEmail()== null || user.getEmail().equals("")) {
            errors.rejectValue("email", "NotEmpty.userForm.email");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Pattern.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "NotEmpty.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Match.userForm.confirmPassword");
        }
    }
}
