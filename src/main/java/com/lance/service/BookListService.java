package com.lance.service;

import com.lance.dto.BookListDto;
import com.lance.entity.BookListEntity;

import java.util.List;

/**
 * @author  lance
 * @date  2020/12/16 15:18
 * @version 1.0
 */
public interface BookListService{

    /**
     * 删除
     * @param listId
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer listId);

    /**
     * 插入
     * @param record
     * @return insert count
     */
    int insert(BookListEntity record);

    /**
     * 查询所有
     * @return  List<BookListDto>
     */
    List<BookListDto> selectAll ();
    /**
     * 查询所有By用户
     * @return  List<BookListDto>
     */
    List<BookListDto> selectAllByPrimaryKey (Integer userId);

    /**
     * 主键查询
     * @param listId
     * @return BookEntity
     */
    BookListEntity selectByPrimaryKey(Integer listId);

    /**
     * 选择修改
     * @param record
     * @return update count
     */
    int updateByPrimaryKeySelective(BookListEntity record);



}
