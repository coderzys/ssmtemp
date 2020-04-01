package com.coder.service;

import com.coder.pojo.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAllBooks(Integer pageNum, Integer pageSize);

}
