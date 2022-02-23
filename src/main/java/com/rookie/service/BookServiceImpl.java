package com.rookie.service;

import com.rookie.dao.BookMapper;
import com.rookie.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

//    service调dao层：组合Dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int bookID) {
        return bookMapper.deleteBookById(bookID);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int bookID) {
        return bookMapper.queryBookById(bookID);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Books> lookBooks(String bookName) {

        bookName = "%"+bookName+"%";
        System.out.println("lookBooks+service=>"+bookName);
        return bookMapper.lookBooks(bookName);
    }
}
