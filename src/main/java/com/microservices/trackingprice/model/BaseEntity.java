package com.microservices.trackingprice.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/5/2023
 * @project tracking-price
 * &
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@MappedSuperclass
public class BaseEntity implements Serializable {

    public String payload = "";

    public BaseEntity(String payload) {
        this.payload = payload;
    }
}
