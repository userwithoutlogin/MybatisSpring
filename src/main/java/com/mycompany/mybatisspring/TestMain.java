/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring;

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
    public static void main(String[] args) {
        Resource cpRes = new ClassPathResource("classpath:META-INF.spring/root.xml");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(cpRes);
        ctx.refresh();
        
        
    }
}
