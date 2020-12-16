package com.lance.dto;

import com.lance.entity.BookListEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * @author lance
 * @version 1.0
 * @date 2020/12/16 15:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookListDto extends BookListEntity {
    private String bookName;
    private String bookUserName;

    public BookListDto (Integer listId, String userId, String bookId, String imgUrl, Timestamp createTime, Timestamp updateTime) {
        super(listId, userId, bookId, imgUrl, createTime, updateTime);
    }
}
