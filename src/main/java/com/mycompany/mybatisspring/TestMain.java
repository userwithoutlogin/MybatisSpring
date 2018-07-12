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
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
        
        User u = new User();
        u.setUserName("User");
        u.setPassword("qw");
        es.insertUser(u);
         
        
        
        Author a = new Author();
        a.setIdCard("qw2");
        a.setRealName("Dan");
        a.setUser(u);
        es.isertAuthor(a);
       
        Visitor v = new Visitor();
        v.setVisitorIp("234.123.111.21");
        v.setVisitDate(new Date());
        v.setUser(u);
        es.insertVisitor(v);
        
        List<Visitor> visitorsU = new ArrayList();
        visitorsU.add(v);
        u.setVisitors(visitorsU);
        
        List<Author> authors = es.findAllAuthors(); 
        Author author = es.findAuthorById(1L);
        
        List<User> users = es.findAllUsers();
        User user = es.findUserById(1L);
        
        List<Visitor> visitors = es.findAllVisitors();
        Visitor visitor = es.findVisitorById(1L);
         
    }
     public static List<User> createUsers(int count){
         List<User> users = new ArrayList();
         if(count>0)
         for(int i=0;i<count;i++){
             User u = new User();
             u.setUserName("User"+i);
             u.setPassword("qw"+i);
             users.add(u);
         }
         return users;
     }
      public static List<Author> createAuthors( List<User> users){
         List<Author> authors = new ArrayList();
         if(!users.isEmpty())
         for(int i=0;i<users.size();i++){
             Author a = new Author();
             a.setRealName("real"+i);
             a.setIdCard("w"+i);
             a.setUser(users.get(i));
             authors.add(a);
         }
         return authors;
     }
}
