package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author root
 */
@Service("entityMapperAnnotation")
public interface EntityMapperAnnotation extends EntityMapper{

     // Mapping over resultMap
   @Results(id="AuthorMap",
           value={
               @Result(property = "id",column = "id"),
               @Result(property = "realName",column = "real_name"),
               @Result(property = "idCard",column = "id_card"),
               @Result(property = "user",column = "user_id",one = @One(select = "findUserById"))
           }
   )
    @Select("select * from authors")
    //@Override
    public List<Author> findAllAuthors_A();
   
 //Mapping over contructor
    @ConstructorArgs(value = {
        @Arg(column = "id", javaType = Long.class),
        @Arg(column="real_name",javaType = String.class),    
        @Arg(column="id_card",javaType = String.class),    
        @Arg(column="user_id",javaType = User.class,select = "findUserById"),    
    })
    @Select("select * from authors")
    @Override
    public List<Author> findAllAuthors();
    
    
   @Results(
    id="UserMap",
    value = {
      @Result(property = "id",column = "id"),           
      @Result(property = "userName",column = "user_name"),           
      @Result(property = "password",column = "password"),           
    }
   )  
            @Select("select * from users where id=#{id}")
   @Override
    User findUserById(@Param("id") Long id);

     
}
