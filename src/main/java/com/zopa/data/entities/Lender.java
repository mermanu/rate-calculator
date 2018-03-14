/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zopa.data.entities;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author manuelmerida
 */
public class Lender {
    
    private int id;
    private String name;
    private BigDecimal rate;
    private Integer available;

    public Lender() {
    }
      
    public Lender(int id, String name, BigDecimal rate, Integer available) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public int hashCode(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lender other = (Lender) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.rate, other.rate)) {
            return false;
        }
        if (!Objects.equals(this.available, other.available)) {
            return false;
        }
        return true;
    }
}
