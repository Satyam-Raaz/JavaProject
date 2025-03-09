package com.bank.beans;

public class User {
    private String username;
    private String password;
    private  String role;
    private  int accountId;
    private int mPin;
    private  int tPin;

    public User(String username,String password,String role,int accountId,int mPin,int tPin){
        super();
        this.username=username;
        this.password=password;
        this.role=role;
        this.accountId=accountId;
        this.mPin=mPin;
        this.tPin=tPin;
    }
    public User(String username,String password,String role,int accountId){
        super();
        this.username=username;
        this.password=password;
        this.role=role;
        this.accountId=accountId;
    }

    public User(){super();}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getmPin() {
        return mPin;
    }
    public void setmPin(int mPin){
        this.mPin=mPin;
    }

    public int gettPin() {
        return tPin;
    }
    public void settPin(int tPin){
        this.tPin=tPin;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", role=" + role + ", accountId=" + accountId
                + "]";
    }
}
