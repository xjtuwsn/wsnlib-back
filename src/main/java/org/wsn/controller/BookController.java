package org.wsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wsn.entity.Book;
import org.wsn.entity.LendInfo;
import org.wsn.service.BookService;

import java.util.List;

/**
 * @project:wsn-lib
 * @file:BookController
 * @author:wsn
 * @create:2023/1/30-14:51
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookService bookService;
    @RequestMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @RequestMapping("/add")
    public int addBook(String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                       String pubDate, String className, int letNum, String img) {
        return bookService.addBook(name, author, publish, ISBN, introduction, lang, price, pubDate, className, letNum, img);
    }
    @RequestMapping("/change")
    public int changeBook(int id, String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                          String pubDate, String className, int letNum, String img) {
        return bookService.changeBook(id, name, author, publish, ISBN, introduction, lang, price, pubDate, className, letNum, img);
    }
    @RequestMapping("/mylend")
    public List<LendInfo> getLendList(@RequestHeader("token") String token) {
        return bookService.getLendList(token);
    }
    @RequestMapping("/addlend")
    public int addLend(int bookId, @RequestHeader("token") String token, String backDate) {
        return bookService.addLend(bookId, token, backDate);
    }
}
