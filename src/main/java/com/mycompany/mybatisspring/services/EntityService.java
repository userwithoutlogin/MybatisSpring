/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.services;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.mybatisspring.mappers.EntityMapper;

/**
 *
 * @author root
 */
@Service("entityService")
public class EntityService {
//    @Resource(name = "entityMapperAnnotation")
    @Resource(name = "entityDaoToXmlMapper")
    private EntityMapper  entityMapper ;

    public EntityMapper getEntityMapper() {
        return entityMapper;
    }

    public void setEntityMapper(EntityMapper userMapper) {
        this.entityMapper = userMapper;
    }

     
    public List<Author> findAllAuthors(){
        return entityMapper.findAllAuthors();
    }
    public Author findAuthorById(Long id){
        return entityMapper.findAuthorById(id);
    }
    
    public List<User> findAllUsers(){
        return entityMapper.findAllUsers();
    }
    public User findUserById(Long id){
        return entityMapper.findUserById(id);
    }
    
    public List<Visitor> findAllVisitors(){
        return entityMapper.findAllVisitors();
    }
    public Visitor findVisitorById(Long id){
        return entityMapper.findVisitorById(id);
    }
     
    public void isertAuthor(Author author){
        entityMapper.insertAuthor(author);
    }
//    public void isertAuthors(List<Author> authors){
//        entityMapper.insertAuthors(authors);
//    }
    public void insertUser(User user){
        entityMapper.insertUser(user);
    }
//     public void insertUsers(List<User> users){
//        entityMapper.insertUsers(users);
//    }
    public void insertVisitor(Visitor visitor){
        entityMapper.insertVisitor(visitor);
    }
}
