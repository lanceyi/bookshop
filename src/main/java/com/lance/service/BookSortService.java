package com.lance.service;

import com.lance.entity.BookSort;
import org.springframework.stereotype.Service;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/8 21:20
 */
@Service("BookSortService")
public interface BookSortService {
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
    int insert (BookSort record);

    /**
     * 选择插入
     * @param record
     * @return insert count
     */
    int insertSelective (BookSort record);

    /**
     * 主键查询
     * @param sortId
     * @return BookSort
     */
    BookSort selectByPrimaryKey (Integer sortId);

    /**
     * 选择修改
     * @param record
     * @return update count
     */
    int updateByPrimaryKeySelective (BookSort record);

    /**
     * 主键修改
     * @param record
     * @return update count
     */
    int updateByPrimaryKey (BookSort record);
}

