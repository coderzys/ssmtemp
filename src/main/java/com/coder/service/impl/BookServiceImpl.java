package com.coder.service.impl;

import com.coder.mapper.BookMapper;
import com.coder.pojo.Book;
import com.coder.pojo.BookExample;
import com.coder.service.IBookService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BooksServiceImpl
 * @Description TODO
 * @Author A
 * @Date 2020/2/12 13:48
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks(Integer pageNum, Integer pageSize) {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        // 对数据进行分页
        PageHelper.startPage(pageNum, pageSize);
        return bookMapper.selectByExample(example);
    }
}
