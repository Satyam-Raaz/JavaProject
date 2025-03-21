package service;

import beans.Order;
import repository.OrderRepo;

import java.util.List;

public class OrderService {
    private static OrderRepo orderRepo=new OrderRepo();

    public boolean addOrder(long id,double price,int qty,String email){
        return  orderRepo.addOrder(new Order(id,price,qty,email));
    }

    public List<Order> getAllOrder(String email){

        return orderRepo.getAllOrder(email);
    }

    public Order getOrderById(long id){
        return orderRepo.getOrderById(id);
    }


}
