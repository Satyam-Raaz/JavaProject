package repository;

import beans.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    List<Product> products=new ArrayList<>();

    public boolean addProduct(Product product){
        products.add(product);
        return true;
    }

    public List<Product> getAllProduct(){
        return products;
    }

    public boolean updateStock(long id,int stock){
        Product product=getProductById(id);
        if(product.getStock()>0&&product.getStock()>=stock){
            product.setStock(product.getStock() - stock);
            return true;
        }
        return false;
    }

    public String getProductType(long id){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                return products.get(i).getProductType();
            }
        }
        return null;
    }

    public Product getProductById(long id){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                return products.get(i);
            }
        }
        return null;
    }
}
