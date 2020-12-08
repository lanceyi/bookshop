package com.lance.service;

import com.lance.entity.BookEntity;
import org.springframework.stereotype.Service;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/8 20:41
 */
@Service("BookService")
public interface BookService {
    /**
     * 删除
     * @param bookId
     * @return int
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * 插入
     * @param record
     * @return int
     */
    int insert(BookEntity record);

    /**
     * 选择插入
     * @param record
     * @return int
     */
    int insertSelective(BookEntity record);

    /**
     * 主键查询
     * @param bookId
     * @return BookEntity
     */
    BookEntity selectByPrimaryKey(Integer bookId);

    /**
     * 选择修改
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(BookEntity record);

    /**
     * 主键修改
     * @param record
     * @return int
     */
    int updateByPrimaryKey(BookEntity record);
}
