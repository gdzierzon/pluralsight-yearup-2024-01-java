package com.pluralsight.controllers;

import com.pluralsight.models.Pizza;
import com.pluralsight.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/pizzas")
public class PizzasController
{
    private PizzaService pizzaService;

    @Autowired
    public PizzasController(PizzaService pizzaService)
    {
        this.pizzaService = pizzaService;
    }

    @GetMapping()
    public ArrayList<Pizza> getPizzasByOrderId(@RequestParam(name = "oid") int orderId)
    {
        return pizzaService.findByOrderId(orderId);
    }

    @GetMapping("{id}")
    public Pizza getPizzasById(@PathVariable int id)
    {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping()
    public Pizza addPizza(@RequestBody Pizza pizza)
    {
        pizzaService.addPizza(pizza.getOrderId(), pizza);
        return pizza;
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Pizza pizza)
    {
        pizzaService.updatePizza(id, pizza);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id)
    {
        pizzaService.deletePizza(id);
    }
}
