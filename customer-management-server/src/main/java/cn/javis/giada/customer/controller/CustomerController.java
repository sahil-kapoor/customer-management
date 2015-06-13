package cn.javis.giada.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.giada.customer.controller.exception.CustomerNotFoundException;
import cn.javis.giada.customer.controller.exception.RestResponse;
import cn.javis.giada.customer.model.Customer;
import cn.javis.giada.customer.service.interfaces.CustomerService;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(final CustomerService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public/* @ResponseBody Customer */ResponseEntity<Customer> getCustomer(
			@PathVariable String id) throws CustomerNotFoundException {
		Customer customer = new Customer();
		customer.setId(id);
		service.fetchCustomer(customer);
		if (customer.getName() == null) {
			throw new CustomerNotFoundException(customer);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.PUT,consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody RestResponse saveCustomer(@RequestBody Customer customer) {
		return new RestResponse(customer, HttpStatus.CREATED);
	}
	
	
	

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody RestResponse customerNotFound(
			final CustomerNotFoundException exception) {
		return new RestResponse(exception.getCustomer(), HttpStatus.NOT_FOUND);
	}
}
