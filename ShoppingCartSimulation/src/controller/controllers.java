package controller;

import beans.Product;
import repository.UserRepo;
import service.OrderService;
import service.ProductService;
import service.UserService;
import beans.User;
import beans.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class controllers {
    private static OrderService orderService=new OrderService();
    private static UserRepo userRepo=new UserRepo();
    private static UserService userService=new UserService();
    private static ProductService productService =new ProductService();
    private static Scanner scanner=new Scanner(System.in);
    static {
        userService.loadAdmin("admin","admin@email");
    }
    private static User user=null;
    public static void main(String[] args) {
        while (true) {
            System.out.println("=====Digital shopping=====");
            System.out.println("1. Register: ");
            System.out.println("2. Login");
            System.out.println("3. Exit: ");
            System.out.println("Enter Choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exit Successfull");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }


    }
    public static   void register(){
        System.out.println("Enter Username: ");
        String username= scanner.next();
        System.out.println("Enter password: ");
        String email= scanner.next();
        if(userService.addUser(username,email)){
            System.out.println("Registation  successfully");
        }
        else{
            System.out.println("User Already Exit");
        }
    }
    public static void login(){
        System.out.println("Enter Username: ");
        String username= scanner.next();
        System.out.println("Enter email: ");
        String email= scanner.next();
        //User u=userService.getUserByEmail(email);
        user=userService.getUserByEmail(email);
        if(user!=null){
            if(user.getUserType().equals("ADMIN")){
                /**System.out.println("1. Add Product");
                System.out.println("2. View User: ");
                System.out.println("3. View Product: ");
                System.out.println("4. Log Out");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter Product Name: ");
                        String name= scanner.next();
                        System.out.println("Enter Product Type: ");
                        String type= scanner.next();
                        System.out.println("Enter Price: ");
                        System.out.println("Enter Quantity: ");
                        int qty= scanner.nextInt();
                        double price= scanner.nextInt();
                        if(productService.addProduct(name,type,price,qty)){
                            System.out.println("Add successfull");
                        }
                        else{
                            System.out.println("Not add");
                        }
                        break;
                    case 2:
                        List<User> users=new ArrayList<>();
                        if(users!=null) {
                            for (int i = 0; i < users.size(); i++) {
                                System.out.println(users.get(i));
                            }
                        }
                        else{
                            System.out.println("No user ");
                        }
                        break;
                    case 3:
                        System.out.println("===Available Products:===");
                        List<Product> products=productService.getAllProduct();
                        if(products!=null){
                            for(int i=0;i<products.size();i++){
                                System.out.println(products.get(i));
                            }
                        }
                        else {
                            System.out.println("Products Are Not Available");
                        }
                        break;
                    case 4:
                        System.out.println("Log out sucessfully");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }**/
                admin();
            }
            else{
                user();

            }
        }
        else{
            System.out.println("Invalid Username or password");
        }
    }

    public static void admin(){
        System.out.println("1. Add Product");
        System.out.println("2. View User: ");
        System.out.println("3. View Product: ");
        System.out.println("4. Log Out");
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter Product Name: ");
                String name = scanner.next();
                System.out.println("Enter Product Type: ");
                String type = scanner.next();
                System.out.println("Enter Price: ");
                double price= scanner.nextDouble();
                System.out.println("Enter Quantity: ");
                int qty = scanner.nextInt();
                if (productService.addProduct(name, type, price, qty)) {
                    System.out.println("Add successfull");
                } else {
                    System.out.println("Not add");
                }
                admin();
                break;
            case 2:
                List<User> users = userService.getAllUser();
                if (users != null) {
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println(users.get(i));
                    }
                } else {
                    System.out.println("No user ");
                }
                admin();
                break;
            case 3:
                System.out.println("===Available Products:===");
                List<Product> products = productService.getAllProduct();
                if (products != null) {
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i));
                    }
                } else {
                    System.out.println("Products Are Not Available");
                }
                admin();
                break;
            case 4:
                System.out.println("Log out sucessfully");
                return;
            default:
                System.out.println("Invalid Choice");
        }
    }
    public static void user(){
            System.out.println("1. View Product");
            System.out.println("2. Buy Product: ");
            System.out.println("3. View Your Order: ");
            System.out.println("4. Log Out");
            int choice= scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("===Available Products:===");
                    List<Product> products = productService.getAllProduct();
                    if (products.size() > 0) {
                        for (int i = 0; i < products.size(); i++) {
                            System.out.println(products.get(i));
                        }
                    } else {
                        System.out.println("Products Are Not Available");
                    }
                    user();
                    break;
                case 2:
                    System.out.println("===Available Products==");
                    List<Product> productss = productService.getAllProduct();
                    if (productss.size() > 0) {
                        for (int i = 0; i < productss.size(); i++) {
                            System.out.println(productss.get(i));
                        }
                    } else {
                        System.out.println("Products Are Not Available");
                    }
                    System.out.println("Enter Product Id: ");
                    long id = scanner.nextInt();
                    System.out.println("Enter Quantity: ");
                    int qt = scanner.nextInt();
                    Product product = productService.getProductById(id);
                    if (productService.updateStock(id, qt)) {
                        orderService.addOrder(id, product.getPrice(), qt, user.getEmail());
                        System.out.println("Product Buy Successfull");
                    } else {
                        System.out.println("Out of Stock");
                    }
                    user();
                    break;
                case 3:
                    System.out.println("===Your Order===");
                    List<Order> orders = orderService.getAllOrder(user.getEmail());
                    if (orders.size() > 0) {
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println(orders.get(i));
                        }
                    } else {
                        System.out.println("Not Bought Anything");
                    }
                    user();
                    break;
                case 4:
                    System.out.println("Log Out Successfully");
                    return;
                default:
                    System.out.println("Invalid Choice ");

            }
    }
}
