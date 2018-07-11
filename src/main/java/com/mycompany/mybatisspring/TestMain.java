/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring;

import com.mycompany.mybatisspring.mappers.UserMapperAnnotation;
import com.mycompany.mybatisspring.mappers.UserDaoToXmlMapper;
import com.mycompany.mybatisspring.services.AuthorService;
import com.mycompany.mybatisspring.services.UserService;
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
        
//        UserMapperXml um = ctx.getBean("userMapper",UserMapperXml.class);
        UserService um = ctx.getBean("userService",UserService.class);
        um.findAll().forEach(user->{
            System.out.println(user.getUserName());
        });
        System.out.println("-----------");
        AuthorService authorService = ctx.getBean("authorService",AuthorService.class);
        authorService.findAll().forEach(author->{
            System.out.println(author.getRealName());
        });
    }
}
