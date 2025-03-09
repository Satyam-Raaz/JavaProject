package models;

public class User {
    private int id;
    private  int password;
    private String role;

    public User(int id,int password,String role){
        super();
        this.id=id;
        this.password=password;
        this.role=role;
    }
    public User(){super();}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    public String getRole(){
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString(){
        return "Account[userId="+id+" , Password="+password+" , Role="+role+"]";
    }
}
