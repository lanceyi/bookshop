package com.lance.service.impl;

import com.lance.dto.BookDto;
import com.lance.entity.BookEntity;
import com.lance.mapper.BookMapper;
import com.lance.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/8 20:53
 */
@Service("BookServiceImpl")
@Log4j2
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey (Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insert (BookEntity record) {
        return bookMapper.insert(record);
    }


    @Override
    public List<BookDto> selectAll () {
        return bookMapper.selectAll();
    }

    @Override
    public List<BookDto> selectAllByPrimaryKey (Integer userId) {
        return bookMapper.selectAllByPrimaryKey(userId);
    }

    @Override
    public BookEntity selectByPrimaryKey (Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective (BookEntity record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<BookDto> findByConcat (String concat) {
        return bookMapper.findByConcat(concat);
    }

}
