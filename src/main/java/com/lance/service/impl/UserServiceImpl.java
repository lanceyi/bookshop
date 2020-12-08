package com.lance.service.impl;

import com.lance.entity.UserEntity;
import com.lance.mapper.UserMapper;
import com.lance.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lance
 */
@Service("UserServiceImpl")
@Log4j2
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private Map<String, Object> resultMap;
    public  static String loginUser=null;

    @Override
    public List<UserEntity> findAll () {
        return userMapper.selectAll();
    }

    @Override
    public UserEntity findById (Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void insert (UserEntity userEntity) {
        userMapper.insert(userEntity);
    }

    @Override
    public void update (UserEntity userEntity) {
        userMapper.updateByPrimaryKeySelective(userEntity);
    }

    @Override
    public void delete (Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Map<String, Object> login (String userName, String userPassword) {
        UserEntity userEntity = userMapper.selectByName(userName);
        loginUser =userEntity.getUserName();
        if(userEntity!=null){
            if(userEntity.getUserPassword().equals(userPassword)){
                resultMap.put("ok", true);
                resultMap.put("loginUser", loginUser);
                resultMap.put("userEntity",userEntity);
            }else{
                resultMap.put("ok", false);
                resultMap.put("error", "登录密码错误！");
            }
        }else{
            resultMap.put("ok", false);
            resultMap.put("error", "用户不存在,请先注册用户！");
        }
        return resultMap;
        }
}
