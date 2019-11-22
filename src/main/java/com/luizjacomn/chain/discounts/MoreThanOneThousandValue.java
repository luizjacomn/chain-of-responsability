package com.luizjacomn.chain.discounts;

import java.math.BigDecimal;

import com.luizjacomn.chain.models.Sale;

/**
 * MoreThanOneThousandValue
 */
public class MoreThanOneThousandValue implements Discount {

    private Discount next;

    @Override
    public void setNext(Discount discount) {
        this.next = discount;
    }

    @Override
    public BigDecimal calculate(Sale sale) {
        BigDecimal totalValue = sale.getTotalValue();

        if (totalValue.compareTo(new BigDecimal("1000")) >= 0) {
            return totalValue.multiply(BigDecimal.valueOf(0.04));
        }

        return next.calculate(sale);
    }
   
}