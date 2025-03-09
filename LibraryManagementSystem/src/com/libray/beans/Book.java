package com.libray.beans;

public class Book {
    private long id;
    private String name;
    private  String author;
    private  String language;
    private  double price;
    private int stock;
    public Book(long id,String name,String author,String language,double price,int stock){
        super();
        this.id=id;
        this.name=name;
        this.author=author;
        this.language=language;
        this.price=price;
        this.stock=stock;
    }
    public Book(){}

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return  name;
    }
    public void  setName(String name){
        this.name=name;
    }

    public String getAuthor(){
        return  author;
    }
    public  void  setAuthor(String author){
        this.author=author;
    }

    public String getLanguage(){
        return  language;
    }
    public void  setLanguage(String language){
        this.language=language;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", language=" + language + ", price="
                + price + ", stock=" + stock + "]";
    }
}
