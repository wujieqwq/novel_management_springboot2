package com.wujie.project.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.IdUtil;
import com.wujie.project.pojo.Book;
import com.wujie.project.service.BookService;
import com.wujie.project.utils.ResultInfo;
import com.wujie.project.utils.vo.NewBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    /*
    查询book->review
    查询book
    创建book
    修改book
    删除book
     */
    @Autowired
    private BookService bookService;

    @RequestMapping("/addOrUpdateBook")
    public ResultInfo insertBook(MultipartHttpServletRequest mrequest, HttpServletRequest request) throws IOException {
        Book book = new Book();
        book.setBookDate(DateUtil.date());
        String uid = (String) request.getAttribute("uid");
        String bookStatus = (String) request.getAttribute("bookStatus");
        String bname = mrequest.getParameter("bname");
        String introduction = mrequest.getParameter("introduction");
        MultipartFile picture = mrequest.getFile("picture");
        String _bid = mrequest.getParameter("bid");
        String changeP = mrequest.getParameter("changeP");
        book.setBid(Integer.valueOf(_bid));
        book.setBname(bname);
        book.setUid(Integer.valueOf(uid));
        book.setIntroduction(introduction);
        book.setBookStatus(bookStatus);
        if ("1".equals(changeP)||changeP==null){
            if (picture!=null){
                String simpleUUID = IdUtil.simpleUUID();
                String basePath = ResourceUtils.getURL("classpath:img/").getPath();
                String originalFilename = picture.getOriginalFilename();
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                String fileName = simpleUUID+suffix;
                book.setPicture("/img/"+fileName);
                File file = new File(basePath, fileName);
                picture.transferTo(file);
            }
            bookService.addOrUpdateBook(book);
        }
        return new ResultInfo(200,"创建成功");
    }

    @RequestMapping("/deleteBook")
    public ResultInfo deleteBook(Integer bid){
        bookService.deleteBook(bid);
        return new ResultInfo(200,"创建成功");
    }

    @RequestMapping("/selectBook")
    public ResultInfo selectBookByUid(HttpServletRequest request){
        Integer uid = (Integer) request.getAttribute("uid");
        List<Book> res = bookService.selectBookByUid(uid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/updateBook")
    public ResultInfo updateBook(NewBook newBook,HttpServletRequest request) throws IOException {
        Book book = new Book();
        book.setBid(newBook.getBid());
        book.setBname(newBook.getBname());
        book.setIntroduction(newBook.getIntroduction());
        book.setUid((Integer) request.getAttribute("uid"));
        book.setBookStatus(newBook.getBookStatus());
        book.setBookDate(DateUtil.date());
        MultipartFile picture = newBook.getPicture();
        if (!picture.isEmpty()){
            String simpleUUID = IdUtil.simpleUUID();
            String basePath = ResourceUtils.getURL("classpath").getPath()+"img/";
            String originalFilename = picture.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = simpleUUID+suffix;
            book.setPicture("/img/"+fileName);
            File file = new File(basePath, fileName);
            picture.transferTo(file);
        }
        bookService.updateBook(book);
        return new ResultInfo(200,"创建成功");
    }

    @RequestMapping("/selectBookByBid")
    public ResultInfo selectBookByUid(Integer bid){
        Book res = bookService.selectBookByBid(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/bnameIsExist")
    public ResultInfo selectBidByBname(String bname){
        Integer uid = bookService.selectBidByBname(bname);
        if (uid!=null) {
            return new ResultInfo(4000, "书名已存在");
        }
        return new ResultInfo(200, "书名可用");
    }

}
