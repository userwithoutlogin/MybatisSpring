/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.dynamicsql;

import com.mycompany.mybatisspring.entities.Author;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author root
 */
public class AuthorDynamicSql {
    
    public String insert( ){
        return new SQL(){{
            INSERT_INTO("authors");
            
            VALUES("real_name , id_card, user_id", "#{realName},#{idCard},#{user.id}");
        }}.toString();
    }
    public String update(Author author){
        return new SQL(){{
            UPDATE("authors");
           if(author.getRealName()!=null) SET("real_name=#{realName}");
           if(author.getIdCard()!=null)   SET("id_card=#{idCard}");
           if(author.getUser()!=null)     SET("user_id=#{user.id}");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String delete(){
       return  new SQL(){
            {
                DELETE_FROM("authors");
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
