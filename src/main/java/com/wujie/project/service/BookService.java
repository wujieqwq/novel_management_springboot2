package com.wujie.project.service;

import com.wujie.project.pojo.Book;

import java.util.List;

public interface BookService {
    int addOrUpdateBook(Book book);

    int deleteBook(String bid);

    int updateBook(Book book);

    List<Book> selectBookByUid(String uid);

    Book selectBookByBid(String bid);

    String selectBidByBname(String bname);
}
