package com.shen.cloud.command;

import lombok.Getter;
import lombok.Setter;

/**
 * 股票
 */
@Getter
@Setter
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    /**
     * 购买
     */
    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }

    /**
     * 出售
     */
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
