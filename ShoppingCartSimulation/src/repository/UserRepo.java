package repository;

import beans.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    List<User> users=new ArrayList<User>();

    public boolean addUser(User user){
        users.add(user);
        return true;
    }
    public List<User> getAlluser(){
        return users;
    }
    public User getUserById(long id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId()==id){
                return  users.get(i);
            }
        }
        return null;
    }
    public User getUserByEmail(String email){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                return  users.get(i);
            }
        }
        return null;
    }

    public void loadAdmin(User user){
        users.add(user);
    }


}
