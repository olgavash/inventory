package com.inventory.controllers;


import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductListController {

    @Autowired
    private ProductListDao productListDao;

    @Autowired
    private ProductClassDao productClassDao;


    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("products", productListDao.findAll());
        model.addAttribute("title", "Product List");

        return "products/index";
    }



}
