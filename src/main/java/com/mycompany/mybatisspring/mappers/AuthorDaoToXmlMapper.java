package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service("authorMapperXml")
public class AuthorDaoToXmlMapper implements AuthorMapper{
   SqlSession session;

    public SqlSession getSession() {
        return session;
    }

    @Autowired
    public void setSession(SqlSession session) {
        this.session = session;
    }

    
   
    
    @Override
    public List<Author> findAll() {
        return session.selectList("sqlM.findAuthors");
       }
    
}
