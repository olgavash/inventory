package com.inventory.controllers;


import com.inventory.models.Product;
import com.inventory.models.ProductClass;
import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    public ProductController() {
    }

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("product", productDao.findAll());
        model.addAttribute("title", "Cafeteria Inventory");

        return "index";
    }

    @RequestMapping("/product")
    public String showProducts(Model model) {

        List<Product> products = (List<Product>) productDao.findAll();
        model.addAttribute("products", products);

        return "product/products";
    }


//    private Product product = new Product();
    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("title", "Add Product");
        model.addAttribute(new Product());

        Iterable<ProductClass> productClassList = productClassDao.findAll();

        model.addAttribute("productClass", productClassList);

        return "product/addProduct";
    }


    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute @Valid Product newProduct,
                             BindingResult bindingResult, @RequestParam int productClassId, Model model) {
        // Method to handle post addProduct

        newProduct.setProductClassId(productClassId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Product");
            System.out.println("Something went wrong");
           return "product/addProduct";
        }

        productDao.save(newProduct);
        return "redirect:/product";
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

//    @RequestMapping(value = "/admin/productInventory/editProduct/{id}")
//    public String editProduct(@PathVariable String id, Model model) {
//        Product product = productDao.getProductById(id);
//        model.addAttribute(product);
//        return "editProduct";
//    }

}
