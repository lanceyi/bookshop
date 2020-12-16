package com.lance.service.impl;

import com.lance.dto.BookListDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lance.mapper.BookListMapper;
import com.lance.entity.BookListEntity;
import com.lance.service.BookListService;

import java.util.List;

/**
 * @author  lance
 * @date  2020/12/16 15:18
 * @version 1.0
 */
@Service("BookListServiceImpl")
@Log4j2
public class BookListServiceImpl implements BookListService{

    @Resource
    private BookListMapper bookListMapper;


    @Override
    public int deleteByPrimaryKey (Integer listId) {
        return bookListMapper.deleteByPrimaryKey(listId);
    }

    @Override
    public int insert (BookListEntity record) {
        return bookListMapper.insert(record);
    }

    @Override
    public List<BookListDto> selectAll () {
        return bookListMapper.selectAll();
    }

    @Override
    public List<BookListDto> selectAllByPrimaryKey (Integer userId) {
        return bookListMapper.selectAllByPrimaryKey(userId);
    }

    @Override
    public BookListEntity selectByPrimaryKey (Integer listId) {
        return bookListMapper.selectByPrimaryKey(listId);
    }

    @Override
    public int updateByPrimaryKeySelective (BookListEntity record) {
        return bookListMapper.updateByPrimaryKeySelective(record);
    }
}
