package com.microservices.trackingprice.model.modeltrackingPrice;


import com.microservices.trackingprice.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/5/2023
 * @project tracking-price
 * &
 */
@Setter
@Getter
public class Price extends BaseEntity {
    public Price(String payload) {
        super(payload);
    }
}
