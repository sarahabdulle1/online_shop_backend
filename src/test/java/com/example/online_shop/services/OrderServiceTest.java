
package com.example.online_shop.services;
import com.example.online_shop.models.Item;
import com.example.online_shop.models.Order;
import com.example.online_shop.repositories.ItemRepository;
import com.example.online_shop.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {

    private Order order;
    private ItemRepository itemRepository;

    private OrderRepository orderRepository;

    private OrderService orderService;


    @BeforeEach  // TO DO: fix this so it actually works and I don't have to call each item/order in every test
    public void setUp() {
//        items
        Item item1 = new Item("Pandora Ring", BigDecimal.valueOf(74.59));
        Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));
        Item item3 = new Item("Prada Bag", BigDecimal.valueOf(1400.00));
        Item item4 = new Item("Telfar Bag", BigDecimal.valueOf(500.00));

//        orders
        order = new Order();

    }

    //    tests for adding item to list correctly
    @Test
    public void canAddItemToList() {
        Item item1 = new Item("Pandora Ring", BigDecimal.valueOf(74.59));
        Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));

        Order order = new Order();

        List itemList = order.getItems();

        itemList.add(item1);

        assertThat(order.getItemCount()).isEqualTo(1);
    }

    @Test
    public void canAddDuplicateItems() {
        Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));

        Order order = new Order();

        List itemList = order.getItems();

        itemList.add(item2);
        itemList.add(item2);
        assertThat(order.getItemCount()).isEqualTo(2);
    }

    @Test
    public void canAddItemsOfDifferentNames() {
        Item item1 = new Item("Pandora Ring", BigDecimal.valueOf(74.59));
        Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));
        Item item3 = new Item("Prada Bag", BigDecimal.valueOf(1400.00));

        Order order = new Order();

        List itemList = order.getItems();

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        assertThat(order.getItemCount()).isEqualTo(3);
    }

//    tests for updating total price correctly

    @Test
    public void canUpdateTotalPrice() {
        Item item1 = new Item("Pandora Ring", BigDecimal.valueOf(74.59));
        Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));
        Item item3 = new Item("Prada Bag", BigDecimal.valueOf(1400.00));
        Item item4 = new Item("Telfar Bag", BigDecimal.valueOf(500.00));


        BigDecimal item1Price = item1.getPrice();
        BigDecimal item2Price = item2.getPrice();
        BigDecimal item3Price = item3.getPrice();
        BigDecimal item4Price = item4.getPrice();

        Order order = new Order();
        BigDecimal orderTotalPrice = order.getTotalPrice();

        List itemList = order.getItems();

        BigDecimal updatedTotalPrice = orderTotalPrice.add(item1Price);

        updatedTotalPrice = updatedTotalPrice.add(item2Price);
        updatedTotalPrice = updatedTotalPrice.add(item3Price);
        updatedTotalPrice = updatedTotalPrice.add(item4Price);

        assertThat(updatedTotalPrice).isEqualTo(BigDecimal.valueOf(2094.58));
    }


   @Test
   public void canAddTwoDecimals(){
       Item item1 = new Item("Pandora Ring", BigDecimal.valueOf(74.59));
       Item item2 = new Item("Nike Air Max 95", BigDecimal.valueOf(119.99));

       BigDecimal item1Price = item1.getPrice();
       BigDecimal item2Price = item2.getPrice();

       Order order = new Order();
       BigDecimal orderTotalPrice = order.getTotalPrice();

       List itemList = order.getItems();

       BigDecimal updatedTotalPrice = orderTotalPrice.add(item1Price);

       updatedTotalPrice = updatedTotalPrice.add(item2Price);

       assertThat(updatedTotalPrice).isEqualTo(BigDecimal.valueOf(194.58));
   }

   @Test
   public void canAddTwoWholeNumbers(){
       Item item3 = new Item("Prada Bag", BigDecimal.valueOf(1400.00));
       Item item4 = new Item("Telfar Bag", BigDecimal.valueOf(500.00));

       BigDecimal item3Price = item3.getPrice();
       BigDecimal item4Price = item4.getPrice();

       Order order = new Order();
       BigDecimal orderTotalPrice = order.getTotalPrice();

       List itemList = order.getItems();

       BigDecimal updatedTotalPrice = orderTotalPrice.add(item3Price);

       updatedTotalPrice = updatedTotalPrice.add(item4Price);

       assertThat(updatedTotalPrice).isEqualTo(BigDecimal.valueOf(1900.0));
   }

}
