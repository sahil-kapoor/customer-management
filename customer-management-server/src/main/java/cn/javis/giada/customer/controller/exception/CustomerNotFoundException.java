package cn.javis.giada.customer.controller.exception;

import org.springframework.http.HttpStatus;

import cn.javis.giada.customer.model.Customer;

public class CustomerNotFoundException extends Exception{
	private final HttpStatus errorCode = HttpStatus.NOT_FOUND;
	private final Customer customer;
	public CustomerNotFoundException(final Customer customer) {
		this.customer = customer;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public Customer getCustomer() {
		return customer;
	}
}
