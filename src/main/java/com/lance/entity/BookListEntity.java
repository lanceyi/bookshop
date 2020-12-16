package com.lance.entity;

import java.sql.Timestamp;
import lombok.Data;

/**
 * @author  lance
 * @date  2020/12/16 15:18
 * @version 1.0
 */
@Data
public class BookListEntity {
    private Integer listId;

    private Integer userId;

    private Integer bookId;

    private String imgUrl;

    private Timestamp createTime;

    private Timestamp updateTime;

    public BookListEntity (Integer listId, String userId, String bookId, String imgUrl, Timestamp createTime, Timestamp updateTime) {
        this.listId = listId;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BookListEntity (Integer userId, int bookId, String imgUrl) {
        this.userId =userId;
        this.bookId =bookId;
        this.imgUrl =imgUrl;
    }
}