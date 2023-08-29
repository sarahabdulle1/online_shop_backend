package com.example.online_shop.controllers;

import com.example.online_shop.models.Order;
import com.example.online_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/order")
public class OrderController {
    @Autowired
    OrderService orderService;

//    1. get one order by id
    @GetMapping(value="/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId) ;
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
//    2. get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> order = orderService.getAllOrders() ;
        return new ResponseEntity<>(order, HttpStatus.OK);
}

//  create a cart ?
    @PostMapping(value="/order/{orderId}")
    public ResponseEntity<Order> newCart(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId) ;
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

//    3. add Item To Cart

    @PostMapping(value = "/{orderId}/item/{itemId}")
    public ResponseEntity<Order> addItemToCart(@PathVariable Long orderId, @PathVariable Long itemId){
        Order order = orderService.addItemToCart(itemId, orderId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
//    4. Make New Order
    @PostMapping(value = "/{orderId}")
    public ResponseEntity<String> submitNewOrder(@PathVariable Long orderId){
        String message = orderService.submitOrder(orderId);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }


//    extension
//    get all orders by userId

}
