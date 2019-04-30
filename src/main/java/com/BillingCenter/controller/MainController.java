package com.BillingCenter.controller;

import com.BillingCenter.model.*;
import com.BillingCenter.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private Services service;

    @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }

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

    @RequestMapping(value = "/saveCustomerAction")
    public ModelAndView saveCustomerAction(@ModelAttribute Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        service.saveCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/fullCustomerInfoForm")
    public ModelAndView fullCustomerInfoForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("fullCustomersInfo");
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/updateCustomerAction")
    public ModelAndView updateCustomerAction(@ModelAttribute Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ModelAndView("error");
        Customer custFromDB = service.getCustomerById(customer.getId());
        customer.setBill(custFromDB.getBill());
        service.updateCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/deleteCustomerAction")
    public ModelAndView deleteCustomerAction(@RequestParam int id){
        service.deleteCustomer(id);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/addPhoneNumber")
    public ModelAndView addPhoneNumber(@RequestParam int id){
        Customer customer = service.getCustomerById(id);
        service.updatePhoneNumber(customer, 1);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/deletePhoneNumberFromCustomer")
    public ModelAndView deletePhoneNumberFromCustomer (@RequestParam int rowId){
        int id = service.freePhoneNumber(rowId);
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }


    @RequestMapping(value = "/createContactForm")
    public ModelAndView createContactForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("createContact");
        CustomerInfo customerInfo = new CustomerInfo();
        Customer customer = service.getCustomerById(id);
        customerInfo.setCustomerid(customer.getId());
        customerInfo.setCustomersByCustomerid(customer);
        modelAndView.getModelMap().addAttribute("contact", customerInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/saveContactAction")
    public ModelAndView saveContactAction(@ModelAttribute CustomerInfo customerInfo){
        service.addNewContact(customerInfo);
        ModelAndView modelAndView = new ModelAndView("fullCustomersInfo");
        int id = customerInfo.getCustomerid();
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/cancelContactAction")
    public ModelAndView cancelContactAction(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("fullCustomersInfo");
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/deleteContactAction")
    public ModelAndView deleteContactAction(@RequestParam int rowid){
        int id = service
                .getCustomerInfoById(rowid)
                .getCustomerid();
        service.deleteContact(rowid);
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/updateContactForm")
    public ModelAndView updateContactForm(@RequestParam int rowid){
        ModelAndView modelAndView = new ModelAndView("updateContact");
        CustomerInfo customerInfo = service.getCustomerInfoById(rowid);
        modelAndView.getModelMap().addAttribute("contact", customerInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/updateContactAction")
    public ModelAndView updateContactAction(@ModelAttribute CustomerInfo contact){
        contact.setCustomersByCustomerid(service.getCustomerById(contact.getCustomerid()));
        service.updateContact(contact);
        int id = contact.getCustomerid();
        Customer customer = service.getCustomerById(id);
        return makeFullCustomersInfoPage(customer);
    }

    @RequestMapping(value = "/regAction")
    public ModelAndView regAction(@ModelAttribute Action action, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ModelAndView("error");
        int id = action.getCustomerid();
        Customer customer = service.getCustomerById(id);
        action.setCustomersByCustomerid(customer);
        service.updateBill(customer, action);
        return makeFullCustomersInfoPage(customer);
    }

    public ModelAndView makeFullCustomersInfoPage(Customer customer){
        ModelAndView modelAndView = new ModelAndView("fullCustomersInfo");
        modelAndView.getModelMap().addAttribute("customer", customer);
        modelAndView.getModelMap().addAttribute("services", service.getAllServices());
        Action billAction = new Action();
        billAction.setCustomersByCustomerid(customer);
        billAction.setCustomerid(customer.getId());
        modelAndView.getModelMap().addAttribute("billAction", billAction);
        return modelAndView;
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
    public ModelAndView saveServiceAction(@ModelAttribute PhoneService phoneService,  BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ModelAndView("error");
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
    public ModelAndView updateServiceAction(@ModelAttribute PhoneService phoneService,  BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ModelAndView("error");
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
