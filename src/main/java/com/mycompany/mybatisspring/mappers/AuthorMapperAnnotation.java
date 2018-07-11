package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import java.util.List;
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
@Service("authorMapperAnnotation")
public interface AuthorMapperAnnotation extends AuthorMapper{
   @Results(
           value={
               @Result(property = "id",column = "id"),
               @Result(property = "realName",column = "real_name"),
               @Result(property = "idCard",column = "idCard"),
           }
   )
    @Select("select * from authors")
    @Override
    public List<Author> findAll();
      
}
