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
}