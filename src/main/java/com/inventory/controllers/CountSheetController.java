package com.inventory.controllers;

import com.inventory.models.CountSheet;
import com.inventory.models.Product;
import com.inventory.models.data.CountSheetDao;
import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
//      model.addAttribute("countSheetList");
        model.addAttribute("countSheet", new CountSheet());
        Iterable<Product> products = productDao.findAll();
        model.addAttribute("products", products);
        model.addAttribute("currentDate", CountSheet.getCurrentDate());

        return "count/countSheet";
    }


    @RequestMapping(value="count/countSheet", method = RequestMethod.POST)
    public String proceedCountSheet(@ModelAttribute @Valid CountSheet newCountSheet,
                                    BindingResult bindingResult,
                                    @RequestParam int[] productIds, Model model)    {


        Iterable<Product> products = productDao.findAll();
        for (int productId : productIds) {
            newCountSheet.setCount(productId);
            newCountSheet.setInvDate(new Date(System.currentTimeMillis()));

        }
        countSheetDao.save(newCountSheet);


//        System.out.println("Stop");
//
//        System.out.println("Stop");
//
//        System.out.println("Stop");
//
//        System.out.println("Stop");
        return "redirect:/countSheet";
    }


}
