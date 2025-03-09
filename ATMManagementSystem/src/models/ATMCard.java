package models;

public class ATMCard {
    private  long atmNo;
    private int passsword;
    private int accountId;

    public ATMCard(long atmNo, int passsword, int accountId){
        super();
        this.accountId=accountId;
        this.atmNo=atmNo;
        this.passsword=passsword;
    }
    public ATMCard(){super();}

    public long getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(long atmNo) {
        this.atmNo = atmNo;
    }

    public int getPasssword() {
        return passsword;
    }

    public void setPasssword(int passsword) {
        this.passsword = passsword;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String toString(){
        return "ATMCard[ATM Number="+atmNo+" , password="+passsword+", Account="+accountId+"]";
    }

}
