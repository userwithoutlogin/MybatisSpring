/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
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
    public Author findAuthorById(Long id) {
        return session.selectOne("sqlM.findAuthorById", id);
    }
    @Override
    public User findUserById(Long id) {
        return session.selectOne("sqlM.findUserById",id);
    }

    @Override
    public List<User> findAllUsers() {
      return session.selectList("sqlM.findAllUsers");
    }

    @Override
    public Visitor findVisitorById(Long id) {
      return session.selectOne("sqlM.findVisitorById",id);
    }

    @Override
    public List<Visitor> findAllVisitors() {
      return session.selectList("sqlM.findAllVisitors");
    }

    @Override
    public void insertAuthor(Author author) {
       session.insert("sqlM.insertAuthor",author);
    }

//    @Override
//    public void insertAuthors(List<Author> authors) {
//      session.insert("sqlM.insertAuthors",authors);
//    }

    @Override
    public void insertUser(User user) {
        session.insert("sqlM.insertUser",user);
    }

//    @Override
//    public void insertUsers(List<User> users) {
//      session.insert("sqlM.insertUsers",users);
//    }

    @Override
    public void insertVisitor(Visitor visitor) {
      session.insert("sqlM.insertVisitor",visitor);
    }

    
    
     
}
