package com.lance.mapper;

import com.lance.entity.BookSortEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author  lance
 * @date  2020/12/7 21:12
 * @version 1.0
 */
@Mapper
public interface BookSortMapper {
    int deleteByPrimaryKey(Integer sortId);

    int insert(BookSortEntity record);

    int insertSelective(BookSortEntity record);

    BookSortEntity selectByPrimaryKey(Integer sortId);

    int updateByPrimaryKeySelective(BookSortEntity record);

    int updateByPrimaryKey(BookSortEntity record);
}