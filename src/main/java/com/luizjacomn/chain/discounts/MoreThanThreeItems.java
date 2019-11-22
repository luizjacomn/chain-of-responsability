package com.luizjacomn.chain.discounts;

import java.math.BigDecimal;

import com.luizjacomn.chain.models.Sale;

/**
 * MoreThanThreeItems
 */
public class MoreThanThreeItems implements Discount {

    private Discount next;

    @Override
    public void setNext(Discount discount) {
        this.next = discount;
    }

    @Override
    public BigDecimal calculate(Sale sale) {
        BigDecimal totalValue = sale.getTotalValue();
        
        if (sale.getItems().size() >= 3) {
            return totalValue.multiply(BigDecimal.valueOf(0.02));
        }

        return next.calculate(sale);
    }

}