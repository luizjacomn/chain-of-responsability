package com.luizjacomn.chain.discounts;

import java.math.BigDecimal;

import com.luizjacomn.chain.models.Sale;

/**
 * Discount
 */
public interface Discount {

    void setNext(Discount discount);

    BigDecimal calculate(Sale sale);
    
}