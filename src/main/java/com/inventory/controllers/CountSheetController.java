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
import java.time.LocalDate;
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


    private static final String DATEFORMAT = "MM/dd/yyyy";

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        return sdf.format(new Date(System.currentTimeMillis()));
    }


    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
    public String countSheetForm(Model model) {
        List<CountSheet> countSheetList = new ArrayList<>();
        for(Product item: productDao.findAll()){
            CountSheet countshet = new CountSheet();
            countshet.setCount(-11.00);
            countshet.setCountId(item.getProductId());
            countshet.setProductId(item.getProductId());
            countshet.setInvDate(new Date());
            countshet.setProduct(item);
            countSheetList.add(countshet);
        }
        model.addAttribute("title", "Count Sheet");
        model.addAttribute("countSheetList");
        Iterable<Product> products = productDao.findAll();
        model.addAttribute("products", products);
        model.addAttribute("countSheets", countSheetList);
        model.addAttribute("currentDate", CountSheet.getCurrentDate());

        System.out.println(countSheetList.toString());
//        countSheetDao.saveAll(countSheetList);

        return "count/countSheet";
    }

    @GetMapping("/countSheet/formreturn")
    public String proceedCountSheet(@ModelAttribute @Valid ArrayList<CountSheet> countSheetList, @RequestParam String countInput,
                                    BindingResult bindingResult, Model model) {

        for(Product item: productDao.findAll()){
            CountSheet countshet = new CountSheet();
            countshet.setCount(-11.00);
            countshet.setCountId(item.getProductId());
            countshet.setProductId(item.getProductId());
            countshet.setInvDate(null);
            countshet.setProduct(item);
            countSheetList.add(countshet);
        }
        model.addAttribute("currentDate", CountSheet.getCurrentDate());

        System.out.println(countSheetList.toString());
//        countSheetDao.saveAll(countSheetList);


        //convert countInput in array and after convert Strings into Integers

        String[] countInputArrayString;
        countInputArrayString = countInput.split(",");
        Integer [] countInputArrayInt = new Integer[countInputArrayString.length];
        for( int i=0; i<countInputArrayString.length; i++) {
            String item = countInputArrayString[i];
            int itemInt = Integer.parseInt(item);
            countInputArrayInt[i] = itemInt;
        }

        for(CountSheet item: countSheetDao.findAll()){
           if(item.getCount()==-11.00) {
               countSheetList.add(item);
           }

        }

        System.out.println("stop");

        for (int i=0; i<countSheetList.size(); i++){
            countSheetList.get(i).setCount(countInputArrayInt[i]);

        }

        System.out.println("stop");

        for (CountSheet item : countSheetList) {
            item.setInvDate(new Date(System.currentTimeMillis()));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Count Sheet");
            System.out.println("Something went wrong");
            return "product/addProduct";
        }
        for(CountSheet item: countSheetList){
            countSheetDao.save(item);
        }

        System.out.println("stop");

        return "redirect:/countSheet";
    }


    @RequestMapping(value = "/allCountSheet", method = RequestMethod.GET)
    public String viewCurrentInventory(Model model) {

        model.addAttribute("product", productDao.findAll());
        model.addAttribute("title", "Cafeteria Inventory");
        model.addAttribute("countSheets", countSheetDao.findAll());
        model.addAttribute("currentDate", CountSheet.getCurrentDate());

        return "count/allCuntSheet";
    }


}
