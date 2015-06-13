package cn.javis.giada.customer.service;

import org.springframework.stereotype.Component;

import cn.javis.giada.customer.service.interfaces.MessageService;

@Component
public class MessageServiceImpl implements MessageService {

    public String getMessage() {
        return "Hello World!";
    }

}
