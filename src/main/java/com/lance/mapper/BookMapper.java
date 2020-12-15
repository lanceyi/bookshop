package com.lance.mapper;

import com.lance.dto.BookDto;
import com.lance.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author  lance
 * @date  2020/12/7 21:12
 * @version 1.0
 */
@Mapper
public interface BookMapper {

    /**
     * 删除
     * @param bookId
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * 插入
     * @param record
     * @return insert count
     */
    int insert(BookEntity record);


    /**
     * 查询所有
     * @return  List<BookDto>
     */
    List<BookDto> selectAll ();

    /**
     * 查询所有By用户
     * @return  List<BookDto>
     */
    List<BookDto> selectAllByPrimaryKey (Integer userId);

    /**
     * 主键查询
     * @param bookId
     * @return BookEntity
     */
    BookEntity selectByPrimaryKey(Integer bookId);

    /**
     * 选择修改
     * @param record
     * @return update count
     */
    int updateByPrimaryKeySelective(BookEntity record);

    /**
     * 模糊查询
     * @param concat
     * @return
     */
    List<BookDto> findByConcat(String concat);

}