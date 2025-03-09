package models;

public class Transaction {
    private double amount;
    private long atmNo;

    public Transaction(long atmNo,double amount){
        super();
        this.amount=amount;
        this.atmNo=atmNo;
    }

    public Transaction(){super();}

    public long getAtmNo() {
        return atmNo;
    }

    public void setAtmNo(long atmNo) {
        this.atmNo = atmNo;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString(){
        return "Transaction[amount="+amount+" , atmNo="+atmNo+ "]";

    }

}
