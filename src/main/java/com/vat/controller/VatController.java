package com.vat.controller;

import com.vat.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VatController {
    @Autowired
    VatService vatService;
    @RequestMapping(value = "/calculateVat", method = RequestMethod.POST)
    public ModelAndView calculateVat(ModelMap model, @RequestParam(value = "gross") String gross, @RequestParam (value ="vatRate") String vatRate ) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        double vat = vatService.calculateVAT(
                Double.parseDouble(gross),
                Double.parseDouble(vatRate)/100);

        mv.addObject("vat", vat);
        return mv;

    }

}
