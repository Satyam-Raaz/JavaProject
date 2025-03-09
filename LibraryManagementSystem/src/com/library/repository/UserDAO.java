package com.library.repository;

import com.libray.beans.User;

public class UserDAO {
    private static User[] users=new User[100];
    private static int userCount=0;

    public    static  boolean loadAdmin(User admin){
        if(userCount<users.length){
            users[userCount++]=admin;
            return  true;
        }
        return false;
    }

    public boolean addUser(User user){
        if(userCount<users.length){
            users[userCount++]=user;
            return true;
        }
        return false;
    }

    public User getUserByEmail(String email){
        for(int i=0;i<userCount;i++){
            if(users[i].getEmail().equals(email)){
                return users[i];
            }
        }
        return null;
    }
}
