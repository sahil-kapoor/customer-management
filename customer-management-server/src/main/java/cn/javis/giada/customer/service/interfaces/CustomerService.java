package cn.javis.giada.customer.service.interfaces;

import cn.javis.giada.customer.model.Customer;

public interface CustomerService {
    void fetchCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
