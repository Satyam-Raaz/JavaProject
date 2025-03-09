package services;

import models.User;
import repositories.UserImpl;

public class UserService {
    private UserImpl userImpl=new UserImpl();
    public boolean addUser(int id,int password,String role){

        return userImpl.addUser(new User(id,password,"USER"));
    }

    public void deleteUser(int id){
        userImpl.deleteUser(id);
    }

    public void getAllUser(){
        User[] user= userImpl.getAllUser();
        if(user==null){
            System.out.println("User Not Found");
        }
        else {
            System.out.println(user);
        }
    }

    public boolean loadAdmin(int id ,int password,String role){
        return userImpl.loadAdmin(new User(id,password,role));
    }


    public boolean registerUser(int id,int password){
        return userImpl.addUser(new User(id,password,"USER"));
    }

    public  User authenticateUser(int id,int password){
        User user=userImpl.getUserById(id);
        if(user!=null&&user.getPassword()==password){
            return  user;
        }
        return null;
    }


}
