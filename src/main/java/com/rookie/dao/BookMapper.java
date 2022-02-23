package com.rookie.dao;

import com.rookie.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
//    增加一本书
    int addBook(Books books);

//    删除一本书
    int deleteBookById(@Param("bookID") int bookID);

//    更新一本书
    int updateBook( Books books);

//    查询一本书
    Books queryBookById(@Param("bookID") int bookID);

//    查询全部的书
    List<Books> queryAllBook();

//    按照书名模糊查找
    List<Books> lookBooks(@Param("bookName") String bookName);
}
