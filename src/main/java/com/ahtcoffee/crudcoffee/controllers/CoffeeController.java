package com.ahtcoffee.crudcoffee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahtcoffee.crudcoffee.models.Coffee;
import com.ahtcoffee.crudcoffee.services.CoffeeService;

@Controller
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("list-coffee")
    public String listCoffee(Model model) {
        List<Coffee> coffees = coffeeService.getAllCoffee();
        model.addAttribute("coffees", coffees);
        return "list-coffee";
    }

    @GetMapping("add")
    public String addCoffee(Model model) {
        Coffee coffee = new Coffee();
        model.addAttribute("coffee", coffee);
        return "add-coffee";
    }

    @PostMapping("add-save")
    public String saveCoffee(Coffee coffee) {
        coffeeService.addCoffee(coffee);
        return "redirect:list-coffee";
    }

    @PostMapping("updates/{code}")
    public String saveUpdate(@ModelAttribute("coffee") Coffee coffee, @PathVariable Integer code) {
        coffeeService.setCoffee(coffee, code);
        return "redirect:list-coffee";
    }

    @GetMapping("update/{code}")
    public String updateCoffee(Model model, @PathVariable Integer code) {
        Coffee coffee = coffeeService.getCoffeeById(code);
        model.addAttribute("coffee", coffee);
        return "update-coffee";
    }

    @GetMapping("delete/{code}")
    public String deleteCoffee(@PathVariable(value = "code") Integer code) {
        coffeeService.deleteCoffee(code);
        return "redirect:list-coffee";
    }
    

}
