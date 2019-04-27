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

    @RequestMapping(value = "/customers")
    public String customersList(ModelMap map){
        List<Customer> customers = service.getAllCustomers();
        customers.sort((o1, o2) -> (o1.getId()<o2.getId())? -1 : 1);
        map.addAttribute("customers", customers);
        return "CustomersList";
    }

    @RequestMapping(value = "/createCustomerForm")
    public ModelAndView createCustomerForm(){
        ModelAndView modelAndView = new ModelAndView("createCustomer");
        modelAndView.getModelMap().addAttribute("customer", new Customer());
        modelAndView.getModelMap().addAttribute("services", service.getAllServices());
        return modelAndView;
    }

    @RequestMapping(value = "/saveCustmerAction")
    public ModelAndView saveCustmerAction(@ModelAttribute Customer customer){
        service.saveCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/fullCustomerInfoForm")
    public ModelAndView fullCustomerInfoForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("fullCustomersInfo");
        Customer customer = service.getCustomerById(id);
        modelAndView.getModelMap().addAttribute("customer", customer);
        modelAndView.getModelMap().addAttribute("services", service.getAllServices());
        return modelAndView;
    }

    @RequestMapping(value = "/updateCustomerAction")
    public ModelAndView updateCustomerAction(@ModelAttribute Customer customer){
        service.updateCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/deleteCustomerAction")
    public ModelAndView deleteCustomerAction(@RequestParam int id){
        service.deleteCustomer(id);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value ="/services")
    public String servicesList(ModelMap map){
        List<PhoneService> services = service.getAllServices();
        services.sort((o1, o2) -> (o1.getId()<o2.getId())? -1 : 1);
        map.addAttribute("services", services);
        return "ServicesList";
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
        return new ModelAndView("redirect:/services");
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
        return new ModelAndView("redirect:/services");
    }

    @RequestMapping(value = "/cancelServiceAction")
    public ModelAndView cancelUpdateServiceAction(@ModelAttribute PhoneService phoneService){
        return new ModelAndView("redirect:/services");
    }
    @RequestMapping(value = "/deleteServiceAction")
    public ModelAndView deleteServiceAction(@RequestParam int id){
        service.deleteService(id);
        return new ModelAndView("redirect:/services");
    }


}
