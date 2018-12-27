package com.shen.cloud.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 经纪人
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

    public static void main(String[] args) {
        Stock abcStock = new Stock();
        abcStock.setName("买第一个股票");
        BuyStock buyStockOrder = new BuyStock(abcStock);
        Stock abcStockTwo = new Stock();
        abcStockTwo.setName("卖第二个股票");
        SellStock sellStockOrder = new SellStock(abcStockTwo);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}
