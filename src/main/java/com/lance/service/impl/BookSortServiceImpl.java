package com.lance.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lance.entity.BookSort;
import com.lance.mapper.BookSortMapper;
import com.lance.service.BookSortService;
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
    public int insert(BookSort record) {
        return bookSortMapper.insert(record);
    }

    @Override
    public int insertSelective(BookSort record) {
        return bookSortMapper.insertSelective(record);
    }

    @Override
    public BookSort selectByPrimaryKey(Integer sortId) {
        return bookSortMapper.selectByPrimaryKey(sortId);
    }

    @Override
    public int updateByPrimaryKeySelective(BookSort record) {
        return bookSortMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BookSort record) {
        return bookSortMapper.updateByPrimaryKey(record);
    }

}
