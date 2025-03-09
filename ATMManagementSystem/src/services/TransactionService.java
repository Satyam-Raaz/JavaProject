package services;

import models.Transaction;
import repositories.TransactionImpl;

public class TransactionService {
    private  static TransactionImpl transactionImpl=new TransactionImpl();

    public boolean addTransaction(long atmNo,double amount){
        return transactionImpl.addTransaction(new Transaction(atmNo,amount));
    }

    public void getAllTransaction(){
        transactionImpl.getAllTransaction();
    }

}
