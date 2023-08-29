package com.example.online_shop.services;

import com.example.online_shop.models.Item;
import com.example.online_shop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Item getItemById(Long itemId){
        Item item = itemRepository.findById(itemId).get();
        return item;
    }
    public List<Item> getAllItems(){
        List<Item> items = itemRepository.findAll();
        return items;
    }
}
