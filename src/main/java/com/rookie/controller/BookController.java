package com.rookie.controller;

import com.rookie.pojo.Books;
import com.rookie.service.BookService;
import com.rookie.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
//    controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
//    查看全部书籍，并返回一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }
//    跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
//    添加书籍要求
@RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
//    跳转到修改页面
     @RequestMapping("/toUpdateBook/{bookID}")
 public String toUpdateBook(Model model, @PathVariable int bookID)
     {
         Books books = bookService.queryBookById(bookID);
         model.addAttribute("books",books);
         return "updateBook";
     }
//修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
//    删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBookById(@PathVariable int bookID){
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }
//    按照书名模糊查找
    @RequestMapping("/lookBooks")
    public String lookBooks(@RequestParam("bookName") String bookName,Model model){
        List<Books> books = bookService.lookBooks(bookName);
        model.addAttribute("bookname",bookName);
        model.addAttribute("list",books);
        return "allBook";
    }

}
