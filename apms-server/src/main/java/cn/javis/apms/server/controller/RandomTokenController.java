package cn.javis.apms.server.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.server.helper.crypt.RandomTokenGenerator;

@RestController
@RequestMapping(value = "/token", method = RequestMethod.GET)
public class RandomTokenController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, String> getRandomToken(@RequestParam(value = "username") String usernameMd5) {
        String randomToken = RandomTokenGenerator.generate();
        String username = "test";
        Map<String, String> result = new HashMap<String, String>();
        result.put(username, randomToken);
        return result;

    }
}
