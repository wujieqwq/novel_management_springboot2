package com.wujie.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wujie.project.mapper.BookMapper;
import com.wujie.project.pojo.Book;
import com.wujie.project.service.BookService;
import com.wujie.project.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ChapterService chapterService;
    @Override
    public int addOrUpdateBook(Book book) {
        if (book.getBid()!=null){
            return bookMapper.updateById(book);
        }
        return bookMapper.insert(book);
    }

    @Override
    public int deleteBook(String bid) {
        return bookMapper.deleteById(bid);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    public List<Book> selectBookByUid(String uid) {
        return bookMapper.selectByUid(uid);
    }

    @Override
    public Book selectBookByBid(String bid) {
        return bookMapper.selectByBid(bid);
    }

    @Override
    public String selectBidByBname(String bname) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("bname",bname);
        return bookMapper.selectOne(wrapper).getBid();
    }
}
