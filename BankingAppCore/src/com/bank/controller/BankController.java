package com.bank.controller;

import com.bank.beans.Account;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;
import com.bank.beans.User;

import java.util.Scanner;

public class BankController {
    static BankRepository repo=new BankRepository();
    static BankService service=new BankService(repo);
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("1. Register 2. Login 3. Exit");
            System.out.println("Enter Choice: ");
            int choice= scanner.nextInt();
            if (choice==1){
                registerUser();
            } else if (choice==2) {
                loginUser();
            }
            else{
                System.out.println("Exit");
                break;
            }

        }
    }

    static  void registerUser(){
        System.out.println("Enter Username: ");
        String username= scanner.next();
        System.out.println("Enter Password: ");
        String password= scanner.next();
        System.out.println("Enter Role (Admin/Customer): ");
        String role= scanner.next();
        int accountId=-1;
        if(role.equalsIgnoreCase("Customer")){
            System.out.println("Enter Accounnt Id: ");
            accountId= scanner.nextInt();
            System.out.println("Set MPin: ");
            int mpin= scanner.nextInt();
            System.out.println("Set Transaction Pin : ");
            int tpin= scanner.nextInt();
            service.repo.addUser(username,password,role,accountId,mpin,tpin);
            System.out.println("User Registered Successfully");
        }
        else{
           service.repo.addUser(username,password,role,accountId);
           System.out.println("User Registered Successfully");
        }
    }

    static void loginUser(){
        System.out.println("Enter userneme: ");
        String username= scanner.next();
        System.out.println("Enter password: ");
        String password= scanner.next();
        User user=service.repo.authenticateUser(username,password);
        if(user!=null){
            if(user.getRole().equalsIgnoreCase("Admin")){
                adminMenu();
            }else {
                userMenu(user.getAccountId());
            }
        }
        else{
            System.out.println("Invalid Email or Password");
        }
    }

    static  void adminMenu(){
        while(true){
            System.out.println("1. Create Account 2. Enable/Disable Account  3.View All transactions 4.View All accounts 5.Logout");
            System.out.println("Enter choice: ");
            int choice= scanner.nextInt();
            if(choice==1){
                System.out.println("Enter Account Id: ");
                int id= scanner.nextInt();
                System.out.println("Enter name: ");
                String name= scanner.next();
                System.out.println("Enter Amount: ");
                double amount = scanner.nextDouble();
                service.repo.createAccount(id,name,amount,true);
            } else if (choice==2) {
                System.out.println("Enter Account Id: ");
                int id= scanner.nextInt();
                service.repo.toggleAccountStatus(id);
            } else if (choice==3) {
                System.out.println("Here All Transaction ");
                service.repo.viewTransaction();
            } else if (choice==4) {
                System.out.println("Here Qll Accounts");
                service.repo.getAllAccounts();
            }
            else {
                System.out.println("loout sucessfully");
                break;
            }


        }
    }
    static void  userMenu(int accountId){
        while (true){
            System.out.println("1. Deposit 2. Withdraw 3. Transfer 4. View Transactions 5. view Balance 6. Logout");
            System.out.println("choose Your Choice: ");
            int choice= scanner.nextInt();
            if(choice==1){
                System.out.println("Enter Amount ");
                double amount= scanner.nextInt();
                System.out.println("Enter Transaction Pin: ");
                int tpin= scanner.nextInt();
                if(service.repo.authenticateTPin(accountId,tpin)){
                    service.deposit(accountId,amount);
                }
                else{
                    System.out.println("Invalid Transaction Pin Try Again");
                }
            } else if (choice==2) {
                System.out.println("Enter Amount ");
                double amount= scanner.nextInt();
                System.out.println("Enter Transaction Pin: ");
                int tpin= scanner.nextInt();
                if(service.repo.authenticateTPin(accountId,tpin)){
                    service.withdraw(accountId,amount);
                }
                else{
                    System.out.println("Invalid Transaction Pin Try Again");
                }
            } else if (choice==3) {
                System.out.println("Enter To Account Id: ");
                int toId= scanner.nextInt();
                System.out.println("Enter Amount ");
                double amount= scanner.nextInt();
                System.out.println("Enter Transaction Pin: ");
                int tpin= scanner.nextInt();
                if(service.repo.authenticateTPin(accountId,tpin)){
                    service.transfer(accountId,toId,amount);
                }
                else {
                    System.out.println("Invalid Transaction Pin Try Again");
                }
            } else if (choice==4) {
                service.repo.viewTransactionByAccountId(accountId);
            } else if (choice==5) {
                service.repo.viewBalance(accountId);
            }else {
                System.out.println("Logout Successfully");
                break;
            }

        }
    }
}
