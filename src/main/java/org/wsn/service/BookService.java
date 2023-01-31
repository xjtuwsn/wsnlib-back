package org.wsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wsn.entity.Book;
import org.wsn.entity.LendInfo;
import org.wsn.mapper.BookMapper;
import org.wsn.utils.TokenUtil;

import java.util.List;
import java.util.UUID;

/**
 * @project:wsn-lib
 * @file:BookService
 * @author:wsn
 * @create:2023/1/30-14:48
 */
@Service
public class BookService {
    @Autowired
    public BookMapper bookMapper;
    public List<Book> getAllBooks() {
        return bookMapper.getAllBook();
    }
    public int addBook(String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                 String pubDate, String className, int letNum, String img) {
        bookMapper.addBook(name, author, publish, ISBN, introduction, lang, price, pubDate, className, letNum, img);
        return 200;
    }
    public int changeBook(int id, String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                         String pubDate, String className, int letNum, String img) {
        bookMapper.changeBook(id, name, author, publish, ISBN, introduction, lang, price, pubDate, className, letNum, img);
        return 200;
    }
    public int addLend(int bookId, String token, String backDate) {
        if (!subLeftNum(bookId)) return 400;
        String serNum = UUID.randomUUID().toString();
        bookMapper.addLend(serNum, bookId, TokenUtil.getUid(token), backDate);
        return 200;
    }
    public int backLend(String serNum) {
        bookMapper.backLend(serNum);
        return 200;
    }
    public List<LendInfo> getLendList(String token) {
        return bookMapper.getLendList(TokenUtil.getUid(token));
    }
    private boolean subLeftNum(int id) {
        Integer leftNum = bookMapper.getLeftNum(id);
        if (leftNum > 0) {
            bookMapper.subLeftNum(id);
            return true;
        }
        return false;
    }
    private void addLeftNum(int id) {
        bookMapper.addLeftNum(id);
    }
}
