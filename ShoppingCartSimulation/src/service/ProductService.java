package service;

import beans.Product;
import repository.ProductRepo;

import java.util.List;

public class ProductService {
    private static ProductRepo productRepo=new ProductRepo();

    public boolean addProduct(String productName,String productType,double price,int stock){
        return productRepo.addProduct(new Product(((long)(new Product().hashCode())),productName,productType,price,stock));
    }

    public List<Product> getAllProduct(){
        return productRepo.getAllProduct();
    }

    public Product getProductById(long id){
        return productRepo.getProductById(id);
    }

    public String getProductType(long id){
        return productRepo.getProductType(id);
    }

    public boolean updateStock(long id,int stock){
        return productRepo.updateStock(id,stock);
    }


}
