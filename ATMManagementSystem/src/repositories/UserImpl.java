package repositories;

import models.User;

import java.util.Arrays;

public class UserImpl {
    private  User[] users=new User[100];
    private int countUser=0;

    public boolean addUser(User user){
        if(countUser<users.length){
            users[countUser++]=user;
            return true;
        }
        return false;

    }

    public     boolean loadAdmin(User admin){
        if(countUser<users.length){
            users[countUser++]=admin;
            return  true;
        }
        return false;
    }

    public void deleteUser(int id){
        for(int i=0;i<users.length;i++){
            if(users[i].getId()==id){
                users[i]=null;
                return;
            }
        }
    }

    public User getUserById(int id){
        User user=null;
        for(int i=0;i<users.length;i++){
            if(users[i].getId()==id){
                user=users[i];
                return user;
            }
        }
        return user;
    }



    public User[] getAllUser(){
        User[] dummy=new User[countUser];
        System.arraycopy(users,0,dummy,0,countUser);
        if(dummy.length<0){
            return null;
        }
        else{
            return dummy;
        }
    }
}
