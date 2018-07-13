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
public class Van extends Vehicle{
    private Integer powerSlidingDoor;

    public Integer getPowerSlidingDoor() {
        return powerSlidingDoor;
    }

    public void setPowerSlidingDoor(Integer powerSlidingDoor) {
        this.powerSlidingDoor = powerSlidingDoor;
    }
    
}
