package service;

import beans.User;
import repository.UserRepo;

import java.util.List;

public class UserService {
    private static UserRepo userRepo=new UserRepo();

    public boolean addUser(String name,String email){
        return userRepo.addUser(new User(((long)(new User().hashCode())),name,email,"USER"));
    }
    public void loadAdmin(String name,String email){
        userRepo.loadAdmin(new User(((long)(new User().hashCode())),name,email,"ADMIN"));

    }


    public List<User> getAllUser(){
        return  userRepo.getAlluser();
    }

    public User getuserById(long id){
        return  userRepo.getUserById(id);
    }
    public User getUserByEmail(String email){

        return userRepo.getUserByEmail(email);
    }

    public boolean authenticateUser(String username,String email){
        List<User> users=userRepo.getAlluser();
        for(int i=0;i<userRepo.getAlluser().size();i++){
            if(users.get(i).getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }




}
