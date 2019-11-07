package com.vat.controller;

import com.vat.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class VatController {
    @Autowired
    VatService vatService;
    @RequestMapping(value = "/calculateVat", method = RequestMethod.POST)
    public ModelAndView calculateVat(ModelMap model,
                                     @RequestParam(value = "gross", required = false) String gross,
                                     @RequestParam (value ="vatRate", required = false) String vatRate ) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("calculateVat");
        if (gross.isEmpty() || vatRate.isEmpty()) {
            mv.addObject("errMessage","Please input correct values for gross or/and vat rate.");
        } else {
            double vat = vatService.calculateVAT(
                     Double.parseDouble(gross),
                    Double.parseDouble(vatRate) / 100);
            mv.addObject("vat", vat);
        }
        return mv;

    }

}
