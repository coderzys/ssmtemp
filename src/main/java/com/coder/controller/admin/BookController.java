package com.coder.controller.admin;

import com.coder.pojo.Book;
import com.coder.service.IBookService;
import com.coder.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName BooksController
 * @Description TODO
 * @Author A
 * @Date 2020/2/12 13:42
 * @Version 1.0
 **/
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultUtil getAllBooks(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        List<Book> books = bookService.findAllBooks(pageNum, pageSize);
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return ResultUtil.ok(pageInfo.getList());
    }

}
