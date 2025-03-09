package com.library.service;

import com.library.repository.UserDAO;
import com.libray.beans.User;

public class UserService {
    private UserDAO userDAO=new UserDAO();

    public boolean registerUser(String name,String email,String password){
        if(userDAO.getUserByEmail(email)!=null){
            return false;
        }
        return userDAO.addUser(new User(new User().hashCode(),name,email,password,"USER"));
    }

    public User loginUser(String email,String password){
        User user=userDAO.getUserByEmail(email);
        if(user!=null&&user.getPassword().equals(password)){
            return user;
        }
        return null;
    }


}
