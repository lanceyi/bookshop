package com.lance.entity;

import java.sql.Timestamp;
import lombok.Data;

/**
 * @author  lance
 * @date  2020/12/7 20:33
 * @version 1.0
 */
@Data
public class UserEntity {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userType;

    private Timestamp createTime;

    private Timestamp updateTime;
}