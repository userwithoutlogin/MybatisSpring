/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.services;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.Car;
import com.mycompany.mybatisspring.entities.Truck;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Van;
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
    @Resource(name = "entityMapperAnnotation")
//    @Resource(name = "entityDaoToXmlMapper")
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
    
    
    
    public void updateAuthor(Author author){
        entityMapper.updateAuthor(author);
    }
    public void updateUser(User user){
        entityMapper.updateUser(user);
    }
    public void updateVisitor(Visitor visitor){
        entityMapper.updateVisitor(visitor);
    }
    
    public void deleteUser(User user){
        entityMapper.deleteUser(user);
    }
    public void deleteAuthor(Author author){
        entityMapper.deleteAuthor(author);
    }
    public void deleteVisitor(Visitor visitor){
        entityMapper.deleteVisitor(visitor);
    }
//    ************Vehicle hierarchy*************
    public List<Car> selectAllCars(){
       return  entityMapper.findAllCars();
    }
    
    public List<Van> selectAllVans(){
       return  entityMapper.findAllVans();
    }
    
    public List<Truck> selectAllTrucks(){
       return  entityMapper.findAllTrucks();
    }
    
    
}
