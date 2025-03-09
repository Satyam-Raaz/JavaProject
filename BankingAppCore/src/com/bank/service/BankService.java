package com.bank.service;

import com.bank.beans.Account;
import com.bank.repository.BankRepository;

public class BankService {
    public BankRepository repo;

    public BankService(BankRepository repo) {
        this.repo=repo;
    }

    public void deposit(int id,double amount){
        Account acc=repo.getAccount(id);
        if(acc!=null&& acc.isActive()){
            acc.setBalance(acc.getBalance()+amount);
            repo.addTransaction(id,"deposit",amount);
            System.out.println("Deposited " + amount);
        }
    }

    public void withdraw(int id,double amount){
        Account acc=repo.getAccount(id);
        if(acc!=null&& acc.isActive()){
            acc.setBalance(acc.getBalance()-amount);
            repo.addTransaction(id,"Withdraw",amount);
            System.out.println("Withdrawn " + amount);
        }
    }

    public void transfer(int fromId,int toId,double amount){
        Account fromAcc=repo.getAccount(fromId);
        Account toAcc=repo.getAccount(toId);
        if(fromAcc!=null&&toAcc!=null&& fromAcc.isActive()&& toAcc.isActive()&&fromAcc.getBalance()>=amount){
            fromAcc.setBalance(fromAcc.getBalance()-amount);
            toAcc.setBalance(toAcc.getBalance()+amount);
            repo.addTransaction(fromId, "Transfer to " + toId, amount);
            repo.addTransaction(toId, "Transfer from " + fromId, amount);
            System.out.println("Transferred " + amount + " from " + fromId + " to " + toId);
        }

    }
}
