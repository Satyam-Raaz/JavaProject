package repository;

import beans.Order;
import beans.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class OrderRepo {
    private static UserRepo userRepo=new UserRepo();
    List<Order> orders=new ArrayList<>();

    public boolean addOrder(Order order){
        orders.add(order);
        return true;
    }

    public List<Order> getAllOrder(String email){
        User users=userRepo.getUserByEmail(email);
        List<Order> list=new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getEmail()==email){
                list.add(orders.get(i));
            }
        }
        return list;
    }

    public Order getOrderById(long id){
        for(int i=0;i<orders.size();i++){
            if(orders.get(i).getProductId()==id){
                return orders.get(i);
            }
        }
        return null;
    }



}
