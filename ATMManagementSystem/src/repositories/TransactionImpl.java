package repositories;

import models.Transaction;

public class TransactionImpl {
    private Transaction[] transactions=new Transaction[100];
    private  int countTranscation=0;

    public boolean addTransaction(Transaction transaction){
        if(countTranscation<transactions.length){
            transactions[countTranscation++]=transaction;
            return  true;
        }
        return false;
    }

    public void getAllTransaction(){
        for(int i=0;i<transactions.length;i++){
            if(transactions[i]!=null) {
                System.out.println(transactions[i]);
            }
        }
    }
}
