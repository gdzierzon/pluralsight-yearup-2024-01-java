package com.pluralsight.controllers;

import com.pluralsight.models.Order;
import com.pluralsight.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/orders")
public class OrdersController
{
    private OrdersService orderService;

    @Autowired
    public OrdersController(OrdersService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("{id}")
    public Order getById(@PathVariable int id)
    {
        return orderService.getByOrderId(id);
    }

    @PostMapping()
    public Order addNew(@RequestBody Order order)
    {
        orderService.addOrder(order);

        return order;
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Order order)
    {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        orderService.deleteOrder(id);
    }

}
