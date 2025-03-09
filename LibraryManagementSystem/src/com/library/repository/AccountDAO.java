package com.library.repository;

import com.libray.beans.Account;
import com.libray.beans.User;

public class AccountDAO {
    private Account[] accounts=new Account[100];
    private int accountCount=0;

    public boolean addAccount(Account account){
        if(accountCount<accounts.length){
            accounts[accountCount++]=account;
            return true;
        }
        return false;
    }

    public Account[] getAllAccounts(){
        Account[] acc=new Account[accountCount];
        System.arraycopy(accounts,0,acc,0,accountCount);
        return acc;
    }

    public  Account getAccountByUserId(int userId){
        for(int i=0;i<accountCount;i++){
            if(accounts[i].getUserId()==userId){
                return accounts[i];
            }
        }
        return null;
    }
}
