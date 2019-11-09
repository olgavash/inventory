package com.inventory.controllers;


import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productList")
public class ProductListController {

    @Autowired
    private ProductListDao productListDao;

    @Autowired
    private ProductClassDao productClassDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("productList", productListDao.findAll());
        model.addAttribute("title", "Product List");

        return "productList/index";
    }



}
