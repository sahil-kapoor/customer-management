package cn.javis.giada.customer.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessagePrinterManager {
    @Pointcut("execution(public void cn.javis.giada.customer.service.MessagePrinter.printMessage(..))")
    // @Pointcut("execution(public * *(..))")
    public void listen() {
    }

    @Before("listen()")
    public void beforeListen() {
        System.out.println("I know you are going to print!");
    }

    @After("listen()")
    public void afterListen() {
        System.out.println("I know you have finished printing!");
    }
}
