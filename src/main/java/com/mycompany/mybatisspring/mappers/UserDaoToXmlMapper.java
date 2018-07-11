/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.mappers.UserMapper;
import com.mycompany.mybatisspring.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service("userMapperXml")
public class UserDaoToXmlMapper implements UserMapper{
 
    private SqlSession  session ;

    public SqlSession getSession() {
        return session;
    }
    @Autowired
    public void setSession(SqlSession session) {
        this.session = session;
    }
     
  
    @Override
    public List<User> findAll(){
        return session.selectList("sqlM.findUsers");           
    }
}
