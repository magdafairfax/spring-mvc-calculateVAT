package com.vat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller("error")
public class ErrorController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException
            (HttpServletRequest request, Exception ex){

        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", ex.getLocalizedMessage());
        mv.addObject("url", request.getRequestURL());

        mv.setViewName("error");
        return mv;
    }

}
