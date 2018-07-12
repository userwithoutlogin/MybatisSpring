/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
import java.util.List;

/**
 *
 * @author root
 */
public interface EntityMapper {
    List<Author> findAllAuthors();
    Author findAuthorById(Long id);
    User findUserById(Long id);
    List<User> findAllUsers();
    Visitor findVisitorById(Long id);
    List<Visitor> findAllVisitors();
    
    void insertAuthor(Author author);
//    void insertAuthors(List<Author> authors);
    void insertUser(User user);
//    void insertUsers(List<User> users);
    void insertVisitor(Visitor visitor);
    
    
}
