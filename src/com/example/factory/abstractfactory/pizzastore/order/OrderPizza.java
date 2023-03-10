package com.example.factory.abstractfactory.pizzastore.order;

import com.example.factory.abstractfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbsFactory factory;

    //构造器
    public OrderPizza(AbsFactory factory) {
        this.setAbsFactory(factory);
    }

    private void setAbsFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = "";//用户输入
        this.factory = factory;

        do {
            orderType = getType();
            //factory可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory.createPizza(orderType);
            if(pizza != null) {//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

    //写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            System.out.println("input pizza type:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String str = bufferedReader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
