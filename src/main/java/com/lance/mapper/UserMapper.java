package com.lance.mapper;

import com.lance.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author  lance
 * @date  2020/12/7 20:33
 * @version 1.0
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    List<UserEntity> selectAll ();
    UserEntity selectByName(String userName);
    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}