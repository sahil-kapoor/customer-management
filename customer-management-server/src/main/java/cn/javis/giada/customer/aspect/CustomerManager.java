package cn.javis.giada.customer.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.javis.giada.customer.controller.exception.CustomerNotFoundException;
import cn.javis.giada.customer.model.AspectCheckResult;
import cn.javis.giada.customer.model.Customer;

@Aspect
@Component
public class CustomerManager {
    @Autowired
    private AspectCheckResult checkResult;
    
    @Pointcut("execution(public * cn.javis.giada.customer.controller.CustomerController.getCustomer(..))")
    public void getCustomer() {

    }

    @Pointcut("execution(public * cn.javis.giada.customer.controller.CustomerController.saveCustomer(..)) && args(customer)")
    // @Pointcut("execution(** cn.javis.giada.customer.dao.CustomerQueryDao.*(..))")
    // @Pointcut("execution(* cn.javis.giada.customer.dao.BasicQueryDao.*(..))")
    public void saveCustomer(Customer customer) {

    }

    @Before("getCustomer()")
    public void beforeListen() {
        System.out.println("I know you are going to query!");

    }

    @After("getCustomer()")
    public void afterListen() {
        System.out.println("I know you have finished querying!");
    }

    @Before("saveCustomer(customer)")
    public void beforesaveCustomer(Customer customer)
            throws CustomerNotFoundException {
        System.out.println("I know you are going to save "+customer.getId()+" !");
        if(customer.getId().equals("abc")) {
            checkResult.setStatuCode(-1);
        }
        
//        throw new CustomerNotFoundException(customer);

    }

    @After("saveCustomer(customer)")
    public void aftersaveCustomer(Customer customer) {
        System.out.println("I know you have finished saving!");
    }

}
