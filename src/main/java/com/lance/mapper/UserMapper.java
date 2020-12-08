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

    /**
     * 删除
     * @param userId
     * @return int
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入
     * @param record
     * @return int
     */
    int insert(UserEntity record);

    /**
     * 查询所有
     * @return List<UserEntity>
     */
    List<UserEntity> selectAll ();

    /**
     * 根据用户名查询
     * @param userName
     * @return UserEntity
     */
    UserEntity selectByName(String userName);

    /**
     * 选择插入
     * @param record
     * @return int
     */
    int insertSelective(UserEntity record);

    /**
     * 主键查询
     * @param userId
     * @return UserEntity
     */
    UserEntity selectByPrimaryKey(Integer userId);

    /**
     * 选择修改
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     * 主键修改
     * @param record
     * @return int
     */
    int updateByPrimaryKey(UserEntity record);
}