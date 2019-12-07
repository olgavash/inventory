package com.inventory.controllers;

import com.inventory.models.CountSheet;
import com.inventory.dto.CountSheetListDto;
import com.inventory.models.data.CountSheetDao;
import com.inventory.models.data.ProductClassDao;
import com.inventory.models.data.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;

@Controller
public class CountSheetController {


    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductClassDao productClassDao;

    @Autowired
    private CountSheetDao countSheetDao;



//    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
//    public @ModelAttribute("countSheetListDto")
//    CountSheetListDto countSheetForm () {
//        return new CountSheetListDto();
//    }


//    @GetMapping("/countSheet")

    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
    public String countSheetForm(Model model) {
        CountSheetListDto countSheetForm = new CountSheetListDto();
        int size = countSheetForm.size();
        for (int i = 1; i <= size ; i++) {
            countSheetForm.addCount(new CountSheet());
        }

        model.addAttribute("form", countSheetForm);
        return "count/countSheet";
    }



//    public String countSheetForm(Model model) {
//        model.addAttribute("title", "Count Sheet");
//        model.addAttribute("countSheetList");
//        Iterable<Product> products = productDao.findAll();
//        model.addAttribute("products", products);
//        model.addAttribute("currentDate", CountCmd.getCurrentDate());

//        Iterable<ProductClass> productClassList = productClassDao.findAll();
//        model.addAttribute("productClass", productClassList);


//        return "count/countSheet";
//    }

    @RequestMapping(value="/countSheet", method = RequestMethod.POST)
//    public @ModelAttribute("countSheetList")
    public String proceedCountSheet(@ModelAttribute @Valid ArrayList<CountSheet> countSheetList,
            BindingResult bindingResult, Model model) {

        for (CountSheet item : countSheetList) {
            item.setInvDate(new Date(System.currentTimeMillis()));
        }

        System.out.println("List size " + countSheetList.size());

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Count Sheet");
            System.out.println("Something went wrong");
            return "count/countSheet";
        }

        countSheetDao.saveAll(countSheetList);
        return "redirect:/countSheet";
    }


}
