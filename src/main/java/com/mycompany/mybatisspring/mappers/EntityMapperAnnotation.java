package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
 
import org.apache.ibatis.annotations.ResultMap;
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

    @ResultMap(value = "AuthorMap")
    @Select("select * from authors where id=#{id}")
    @Override
    public Author findAuthorById(Long id);
    
    
    
   @Results(
    id="UserMap",
    value = {
      @Result(property = "id",column = "id"),           
      @Result(property = "userName",column = "user_name"),           
      @Result(property = "password",column = "password"), 
      @Result(property="visitors" , column="id", javaType = ArrayList.class,
          many=@Many(select = "findVisitorByUserId"))
    }
   )  
            @Select("select * from users where id=#{id}")
    @Override
    User findUserById(@Param("id") Long id);

    
    
    @ResultMap(value = "UserMap")
    @Select("select * from users")
    @Override
    public List<User> findAllUsers();

    
    @Results(
            id="VisitorMap",
      value = {
          @Result(property = "id" ,column = "id"),
          @Result(property = "visitorIp" ,column = "visitor_ip"),
          @Result(property = "visitDate" ,column = "visit_date"),
          @Result(property = "user" ,column = "user_id",one=@One(select = "findUserById")),
      }
    )
    @Select("select * from visitors")
    @Override
    public List<Visitor> findAllVisitors();

    @ResultMap(value = "VisitorMap")
    @Select("select * from visitors where id=#{id}")
    @Override
    public Visitor findVisitorById(Long id);

    @ResultMap("VisitorMap")
    @Select("select * from visitors where user_id=#{id}")
    public Visitor findVisitorByUserId(@Param("id")Long id);
    
     
}
