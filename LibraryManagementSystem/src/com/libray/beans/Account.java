package com.libray.beans;

public class Account {
    private int txnId;
    private int userId;
    private int bookId;
    private String issueDate;
    private  String dueDate;
    private double fine;
    private IssueStatus status;

    public Account(){
        super();
    }
    public Account(int txnId,int userId,int bookId,String issueDate,String dueDate,double fine,IssueStatus status){
        super();
        this.txnId=txnId;
        this.userId=userId;
        this.bookId=bookId;
        this.issueDate=issueDate;
        this.dueDate=dueDate;
        this.fine=fine;
        this.status=status;
    }

    public int getTxnId() {
        return txnId;
    }
    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public double getFine() {
        return fine;
    }
    public void setFine(double fine) {
        this.fine = fine;
    }
    public IssueStatus getStatus() {
        return status;
    }
    public void setStatus(IssueStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Account [txnId=" + txnId + ", userId=" + userId + ", bookId=" + bookId + ", issueDate=" + issueDate
                + ", dueDate=" + dueDate + ", fine=" + fine + ", status=" + status + "]";
    }
}
