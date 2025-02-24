package ru.MrEnthropia.Azurite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.MrEnthropia.Azurite.models.Category;
import ru.MrEnthropia.Azurite.models.Item;
import ru.MrEnthropia.Azurite.models.Log;
import ru.MrEnthropia.Azurite.models.QuantityUnit;
import ru.MrEnthropia.Azurite.repositories.ItemsRepository;

import java.awt.*;

@Controller
public class ItemController {

    @Autowired
    public ItemsRepository itemsRepository;

    @GetMapping("/warehouse")
    public String warehouse (Model model){
        Iterable<Item> items = itemsRepository.findAll();
        model.addAttribute("items", items);

        return "warehouse";
    }

    @GetMapping("/warehouse/add-item")
    public String addItem ( Model model){

        return "/warehouse/add-item";
    }

    @PostMapping("/warehouse/add-item")
    public String saveItem(@RequestParam String itemName,
                           @RequestParam Image imageItem,
                           @RequestParam Category categoryItem,
                           @RequestParam QuantityUnit unitItem,
                           @RequestParam int quantity,
                           @RequestParam String articleNumber,
                           @RequestParam Double price,
                           @RequestParam String comment
                           ){

        Item item = new Item(itemName, imageItem, categoryItem, unitItem, quantity, articleNumber, price, comment);
        itemsRepository.save(item);

        return "/warehouse/add-item";
    }


}
