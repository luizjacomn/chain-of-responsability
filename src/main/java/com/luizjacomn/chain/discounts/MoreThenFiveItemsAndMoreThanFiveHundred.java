package com.luizjacomn.chain.discounts;

import java.math.BigDecimal;

import com.luizjacomn.chain.models.Sale;

/**
 * MoreThenFiveItemsAndMoreThanFiveHundred
 */
public class MoreThenFiveItemsAndMoreThanFiveHundred implements Discount {

    private Discount next;

    @Override
    public void setNext(Discount discount) {
        this.next = discount;
    }

    @Override
    public BigDecimal calculate(Sale sale) {
        BigDecimal totalValue = sale.getTotalValue();

        if (sale.getItems().size() >= 5 && totalValue.compareTo(BigDecimal.valueOf(500.0)) >= 0) {
            printDiscount();
            return totalValue.multiply(BigDecimal.valueOf(0.04));
        }

        return next.calculate(sale);
    }
    
}