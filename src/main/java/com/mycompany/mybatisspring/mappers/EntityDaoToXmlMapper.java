/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.mybatisspring.mappers.EntityMapper;

/**
 *
 * @author root
 */
@Service("entityDaoToXmlMapper")
public class EntityDaoToXmlMapper implements EntityMapper{
 
    private SqlSession  session ;

    public SqlSession getSession() {
        return session;
    }
    @Autowired
    public void setSession(SqlSession session) {
        this.session = session;
    }
     
  

    @Override
    public List<Author> findAllAuthors() {
    return session.selectList("sqlM.findAllAuthors");    
    }

    @Override
    public User findUserById(Long id) {
        return session.selectOne("sqlM.findUserById",id);
    }
}