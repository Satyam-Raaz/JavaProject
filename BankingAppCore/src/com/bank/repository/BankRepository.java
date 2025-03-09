package com.bank.repository;
import com.bank.beans.*;
public class BankRepository {
    Account[] accounts=new Account[100];
    Transaction[] transactions=new Transaction[1000];
    User[] users=new User[100];
    private int accountCount=0;
    private int transactionCount=0;
    private int userCount=0;



    public  void createAccount(int id,String name,double balance ,boolean isActive){
        if(accountCount<accounts.length){
            accounts[accountCount++]=new Account(id,name,balance,isActive);
        }
    }

    public Account getAccount(int id){
        for(int i=0;i<accountCount;i++){
            if(accounts[i].getId()==id){
                return accounts[i];
            }
        }
        return null;
    }

    public Account getAllAccounts(){
        for(int i=0;i<accountCount;i++){
            System.out.println(accounts[i]);
        }
        return  null;
    }

    public void updateAccount(int id ,String name,double balance){
        Account acc=getAccount(id);
        if(acc!=null){
            acc.setName(name);
            acc.setBalance(balance);
        }
    }

    public void deleteAccount(int id){
        Account acc=getAccount(id);
        for(int i=0;i<accountCount;i++){
            if(acc!=null&&accounts[i].getId()==id){
                accounts[i]=null;
            }
        }
    }

    public void viewBalance(int accountId){
        System.out.println("Available Balance for Account "+accountId+" : ");
        for(int i=0;i<accountCount;i++){
            if(accounts[i]!=null&&accounts[i].getId()==accountId){
                System.out.println(accounts[i].getBalance());
            }
        }
    }

    public void addUser(String username,String password,String role,int accountId,int mPin,int tPin){
        if(userCount<users.length){
            users[userCount++]=new User(username,password,role,accountId,mPin,tPin);
        }
    }
    public void addUser(String username,String password,String role,int accountId){
        if(userCount<users.length){
            users[userCount++]=new User(username,password,role,accountId);
        }
    }

    public User authenticateUser(String username,String password){
        for(int i=0;i<userCount;i++){
            if(users[i]!=null && users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                return  users[i];
            }
        }
        return null;
    }

    public void toggleAccountStatus(int accountId){
        Account acc=getAccount(accountId);
        if(acc!=null){
            acc.setActive(!acc.isActive());
            System.out.println("Account " + accountId + " is now " + (acc.isActive() ? "Active" : "Disabled"));
        }
    }

    public void addTransaction(int accountId,String type, double balance){
        if(transactionCount<transactions.length){
            transactions[transactionCount++]=new Transaction(accountId,type,balance);
        }
    }

    public void viewTransaction(){
        for(int i=0;i<transactionCount;i++){
            System.out.println("Account " + transactions[i].getAccountId() + " " + transactions[i].getType() + " " + transactions[i].getAmount());
        }
    }

    public  void viewTransactionByAccountId(int accountId){
        for(int i=0;i<transactionCount;i++){
            if(transactions[i]!=null&&transactions[i].getAccountId()==accountId){
                System.out.println(transactions[i].getType() + " - " + transactions[i].getAmount());
            }
        }
    }

    public User getUser(int accountId){
        for(int i=0;i<userCount;i++){
            if(users[i].getAccountId()==accountId){
                return users[i];
            }
        }
        return null;
    }

    public boolean authenticateMPin(int accountId,int mPin){
        User user=getUser(accountId);
        if(user!=null&&user.getmPin()== mPin){
            return true;
        }
        return false;
    }

    public boolean authenticateTPin(int accountId,int tPin){
        User user=getUser(accountId);
        if(user!=null&&user.gettPin()== tPin){
            return true;
        }
        return false;
    }



}
