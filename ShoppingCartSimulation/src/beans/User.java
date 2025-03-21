package beans;

public class User {
    private long id;
    private String username;
    private String email;
    private String userType;
    public User(long id,String username,String email,String userType){
        super();
        this.id=id;
        this.username=username;
        this.email=email;
        this.userType=userType;
    }
    public User(){super();}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", Username=" + username + ", Email=" + email + ", role=" + userType + "]";
    }
}
