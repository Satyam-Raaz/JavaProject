package com.library.service;

import com.library.repository.AccountDAO;
import com.library.repository.BookDAO;
import com.library.repository.UserDAO;
import com.libray.beans.Book;

public class BookService {
    private BookDAO bookDAO=new BookDAO();
    private AccountDAO accountDAO=new AccountDAO();
    private UserDAO userDAO=new UserDAO();

    public boolean addBook(String name,String author,String language,double price,int stock){
        return bookDAO.addBook(new Book(((long)(new Book().hashCode())),  name, author, language,price ,stock));
    }

    public Book[] getAllBooks(){
        return bookDAO.getAllBooks();
    }

    public Book getBookById(long id){
        return bookDAO.getBookById(id);
    }

    public  boolean updateBook(Book updateBook){
        return bookDAO.updateBook(updateBook);
    }
}
