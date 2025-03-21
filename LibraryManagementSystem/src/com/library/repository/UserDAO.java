package com.library.repository;

import com.libray.beans.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users=new ArrayList<>();
    private static int userCount=0;

    public    static  boolean loadAdmin(User admin){
        users.add(admin);
        return true;
    }

    public boolean addUser(User user){
        users.add(user);
        return  true;
    }

    public User getUserByEmail(String email){
        for(int i=0;i< users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                return users.get(i);
            }
        }
        return null;
    }
    public List<User> getAllUser(){
        return users;
    }
}
