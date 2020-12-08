package com.lance.service;

import com.lance.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Service("UserService")
public interface UserService {
    /**
     * 查询全部数据
     *
     * @return List<UserDto>
     */
    List<UserEntity> findAll ();

    /**
     * 根据Id查询数据
     * @param userId
     * @return UserDto
     */
    UserEntity findById (Integer userId);

    /**
     * 插入数据
     *
     * @param userEntity
     */
    void insert (UserEntity userEntity);

    /**
     * 更新数据
     *
     * @param userEntity
     */
    void update (UserEntity userEntity);

    /**
     * 删除数据
     *
     * @param userId
     */
    void delete (Integer userId);

    /**
     * 登录
     * @param userName
     * @param userPassword
     */
    Map<String, Object> login(String userName, String userPassword);
}
