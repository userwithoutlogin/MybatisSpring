package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.dynamicsql.AuthorDynamicSql;
import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
 
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
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

    @InsertProvider(type = AuthorDynamicSql.class,method = "insert")
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Override
      void insertAuthor(Author author) ;

//    @Override
//      void insertAuthors(List<Author> authors);
    @Insert("insert into users(user_name,password) values"+
            "(#{userName},#{password})")
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Override
     void insertUser(User user);

//    @Override
//    public default void insertUsers(List<User> users) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
     @Insert("insert into visitors(visitor_ip,visit_date,user_id) values"+
             "(#{visitorIp},#{visitDate},#{user.id})")
     @Options(keyProperty = "id",useGeneratedKeys = true)
     @Override
    void insertVisitor(Visitor visitor);

     @UpdateProvider(type = AuthorDynamicSql.class,method ="update")
     @Override
     void updateAuthor(Author author);
     
     @Update({
       "<script>",
        "update users",
        "<set>",
            "<if test='#{userName!=null}'>user_name=#{userName},</if>",
            "<if test='#{password!=null}'>password=#{password},</if>",
        "</set>", 
        "where id=#{id}",
       "</script>"      
     })
     @Override
     void updateUser(User user) ;

     @Update({
       "<script>",
        "update visitors",
        "<set>",
           " <if test='#{visitorIp!=null}'>visitor_ip=#{visitorIp},</if>",
            "<if test='#{visitDate!=null}'>visit_date=#{visitDate},</if>",
            "<if test='#{user.id!=null}'>user_id=#{user.id},</if>",
        "</set>",  
        "where id=#{id}",
       "</script>"      
     })
     @Override
     void updateVisitor(Visitor visitor) ;

     @Delete("delete from users where id=#{id}")
     @Override
     void deleteUser(User user);

     @DeleteProvider(type = AuthorDynamicSql.class,method = "delete")
     @Override
     void deleteAuthor(Author author);
     
      @Delete("delete from visitors where id=#{id}")
      @Override
      void deleteVisitor(Visitor visitor) ;
     
     
}
