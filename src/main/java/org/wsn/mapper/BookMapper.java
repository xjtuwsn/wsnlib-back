package org.wsn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wsn.entity.Book;
import org.wsn.entity.LendInfo;

import java.util.List;

/**
 * @project:wsn-lib
 * @file:BookMapper
 * @author:wsn
 * @create:2023/1/30-14:36
 */
@Repository
@Mapper
public interface BookMapper {
    List<Book> getAllBook();
    void addBook(String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                 String pubDate, String className, int letNum, String img);
    void changeBook(int id, String name, String author, String publish, String ISBN, String introduction, String lang, double price,
                    String pubDate, String className, int letNum, String img);
    void subLeftNum(int id);
    Integer getLeftNum(int id);
    void addLeftNum(int id);
    void addLend(String serNum, int bookId, int readerId, String backDate);
    void backLend(String serNum);
    List<LendInfo> getLendList(int readerId);
}
