package com.example.online_shop.services;


import com.example.online_shop.models.Item;

import com.example.online_shop.models.Order;
import com.example.online_shop.repositories.ItemRepository;
import com.example.online_shop.repositories.OrderRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;


    //   1. update total price

    public BigDecimal updateTotalPriceByItemId(Long itemId, Long orderId) {
            // get current total price of order
            Order order = orderRepository.findById(orderId).get();
            BigDecimal orderTotalPrice = order.getTotalPrice();

            // get price of item
            Item item = itemRepository.findById(itemId).get();
            BigDecimal itemPrice = item.getPrice();

            //add item price to total price for a new total price and save to repository
            BigDecimal updatedTotalPrice = orderTotalPrice.add(itemPrice);

            order.setTotalPrice(updatedTotalPrice);
            orderRepository.save(order);

            return updatedTotalPrice;
        }

//    2. add item to list
    public List addItemToList(Long itemId, Long orderId){
        //get item by id
        Item item = itemRepository.findById(itemId).get();

        //get item list by orderid
        Order order = orderRepository.findById(orderId).get();
        List itemList = order.getItems();

        //append item to the items list of order
        itemList.add(item);

        //update totalPrice
        orderRepository.save(order);

        return itemList;
    }
//    3. addToCart

    public Order addItemToCart(Long itemId, Long orderId){
        Order order = orderRepository.findById(orderId).get();

        BigDecimal newPrice = updateTotalPriceByItemId(itemId, orderId);
        List newList = addItemToList(itemId, orderId);

        orderRepository.save(order);

        return order;

    }

//    3. create cart

//    4.Submit order

    public String submitOrder(Long orderId){
        Order order = orderRepository.findById(orderId).get();

        Boolean isOrderPlaced = order.getOrderPlaced();

        String message = "";

        if (isOrderPlaced == false){
            order.setOrderPlaced(true);
            orderRepository.save(order);
            message = "Order has been placed successfully";
        }
        if (isOrderPlaced == true){
           message = "Order has already been placed";
        }

        return message;
    }
    public Order getOrderById(Long orderId){
        Order order = orderRepository.findById(orderId).get();
        return order;
    }
    public List<Order> getAllOrders(){
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }
}
