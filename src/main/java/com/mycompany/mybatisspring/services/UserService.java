/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.services;

import com.mycompany.mybatisspring.mappers.UserMapper;
import com.mycompany.mybatisspring.entities.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service("userService")
public class UserService {
    @Resource(name = "userMapperAnnotation")
    private UserMapper  userMapper ;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

     
    public List<User> findAll(){
        return userMapper.findAll();
    }
}
