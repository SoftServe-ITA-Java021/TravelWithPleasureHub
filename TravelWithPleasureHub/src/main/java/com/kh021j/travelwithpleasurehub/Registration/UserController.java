package com.kh021j.travelwithpleasurehub.Registration;


import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserValidator userValidator;
}
