package com.library.controller;


import com.library.repository.UserDAO;
import com.library.service.AccountService;
import com.library.service.BookService;
import com.library.service.UserService;
import com.libray.beans.Account;
import com.libray.beans.Book;
import com.libray.beans.User;
import java.time.LocalDate;
import com.libray.beans.IssueStatus;



import java.security.PrivateKey;
import java.util.Scanner;

public class LibraryMainController {
    private static Scanner scanner=new Scanner(System.in);
    private  static UserService userService=new UserService();
    private static BookService adminService=new BookService();
    private static AccountService accountService=new AccountService();
    private static User  loggedInUser=null;

    static {
        UserDAO.loadAdmin(new User(1,"admin","admin@email","admin@123","ADMIN"));
    }

    public static void main(String[] args) {

        while (true){
            System.out.println("---Digital Library Application----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exit Successfull....");
                    return;
                default:
                    System.out.println("Invalid choice Try Again");
            }
        }
    }

    private static   void registerUser(){
        System.out.println("Enter Your Name: ");
        String name=scanner.next();
        System.out.println("Enter Your Email: ");
        String email= scanner.next();
        System.out.println("Enter Your Password: ");
        String password=scanner.next();

        if(userService.registerUser(name,email,password)){
            System.out.println("Registration Successfully");
        }
        else{
            System.out.println("Registration failed");
        }
    }

    private static void loginUser(){
        System.out.println("Enter Your Email: ");
        String email= scanner.next();
        System.out.println("Enter Your password: ");
        String password= scanner.next();
        loggedInUser=userService.loginUser(email,password);

        if(loggedInUser!=null){
            System.out.println("Login Successfully! Welcome"+loggedInUser.getName());
            if(loggedInUser.getRole().equals("ADMIN")){
                adminMenu();
            }
            else{
                userMenu();
            }
        }
        else{
            System.out.println("Invalid Email or Password");
        }
    }

    private static void adminMenu(){
        System.out.println("---Admin User---");
        System.out.println("1. Add Book");
        System.out.println("2. View Books ");
        System.out.println("3. LogOut");
        System.out.println("Enter Your Choice");
        int choice= scanner.nextInt();

        switch (choice){
            case  1:
                System.out.println("Enter Book Name: ");
                String name= scanner.next();
                System.out.println("Enter Book Author: ");
                String author= scanner.next();
                System.out.println("Enter Language: ");
                String language= scanner.next();
                System.out.println("Enter Price: ");
                double price= scanner.nextDouble();
                System.out.println("Enter Stock: ");
                int stock= scanner.nextInt();

                adminService.addBook(name,author,language,price,stock);
                System.out.println("Book added Successfully");
                adminMenu();
                break;
            case 2:
                Book[] books= adminService.getAllBooks();
                if(books==null){
                    System.out.println("Book not available");
                    adminMenu();
                    break;
                }
                for (Book p : books) {
                    System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice()+" "+p.getAuthor() +" "+p.getLanguage()+" "+" "+p.getPrice()+" "+p.getStock());
                }
                adminMenu();
                break;
            case 3:
                System.out.println("Logout successfully");
                return;
            default:
                System.out.println("Invalid choice Try Again");

        }
    }

    private  static void userMenu(){
        System.out.println("---User Menu---");
        System.out.println("1. View Books");
        System.out.println("2. Place Account");
        System.out.println("3. View Accounts");
        System.out.println("4. Logout");
        System.out.println("Enter Your Choice");
        int choice=scanner.nextInt();

        switch (choice){
            case 1:
                Book[] books= adminService.getAllBooks();
                if(books==null){
                    System.out.println("No Available Book");
                    userMenu();
                    break;
                }
                System.out.println("\n====Available Books====");
                for (Book p : books) {
                    System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice()+" "+p.getAuthor() +" "+p.getLanguage()+" "+" "+p.getPrice()+" "+p.getStock());
                }
                userMenu();
                break;
            case 2:
                placeAccount();
                userMenu();
                break;
            case 3:
                viewAccounts();
                userMenu();
                break;
            case 4:
                System.out.println("Logging Out....");
                return;
            default:
                System.out.println("Invalid choice Try Again");
        }

    }

    private  static void placeAccount(){
        System.out.print("Enter book ID to purchase: ");
        long bookId = scanner.nextLong();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Book book2 = adminService.getBookById(bookId);


        if (book2 == null || book2.getStock() < quantity) {
            System.out.println("Invalid book ID or insufficient stock.");
            return;
        }

        double totalPrice = book2.getPrice() * quantity;

        LocalDate issueDate=LocalDate.now();

        LocalDate dueDate = issueDate.plusDays(5);


        if (accountService.placeAccount(loggedInUser.getId(),bookId,issueDate.toString(),dueDate.toString(),0,IssueStatus.PENDING,quantity)) {
            adminService.updateBook(new Book(bookId,book2.getName(),book2.getAuthor(),book2.getLanguage(),book2.getPrice(), book2.getStock() - quantity));
            System.out.println("Account placed successfully! Total cost: $" + totalPrice);
        } else {
            System.out.println("Account failed. Please try again.");
        }
    }
    private static void viewAccounts(){
        Account[] accounts= accountService.getAllAccounts();
        if(accounts==null){
            System.out.println("No account found ");
            return;
        }

        System.out.println("\n===Your Accounts===");
        for (Account account : accounts) {
            int bookId=account.getBookId();
            Book book=adminService.getBookById(bookId);
            System.out.println("Account ID: " + account.getTxnId() + " | Book ID: " + account.getBookId() +
                    " | Quantity: " + book.getStock() + " | Issue Date: " +account.getIssueDate() + " | Issue Date: "+ account.getDueDate() +
                    " | Total fine: $" + account.getFine() +"| IssueStatus: "+account.getStatus());
        }
    }
}
