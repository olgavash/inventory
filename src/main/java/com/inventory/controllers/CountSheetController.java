package com.inventory.controllers;

import com.inventory.models.CountSheet;
import com.inventory.models.Product;
import com.inventory.models.ProductClass;
import com.inventory.models.data.CountSheetDao;
import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CountSheetController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    @Autowired
    private CountSheetDao countSheetDao;


    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
    public String countSheetForm(Model model) {
        model.addAttribute("title", "Count Sheet");
        model.addAttribute(new CountSheet());
        Iterable<Product> products = productDao.findAll();
        model.addAttribute("products", products);
//        Iterable<ProductClass> productClassList = productClassDao.findAll();
//        model.addAttribute("productClass", productClassList);


        return "count/countsheet";
    }

    @RequestMapping(value="/countSheet", method = RequestMethod.POST)
    public String proceedCountSheet(@ModelAttribute @Valid CountSheet newCountSheet,
                                    BindingResult bindingResult, @RequestParam int productId, Model model) {
        // Method to handle post addProduct

        newCountSheet.setProductId(productId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Count Sheet");
            System.out.println("Something went wrong");
            return "count/savecountsheet";
        }

        countSheetDao.save(newCountSheet);
        return "redirect:/count";
    }
}
