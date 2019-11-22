package com.luizjacomn.chain.models;

import java.math.BigDecimal;

public class Item {

    private String itemName;

    private BigDecimal itemValue;

    public Item(String itemName, BigDecimal itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public Item(String itemName, String stringValue) {
        this(itemName, new BigDecimal(stringValue));
    }

    public Item(String itemName, double doubleValue) {
        this(itemName, BigDecimal.valueOf(doubleValue));
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the itemValue
     */
    public BigDecimal getItemValue() {
        return itemValue;
    }

}