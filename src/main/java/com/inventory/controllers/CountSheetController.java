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
    public String countSheetForm(Model model) {
        List<CountSheet> countSheetList = new ArrayList<>();
        for(Product item: productDao.findAll()){
            CountSheet countshet = new CountSheet();
            countshet.setCount(-11.00);
            countshet.setCountId(item.getProductId());
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

        System.out.println(countSheetList.toString());
        countSheetDao.saveAll(countSheetList);

        return "count/countSheet";
    }




//    @RequestMapping(value="/countSheet", method = RequestMethod.POST)
//    public String proceedCountSheet(@ModelAttribute @Valid ArrayList<CountSheet> countSheetList,
//                                    BindingResult bindingResult, Model model) {
//
//
//        for (CountSheet item : countSheetList) {
//            item.setInvDate(new Date(System.currentTimeMillis()));
//        }
//
////        System.out.println("List size " + countSheetList.size());
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("title", "Save Count Sheet");
//            System.out.println("Something went wrong");
//            return "product/addProduct";
//        }
//        for(CountSheet item: countSheetList){
////            if(countSheetForm(count)!=null) {
//                countSheetDao.save(item);
//        }
//
//        System.out.println("stop");
////        countSheetDao.saveAll(countSheetList);
//        return "redirect:/countSheet";
//    }

    @GetMapping("/countSheet/formreturn")
    public String proceedCountSheet(@ModelAttribute @Valid ArrayList<CountSheet> countSheetList, @RequestParam String countInput,
                                    BindingResult bindingResult, Model model) {
        System.out.println("stop");
        System.out.println(countInput);

        //convert countInput in array and after convert Strings into Integers

        String[] countInputArrayString;
        countInputArrayString = countInput.split(",");
        Integer [] countInputArrayInt = new Integer[countInputArrayString.length];
        for( int i=0; i<countInputArrayString.length; i++) {
            String item = countInputArrayString[i];
            int itemInt = Integer.parseInt(item);
            countInputArrayInt[i] = itemInt;
        }

        //now we have to pull all data for the "form submitted" html

//        List<Product> productSheetList = new ArrayList<>();
//        for(Product item: productDao.findAll()){
//            productSheetList.add(item);
//        }

        List<CountSheet> countSheetList1 = new ArrayList<>();

        for(CountSheet item: countSheetDao.findAll()){
           if(item.getCount()==-11.00) {
               countSheetList1.add(item);
           }

        }

        System.out.println("stop");

        for (int i=0; i<countSheetList1.size(); i++){
            countSheetList1.get(i).setCount(countInputArrayInt[i]);

        }

        System.out.println("stop");

        for (CountSheet item : countSheetList1) {
            item.setInvDate(new Date(System.currentTimeMillis()));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Count Sheet");
            System.out.println("Something went wrong");
            return "product/addProduct";
        }
        for(CountSheet item: countSheetList1){
            countSheetDao.save(item);
        }

        System.out.println("stop");

        return "redirect:/countSheet";
    }


}
