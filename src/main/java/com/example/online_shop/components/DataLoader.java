package com.example.online_shop.components;

import com.example.online_shop.models.Item;
import com.example.online_shop.models.Order;
import com.example.online_shop.repositories.ItemRepository;
import com.example.online_shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

//    repositories
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;



    //    DataLoader Info
    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //create new Items
        Item item1 = new Item("Pandora Ring", 74.59);
        Item item2 = new Item("Nike Air Max 95", 119.99);
        Item item3 = new Item("Prada Bag", 1400.00);
        Item item4 = new Item("Telfar Bag", 500.00);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        //create new empty orders
        Order order1 = new Order();
        Order order2 = new Order();

        orderRepository.save(order1);
        orderRepository.save(order2);
    }

}