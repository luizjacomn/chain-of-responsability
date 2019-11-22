package com.luizjacomn.chain.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Sale
 */
public class Sale {

    private BigDecimal totalValue;

    private List<Item> items;

    public Sale() {
        this.totalValue = BigDecimal.ZERO;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.totalValue = this.totalValue.add(item.getItemValue());
    }

    /**
     * @return the totalValue
     */
    public BigDecimal getTotalValue() {
        return totalValue;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }
}