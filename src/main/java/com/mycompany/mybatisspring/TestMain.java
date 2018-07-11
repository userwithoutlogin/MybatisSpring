/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring;


import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.entities.User;
import com.mycompany.mybatisspring.entities.Visitor;
import com.mycompany.mybatisspring.mappers.EntityDaoToXmlMapper;
 
import com.mycompany.mybatisspring.services.EntityService;
import java.util.List;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author root
 */
public class TestMain {
    //MapperScannerConfigurer
    public static void main(String[] args) {
        Resource cpRes = new ClassPathResource("META-INF.spring/root.xml");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(cpRes);
        ctx.refresh();
        
 
        EntityService es = ctx.getBean("entityService",EntityService.class);
        
        List<Author> authors = es.findAllAuthors(); 
        Author author = es.findAuthorById(1L);
        
        List<User> users = es.findAllUsers();
        User user = es.findUserById(1L);
        
        List<Visitor> visitors = es.findAllVisitors();
        Visitor visitor = es.findVisitorById(1L);
         
        
        
        System.out.println(es.findAuthorById(1L));
        
    }
     
     
}
