package com.example.online_shop.controllers;

import com.example.online_shop.models.Item;
import com.example.online_shop.models.Order;
import com.example.online_shop.services.ItemService;
import com.example.online_shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    //    1. get one item by id
    @GetMapping(value="/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemId){
        Item item = itemService.getItemById(itemId) ;
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    //    2. get all items
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> item = itemService.getAllItems();
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

//    extension
//    3. get items by enum type: sizes, colour
//    4. get items by inventory
//
}
