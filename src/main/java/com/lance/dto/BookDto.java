package com.lance.dto;

import com.lance.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author lance
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookDto extends BookEntity {
    private String bookSortName;
    private String bookUserName;

    public BookDto (Integer bookId, String bookName, String imgUrl, String bookAuthor, String bookPub, BigDecimal bookPrice, BigDecimal bookOriginalPrice,Integer bookSort,String bookDescription,Integer bookUser,Timestamp createTime,Timestamp updateTime) {
        super(bookId,bookName,imgUrl,bookAuthor,bookPub,bookPrice,bookOriginalPrice,bookSort,bookDescription,bookUser,createTime,updateTime);
    }

}
