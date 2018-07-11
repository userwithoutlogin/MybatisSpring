/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.User;
import java.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service("userMapperAnnotation")
public interface UserMapperAnnotation extends UserMapper{
    @Results(
        value = {
            @Result(property = "id",column = "id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "password",column = "password"),
        }
    )
    @Select("select * from users")
    @Override
    List<User> findAll();
}
