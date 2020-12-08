package com.lance.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;

/**
 * @author  lance
 * @date  2020/12/7 21:12
 * @version 1.0
 */
@Data
public class BookEntity {
    private Integer bookId;

    private String bookName;

    private String imgUrl;

    private String bookAuthor;

    private String bookPub;

    private BigDecimal bookPrice;

    private BigDecimal bookOriginalPrice;

    private Integer bookSort;

    private String bookDescription;

    private Integer bookUser;

    private Timestamp createTime;

    private Timestamp updateTime;

    public BookEntity (Integer bookId, String bookName, String imgUrl, String bookAuthor, String bookPub, BigDecimal bookPrice, BigDecimal bookOriginalPrice, Integer bookSort, String bookDescription, Integer bookUser, Timestamp createTime, Timestamp updateTime) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.imgUrl = imgUrl;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.bookOriginalPrice = bookOriginalPrice;
        this.bookSort = bookSort;
        this.bookDescription = bookDescription;
        this.bookUser = bookUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}