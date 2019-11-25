package com.luizjacomn.chain.discounts;

import java.math.BigDecimal;

import com.luizjacomn.chain.models.Sale;

/**
 * WithoutDiscount
 */
public class WithoutDiscount implements Discount {

    @Override
    public void setNext(Discount discount) {
        // DO NOTHING
    }

    @Override
    public BigDecimal calculate(Sale sale) {
        printDiscount();
        return BigDecimal.ZERO;
    }

}