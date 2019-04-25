package com.BillingCenter.controller;

import com.BillingCenter.model.Customer;
import com.BillingCenter.model.PhoneService;
import com.BillingCenter.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private Services service;

    @RequestMapping(value ="/")
    public String servicesList(ModelMap map){
        List<PhoneService> services = service.getAllServices();
        map.addAttribute("services", services);
        return "index";
    }

    @RequestMapping(value = "/createServiceForm")
    public ModelAndView createServiceForm(){
        ModelAndView modelAndView = new ModelAndView("createService");
        modelAndView.getModelMap().addAttribute("service", new PhoneService());
        return modelAndView;
    }

    @RequestMapping(value = "/saveServiceAction")
    public ModelAndView saveServiceAction(@ModelAttribute PhoneService phoneService){
        service.saveService(phoneService);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/updateServiceForm")
    public ModelAndView updateServiceForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("updateService");
        PhoneService phoneService = service.getServiceById(id);
        modelAndView.getModelMap().addAttribute("service", phoneService);
        return modelAndView;
    }

    @RequestMapping(value = "/updateServiceAction")
    public ModelAndView updateServiceAction(@ModelAttribute PhoneService phoneService){
        service.updateService(phoneService);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteServiceAction")
    public ModelAndView deleteServiceAction(@RequestParam int id){
        service.deleteService(id);
        return new ModelAndView("redirect:/");
    }
}
