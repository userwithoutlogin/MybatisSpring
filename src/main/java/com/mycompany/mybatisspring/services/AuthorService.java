/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.services;

import com.mycompany.mybatisspring.entities.Author;
import com.mycompany.mybatisspring.mappers.AuthorMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author root
 */
@Service("authorService")
public class AuthorService {
    @Resource(name = "authorMapperXml")
    AuthorMapper authorMapper;  

    public AuthorMapper getAuthorMapper() {
        return authorMapper;
    }

    public void setAuthorMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }
    
    public List<Author> findAll(){
        return authorMapper.findAll();
    }
    
}
