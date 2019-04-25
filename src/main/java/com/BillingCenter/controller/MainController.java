package com.BillingCenter.controller;

import com.BillingCenter.model.PhoneService;
import com.BillingCenter.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private Services service;

    @RequestMapping(value ="/")
    public String hello(ModelMap map){
        List<PhoneService> services = service.getAllServices();
        map.addAttribute("services", services);
        return "index";
    }
}
