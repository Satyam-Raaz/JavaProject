package controllers;

import models.ATMCard;
import models.Account;
import models.User;
import repositories.ATMCardImpl;
import repositories.UserImpl;
import services.ATMCardService;
import services.AccountService;
import services.TransactionService;
import services.UserService;

import java.util.Scanner;

public class controller {
    private static AccountService accountService=new AccountService();
    private static ATMCardService atmService=new ATMCardService();
    private static UserService userService=new UserService();
    private static TransactionService transactionService=new TransactionService();
    private static User user=null;
    static {
        userService.loadAdmin(101,1254,"ADMIN");
    }

    public static void main(String[] args) {
        while(true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("\n----Event ManagementSystem-----");
            System.out.println("1. Register");
            System.out.println("2. LOGIN");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    Login();
                    break;
                case  3:
                    System.out.println("Existing System GoodBye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice , Try Again");

            }
        }
    }

    //private static Scanner scanner=new Scanner(System.in);

    public static void registerUser(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter id: ");
        int id= scanner.nextInt();
        System.out.println("Enter Password: ");
        int password= scanner.nextInt();
        Account acc=accountService.getAccountById(id);
        if(userService.registerUser(id,password)&&acc!=null){
            System.out.println("Registration successfully");
        }
        else {
            System.out.println("Registration not successfull");
        }

    }

    public static void Login(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter id: ");
        int id= scanner.nextInt();
        System.out.println("Enter Password: ");
        int password= scanner.nextInt();
        user=userService.authenticateUser(id,password);
        if(user!=null){
            System.out.println("Login successfully");
            if(user.getRole().equals("ADMIN")){
                adminMenu();
            }
            else {
                userMenu();
            }
        }
        else {
            System.out.println("Invalid Id or password");
        }


    }

    public static void  adminMenu() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n----Welcome Admin-----");
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Log Out");
            System.out.println("Enter Your Choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Account Id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter ATM Number: ");
                    long atmNo = scanner.nextLong();
                    System.out.println("Enter Name: ");
                    String name = scanner.next();
                    System.out.println("Enter Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    if (accountService.addAccount(id, name, balance, atmNo)) {
                        System.out.println("Account added successfully!!!");
                    } else {
                        System.out.println("Account is not added");
                    }
                    adminMenu();
                    break;
                case 2:
                    accountService.getAllAccount();
                    adminMenu();
                    break;
                case 3:
                    System.out.println("Enter Account Id: ");
                    int accId = scanner.nextInt();
                    accountService.deleteAccount(accId);
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Log Out Successfully!!!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }

    }

    public static void userMenu() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n----Welcome User----");
            System.out.println("1. Withdraw");
            System.out.println("2. View Your Account");
            System.out.println("3. Apply ATM Card");
            System.out.println("4. View ATM Card ");
            System.out.println("5. View Transaction History ");
            System.out.println("6. LogOut ");
            System.out.println("Enter Your Choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter ATM Number: ");
                    long atmNo= scanner.nextLong();
                    System.out.println("Enter Password: ");
                    int passord= scanner.nextInt();
                    System.out.println("Enter Amount: ");
                    double amount= scanner.nextDouble();
                    if(atmService.authenticateATMCard(atmNo,passord)){
                        Account acc=accountService.getAccountByATMNo(atmNo);
                        acc.setBalance(acc.getBalance()-amount);
                        transactionService.addTransaction(atmNo,amount);
                        System.out.println("Withdraw :"+ amount);
                    }
                    else{
                        System.out.println("Invalid password");
                    }
                    userMenu();
                    break;
                case 2:
                    System.out.println("Enter Account Id: ");
                    int accId= scanner.nextInt();
                    Account acc=accountService.getAccountById(accId);
                    if(acc!=null){
                        System.out.println(acc);
                    }
                    else{
                        System.out.println("Account details not present");
                    }
                    userMenu();
                    break;
                case 3:
                    System.out.println("Enter PIN: ");
                    int pin= scanner.nextInt();
                    System.out.println("Enter Account Id: ");
                    int id= scanner.nextInt();
                    Account account=accountService.getAccountById(id);
                    long  atmno= account.getAtmNo();
                    if(account!=null) {
                        if (atmService.addATMcard(atmno, pin, id)) {
                            System.out.println("Apply Successfully");
                        } else {
                            System.out.println("Rejected");
                        }
                    }
                    userMenu();
                    break;
                case 4:
                    System.out.println("Enter ATM Number: ");
                    long num= scanner.nextLong();
                    ATMCard atm=atmService.getATMCardByNum(num);
                    if(atm!=null){
                        System.out.println(atm);
                    }
                    else {
                        System.out.println("ATM Not Applied");
                    }
                    userMenu();
                    break;
                case 5:
                    transactionService.getAllTransaction();
                    userMenu();
                    break;
                case 6:
                    System.out.println("Log Out Successfully!!!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
    }

}
