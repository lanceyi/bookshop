package com.lance.mapper;

import com.lance.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author  lance
 * @date  2020/12/7 21:12
 * @version 1.0
 */
@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookEntity record);

    int insertSelective(BookEntity record);

    BookEntity selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookEntity record);

    int updateByPrimaryKey(BookEntity record);
}