package com.lance.service.impl;

import com.lance.entity.BookSortEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lance.mapper.BookSortMapper;
import com.lance.service.BookSortService;

import java.util.List;

/**
 * @author  lance
 * @date  2020/12/8 21:27
 * @version 1.0
 */
@Service
public class BookSortServiceImpl implements BookSortService{

    @Resource
    private BookSortMapper bookSortMapper;

    @Override
    public int deleteByPrimaryKey(Integer sortId) {
        return bookSortMapper.deleteByPrimaryKey(sortId);
    }

    @Override
    public int insert(BookSortEntity record) {
        return bookSortMapper.insert(record);
    }

    @Override
    public List<BookSortEntity> selectAll () {
        return bookSortMapper.selectAll();
    }

    @Override
    public BookSortEntity selectByPrimaryKey(Integer sortId) {
        return bookSortMapper.selectByPrimaryKey(sortId);
    }

    @Override
    public int updateByPrimaryKeySelective(BookSortEntity record) {
        return bookSortMapper.updateByPrimaryKeySelective(record);
    }


}
