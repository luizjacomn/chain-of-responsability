package com.luizjacomn.chain;

import java.math.BigDecimal;

import com.luizjacomn.chain.discounts.Discount;
import com.luizjacomn.chain.discounts.MoreThanOneHundredValue;
import com.luizjacomn.chain.discounts.MoreThanOneThousandValue;
import com.luizjacomn.chain.discounts.MoreThanThreeItems;
import com.luizjacomn.chain.discounts.WithoutDiscount;
import com.luizjacomn.chain.models.Item;
import com.luizjacomn.chain.models.Sale;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Sale sale = new Sale();
        Discount threeItems = new MoreThanThreeItems();
        Discount oneHundred = new MoreThanOneHundredValue();
        Discount oneThousand = new MoreThanOneThousandValue();
        Discount without = new WithoutDiscount();

        sale.addItem(new Item("Tenis", 270.0));
        sale.addItem(new Item("Sapato", 350.0));
        sale.addItem(new Item("Camisa", 200.0));
        sale.addItem(new Item("Calça", 180.0));

        threeItems.setNext(without);
        oneHundred.setNext(threeItems);
        oneThousand.setNext(oneHundred);

        BigDecimal discount = oneThousand.calculate(sale);

        System.out.println(sale.getTotalValue().setScale(2, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(discount.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(sale.getTotalValue().subtract(discount).setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
}