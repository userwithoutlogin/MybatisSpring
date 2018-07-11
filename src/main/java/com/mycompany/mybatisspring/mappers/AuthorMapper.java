/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.mappers;

import com.mycompany.mybatisspring.entities.Author;
import java.util.List;

/**
 *
 * @author root
 */
public interface AuthorMapper {
    List<Author>  findAll();
}
