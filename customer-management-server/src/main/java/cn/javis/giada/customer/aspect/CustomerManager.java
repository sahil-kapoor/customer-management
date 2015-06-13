package cn.javis.giada.customer.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerManager {
    @Pointcut("execution(public * cn.javis.giada.customer.controller.CustomerController.getCustomer(..))")
    public void getCustomer() {

    }
    
//    @Pointcut("execution(public * cn.javis.giada.customer.controller.CustomerController.saveCustomer(..))")
//    @Pointcut("execution(* cn.javis.giada.customer.dao.CustomerQueryDao.*(..))")
    @Pointcut("execution(* cn.javis.giada.customer.dao.BasicQueryDao.*(..))")
    public void saveCustomer() {

    }

    @Before("getCustomer()")
    public void beforeListen() {
        System.out.println("I know you are going to query!");
        
    }

    @After("getCustomer()")
    public void afterListen() {
        System.out.println("I know you have finished querying!");
    }
    
    @Before("saveCustomer()")
    public void beforesaveCustomer() {
        System.out.println("I know you are going to save!");
        
    }

    @After("saveCustomer()")
    public void aftersaveCustomer() {
        System.out.println("I know you have finished saving!");
    }

}
