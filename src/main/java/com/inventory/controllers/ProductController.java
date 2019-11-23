package com.inventory.controllers;


import com.inventory.models.Product;
import com.inventory.models.ProductClass;
import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

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


    //TODO To add product I need to build an object to form data

    private Product product = new Product();
    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("title", "Add Product");
        Product product = new Product();
        ProductClass className = (ProductClass) productClassDao.findAll();
//        model.addAttribute(new Product());
        model.addAttribute("productClasses", className);

        return "product/addProduct";
    }


    //TODO add and commit that object to the database
    //TODO edit and delete

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute @Valid Product newProduct,
                             Errors errors, @RequestParam int productClass_id, Model model) {
        // Method to handle post addProduct

        ProductClass productClass= (ProductClass) productClassDao.findAll();
        newProduct.setProductClass(productClass);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Product");
            System.out.println("Something went wrong");
           return "product/addProduct";
        }

        productDao.save(newProduct);

        return "product/products"; //+ product.getProduct_id();
    }

    @RequestMapping(value = "/removeProduct", method = RequestMethod.GET)
    public String removeProductForm(Model model) {
        model.addAttribute("products", productDao.findAll());
        model.addAttribute("title", "Remove Product");
        return "product/remove";
    }


    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
    public String removeProduct(@RequestParam int[] productIds) {

        for (int productId : productIds) {
            productDao.deleteById(productId);
        }

        return "redirect:";
    }



}
