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
public class Truck extends Vehicle{
    private Integer boxSize;

    public Integer getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(Integer boxSize) {
        this.boxSize = boxSize;
    }
    
}
