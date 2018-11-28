package com.longhoang.springallofmodule2.controllers;

import com.longhoang.springallofmodule2.models.Customer;
import com.longhoang.springallofmodule2.services.CustomerService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView listCustomer(@PageableDefault(value = 5)Pageable pageable, @RequestParam("nameSearch") Option<String> s) {
        Page<Customer> customers = customerService.findAll(pageable);
        if (s.isPresent())
        return new ModelAndView("/customer/list", "customers", customers);
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/customer/create", "customer", new Customer());
    }

    @PostMapping("/customer/create")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create", "customer", customer);
        modelAndView.addObject("message", "Created successfully");
        return modelAndView;
    }

    @GetMapping("/customer-edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        return new ModelAndView("/customer/edit", "customer", customerService.findById(id));
    }

    @PostMapping("/customer-edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit", "message", "Updated successfully");
        modelAndView.addObject("customer", customer);
        customerService.save(customer);
        return modelAndView;
    }

    @GetMapping("/customer-delete/{id}")
    public ModelAndView showDeleteCustomerForm(@PathVariable("id") Long id) {
        return new ModelAndView("/customer/delete", "customer", customerService.findById(id));
    }

    @PostMapping("/customer-delete")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/delete", "customer", customer);
        modelAndView.addObject("message", "Deleted Successfully");
        return modelAndView;
    }

}
