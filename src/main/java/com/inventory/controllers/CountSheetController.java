package com.inventory.controllers;

import com.inventory.dto.CountSheetDto;
import com.inventory.dto.ProductDto;
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


    private static final String DATEFORMAT = "MM/dd/yyyy";

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        return sdf.format(new Date(System.currentTimeMillis()));
    }


//    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
//    public @ModelAttribute("countSheetListDto")
//    CountSheetListDto countSheetForm () {
//        return new CountSheetListDto();
//    }


//    @GetMapping("/countSheet")


//    public List<ProductDto> countSheetForm(List<Product> products) {
//        List<ProductDto> productDtoList = null;
////        List<CountSheetDto> countSheetList = null;
//        if (products != null && !products.isEmpty()) {
//            productDtoList = new ArrayList<ProductDto>();
//            ProductDto productDto = null;
//            for (Product product : products) {
//                productDto = new ProductDto();
//                productDto.setProductId(product.getProductId());
//                productDto.setName(product.getName());
//                CountSheetDto countDto = new CountSheetDto();
//                countDto.setInvDate(countDto.getInvDate());
//                countDto.setCountId(countDto.getCountId());
//                countDto.setCount(countDto.getCount());
//                productDtoList.add(productDto);
//            }
//        }
//        return productDtoList;
//    }



    @RequestMapping(value="/countSheet", method = RequestMethod.GET)
//    public List<ProductDto> countSheetForm(Model model) {
//        CountSheetDto countSheetForm = new CountSheetDto();
//        int size = countSheetForm.size();
//        for (int i = 1; i <= size ; i++) {
//            countSheetForm.addCount(new CountSheet());
//        }
//
//        model.addAttribute("form", countSheetForm);
//        return "count/countSheet";
//    }
    public String countSheetForm(Model model) {
        List<CountSheet> countSheetList = new ArrayList<>();
        for(Product item: productDao.findAll()){
            CountSheet countshet = new CountSheet(); //TODO: think about what to do if you have multiple counts! Array should be created somewhere
            countshet.setCount(0);
            countshet.setCountId(item.getProductId()); //TODO: ID of each count does not have to be equial Product ID!!! Fix it.
            countshet.setProductId(item.getProductId());
            countshet.setInvDate(null);
            countshet.setProduct(item);
            countSheetList.add(countshet);
        }
        model.addAttribute("title", "Count Sheet");
        model.addAttribute("countSheetList");
        Iterable<Product> products = productDao.findAll();
        model.addAttribute("products", products);
        model.addAttribute("countSheets", countSheetList);
        model.addAttribute("currentDate", CountSheet.getCurrentDate());

//        Iterable<ProductClass> productClassList = productClassDao.findAll();
//        model.addAttribute("productClass", productClassList);
        System.out.println(countSheetList.toString());
        countSheetDao.saveAll(countSheetList);

        return "count/countSheet";
    }




    @RequestMapping(value="/countSheet", method = RequestMethod.POST)
    public String proceedCountSheet(@ModelAttribute @Valid ArrayList<CountSheet> countSheetList,
                                    BindingResult bindingResult, Model model) {


        for (CountSheet item : countSheetList) {
            item.setInvDate(new Date(System.currentTimeMillis()));
        }

//        System.out.println("List size " + countSheetList.size());

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Count Sheet");
            System.out.println("Something went wrong");
            return "product/addProduct";
        }
        for(CountSheet item: countSheetList){
            countSheetDao.save(item);
        }
//        countSheetDao.saveAll(countSheetList);
        return "redirect:/countSheet";
    }


}
