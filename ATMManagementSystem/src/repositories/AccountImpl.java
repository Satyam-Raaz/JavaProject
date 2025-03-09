package repositories;

import models.Account;

public class AccountImpl {
    private Account[] accounts=new Account[100];
    private int countAccount=0;

    public boolean addAccount(Account account){
        if(countAccount<accounts.length){
            accounts[countAccount++]=account;
            return true;
        }
        return false;
    }

    public void deleteAccount(int id){
        for(int i=0;i<accounts.length;i++){
            if(id==accounts[i].getId()){
                accounts[i]=null;
            }
        }
    }

    public void getAllAccount(){
        for(int i=0;i<accounts.length;i++){
            if(accounts[i]!=null) {
                System.out.println(accounts[i]);
            }
        }
    }

    public Account getAccountById(int id){
        Account acc=null;
        for(int i=0;i<accounts.length;i++){
            if(accounts[i].getId()==id){
                acc=accounts[i];
                return acc;
            }
        }
        return acc;
    }

    public Account getAccountByATMNo(long atmNo){
        for(int i=0;i<accounts.length;i++){
            if(accounts[i].getAtmNo()==atmNo){
                return accounts[i];
            }
        }
        return null;
    }





}
