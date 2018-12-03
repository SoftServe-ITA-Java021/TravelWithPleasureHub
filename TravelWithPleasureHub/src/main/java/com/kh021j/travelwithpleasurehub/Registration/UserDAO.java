package com.kh021j.travelwithpleasurehub.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDAO {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    private static void initData (){
        String encrytedPassword = "";

        User first = new User ( "olgaOp", "123456", "123@gmail.com", "Olga",
                "Opari", "UA", "one", "0931234567");


        USER_MAP.put(first.getId(), first);
    }

    public Integer getMaxUserId (){
        int max = 0;
        for (Integer id:USER_MAP.keySet()){
            if (id>max){
                max = id;
            }
        }
        return max;
    }

    public User findUserByName (String userName){
        Collection <User> users = USER_MAP.values();
        for (User us: users){
            if (us.getUsername().equals(userName)){
                return us;
            }
        }
        return null;
    }

    public User findUserByEmail (String email){
        Collection <User> users = USER_MAP.values();
        for (User us : users){
            if (us.getEmail().equals(email)){
                return us;
            }
        }
        return null;
    }

    public List<User> getUsers (){
        List <User> userList = new ArrayList<>();
        userList.addAll(USER_MAP.values());
        return userList;
    }

    public User createUserForm (User form){
        Integer id = this.getMaxUserId()+1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());

        User user = new User ("kitty", encrytedPassword, "kitty@gmail.com", "Kate",
                "Ivanova", "UA", "two", "0631231231");

        USER_MAP.put(id, user);
        return user;
    }
}
