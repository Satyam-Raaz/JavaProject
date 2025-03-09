package com.library.repository;

import com.libray.beans.Book;

import java.util.Arrays;
import java.util.Stack;

public class BookDAO {
    private  static Book[] books=new Book[100];
    private static int  bookCount=0;

    public boolean addBook(Book book){
        if(bookCount< books.length){
            books[bookCount++]=book;
            return true;
        }
        return  false;
    }

    public Book[] getAllBooks(){
        Book[] res=new Book[bookCount];
        System.arraycopy(books,0,res,0,bookCount);
        return res;
    }

    public Book getBookById(long bookId){
        for(int i=0;i<bookCount;i++){
            if(books[i].getId()==bookId){
                return books[i];
            }
        }
        return null;
    }

    public boolean updateBook(Book updateBook){
        for(int i=0;i<books.length;i++){
            if(books[i].getId()==updateBook.getId()){
                books[i]=updateBook;
                return true;
            }
        }
        return false;
    }
}
