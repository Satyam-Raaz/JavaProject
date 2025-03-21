package com.library.repository;

import com.libray.beans.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BookDAO {
    //private  static Book[] books=new Book[100];
    private static List<Book> books=new ArrayList<>();
    private static int  bookCount=0;

    public boolean addBook(Book book){
        books.add(book);
        return true;
    }

    public Book getBookByname(String name){
        for(int i=0;i< books.size();i++){
            if(books.get(i).getName().equals(name)){
                return books.get(i);
            }
        }
        return  null;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(long bookId){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId()==bookId){
                return books.get(i);
            }
        }
        return null;
    }

    public boolean updateBook(Book updateBook){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId()==updateBook.getId()){
                books.set(i,updateBook);
                return true;
            }
        }
        return false;
    }
}
