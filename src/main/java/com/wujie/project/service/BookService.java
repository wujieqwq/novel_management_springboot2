package com.wujie.project.service;

import com.wujie.project.pojo.Book;

import java.util.List;

public interface BookService {
    int addOrUpdateBook(Book book);

    int deleteBook(Integer bid);

    int updateBook(Book book);

    List<Book> selectBookByUid(Integer uid);

    Book selectBookByBid(Integer bid);

    Integer selectBidByBname(String bname);

    Integer selectChapterNumber(Integer bid);
}
