package com.inventory.controllers;


import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("product", productDao.findAll());
        model.addAttribute("title", "Cafeteria Inventory");

        return "index";
    }

    @RequestMapping("/product")
    public String showProducts(Model model) {

        model.addAttribute("product", productDao.findAll());
        model.addAttribute("title", "Product List");

        return "product/products";
    }

    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        return "product/addProduct";
    }

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(Model model) {
        // Method to handle post addProduct
        return "product/products";
    }
}
