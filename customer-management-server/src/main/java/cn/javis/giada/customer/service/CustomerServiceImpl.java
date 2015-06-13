package cn.javis.giada.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.javis.giada.customer.dao.CustomerQueryDao;
import cn.javis.giada.customer.model.Customer;
import cn.javis.giada.customer.service.interfaces.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerQueryDao customerQueryDao;
//    private BasicQueryDao<Customer> customerQueryDao;

    // public CustomerServiceImpl(CustomerQueryDao customerQueryDao) {
    // this.customerQueryDao = customerQueryDao;
    // }

    public void fetchCustomer(Customer customer) {
        List<Customer> results = customerQueryDao.query(customer);
        if(!results.isEmpty()) {
            customer.copy(results.get(0));
        }
        System.out.println("fetchCustomer " + customer.getName());
    }

    public void updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        System.out.println("updateCustomer " + customer.getId());

    }

}
