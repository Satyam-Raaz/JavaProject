package com.library.repository;

import com.libray.beans.Account;
import com.libray.beans.User;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private static List<Account> accounts=new ArrayList<>();
    private int accountCount=0;

    public boolean addAccount(Account account){
        accounts.add(account);
        return true;
    }

    public List<Account> getAllAccounts(){
        return accounts;
    }

    public  Account getAccountByUserId(int userId){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getUserId()==userId){
                return accounts.get(i);
            }
        }
        return null;
    }
}
