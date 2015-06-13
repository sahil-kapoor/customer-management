package cn.javis.giada.customer.controller.exception;

import org.springframework.http.HttpStatus;

import cn.javis.giada.customer.model.Customer;

public class RestResponse {
	private final HttpStatus status;
	private final Customer customer;
	public RestResponse(Customer customer,HttpStatus status) {
		this.status=status;
		this.customer=customer;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public Customer getCustomer() {
		return customer;
	}
			

}
