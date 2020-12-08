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
    public static String loginUser=null;
    public static String admin="admin";


    @Override
    public int deleteByPrimaryKey (Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert (UserEntity record) {
        return userMapper.insert(record);
    }

    @Override
    public List<UserEntity> selectAll () {
        return userMapper.selectAll();
    }

    @Override
    public UserEntity selectByName (String userName) {
        return userMapper.selectByName(userName);
    }


    @Override
    public UserEntity selectByPrimaryKey (Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective (UserEntity record) {
        return userMapper.updateByPrimaryKeySelective(record);
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
                if (admin.equals(userEntity.getUserType())){
                    resultMap.put("admin",true);
                }else {
                    resultMap.put("admin",false);
                }
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
