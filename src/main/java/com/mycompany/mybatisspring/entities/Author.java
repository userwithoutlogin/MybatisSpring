/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mybatisspring.entities;

/**
 *
 * @author root
 */
public class Author {
    private Long id;
    private String realName;
    private String idCard;
    private User user;

    public Author() {
    }

    public Author(Long id, String realName, String idCard, User user) {
        this.id = id;
        this.realName = realName;
        this.idCard = idCard;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", realName=" + realName + ", idCard=" + idCard + ", user=" + user + '}';
    }
    
}
