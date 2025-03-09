package models;

public class Account {
    private int id;
    private long atmNo;
    private String name;
    private  double balance;
    private boolean isActive;
    public Account(int id,String name,double balance,long atmNo){
        super();
        this.id=id;
        this.name=name;
        this.balance=balance;
        this.isActive=true;
        this.atmNo=atmNo;
    }

    public Account(){super();}

    public long getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(long atmNo) {
        this.atmNo = atmNo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString(){
        return "Account[accountId="+id+" , Name="+name+" , balance="+balance+" ,isActive="+isActive+" , atmNo="+atmNo + "]";

    }
}
