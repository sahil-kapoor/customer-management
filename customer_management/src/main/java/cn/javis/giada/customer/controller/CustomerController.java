package cn.javis.giada.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.javis.giada.customer.model.Customer;
import cn.javis.giada.customer.service.interfaces.CustomerService;

@Controller
@RequestMapping
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(final CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer(@PathVariable String id) {
        Customer customer = new Customer();
        customer.setId(id);
        service.fetchCustomer(customer);
        return customer;
    }
}
