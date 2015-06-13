package cn.javis.giada.customer.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerManager {
    @Pointcut("execution(public * cn.javis.giada.customer.controller.CustomerController.*(..))")
    public void listen() {

    }

    @Before("listen()")
    public void beforeListen() {
        System.out.println("I know you are going to query!");
    }

    @After("listen()")
    public void afterListen() {
        System.out.println("I know you have finished querying!");
    }

}
