package services;

import models.Account;
import repositories.AccountImpl;

public class AccountService {
    private AccountImpl acc=new AccountImpl();
    public Boolean addAccount(int id,String name,double balance,long atmNo){
        return acc.addAccount(new Account(id,name,balance,atmNo));
    }
    public void deleteAccount(int id){
        acc.deleteAccount(id);
    }
    public void getAllAccount(){
        acc.getAllAccount();
    }

    public Account getAccountById(int id){
        return acc.getAccountById(id);
    }
    public Account getAccountByATMNo(long atmNo){
        return acc.getAccountByATMNo(atmNo);
    }
}
