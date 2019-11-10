package com.inventory.controllers;


import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("product", productDao.findAll());
        model.addAttribute("title", "Product List");

        return "product/index";
    }


}
