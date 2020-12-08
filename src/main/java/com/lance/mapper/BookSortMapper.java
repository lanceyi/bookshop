package com.lance.mapper;

import com.lance.entity.BookSortEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/8 21:27
 */
@Mapper
public interface BookSortMapper {
    /**
     * 删除
     * @param sortId
     * @return deleteCount
     */
    int deleteByPrimaryKey (Integer sortId);

    /**
     * 插入
     * @param record
     * @return insert count
     */
    int insert (BookSortEntity record);

    /**
     * 查询所有
     * @return List<UserEntity>
     */
    List<BookSortEntity> selectAll ();

    /**
     * 主键查询
     * @param sortId
     * @return BookSort
     */
    BookSortEntity selectByPrimaryKey (Integer sortId);

    /**
     * 选择修改
     * @param record
     * @return update count
     */
    int updateByPrimaryKeySelective (BookSortEntity record);


}