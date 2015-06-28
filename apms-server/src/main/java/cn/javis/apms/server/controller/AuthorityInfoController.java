package cn.javis.apms.server.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.common.ApmsConst;
import cn.javis.apms.common.aes.AesEncrypt;
import cn.javis.apms.common.helper.StringHelper;
import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.helper.crypt.RandomTokenGenerator;
import cn.javis.apms.server.service.AuthorityInfoService;
import cn.javis.apms.server.service.exception.AuthorityInfoDuplicatedException;
import cn.javis.apms.server.service.exception.AuthorityInfoExpiredException;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;
import cn.javis.apms.server.service.exception.AuthorityInfoWrongPasswordException;

@RestController
@RequestMapping(value = "/authorityinfo", method = RequestMethod.GET)
public class AuthorityInfoController {
    @Autowired
    private AuthorityInfoService authorityInfoService;

    @RequestMapping(value = "/signup")
    public Map<String, String> signUp(@RequestParam(value = "username") String username,
            @RequestParam(value = "passwordMd5") String passwordMd5) throws AuthorityInfoDuplicatedException {

        AuthorityInfo authorityInfo = new AuthorityInfo();
        authorityInfo.setUsername(username);

        String usernameMd5 = StringHelper.toMd5(username);
        authorityInfo.setUsernameMd5(usernameMd5);

        authorityInfo.setPasswordMd5(passwordMd5);

        String randomKeyMd5 = StringHelper.toMd5(RandomTokenGenerator.generate());
        String accessKey = AesEncrypt.composeAccessKey(usernameMd5, randomKeyMd5, passwordMd5);
        authorityInfo.setAccessKey(accessKey);

        authorityInfoService.createUser(authorityInfo);

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ApmsConst.RANDOM_KEY, randomKeyMd5);
        return returnMap;
    }

    @RequestMapping(value = "/signin")
    public Map<String, String> signin(@RequestParam(value = "usernameMd5") String usernameMd5,
            @RequestParam(value = "passwordMd5") String passwordMd5) throws AuthorityInfoNotExistException,
            AuthorityInfoWrongPasswordException, AuthorityInfoExpiredException {

        AuthorityInfo authorityInfo;
        try {
            authorityInfo = authorityInfoService.getUser(usernameMd5);
        } catch (AuthorityInfoExpiredException e) {
            //tricky~~
            authorityInfo = authorityInfoService.getUser(usernameMd5);
        }
        if (!passwordMd5.equals(authorityInfo.getPasswordMd5())) {
            throw new AuthorityInfoWrongPasswordException();
        }

        String randomKeyMd5 = StringHelper.toMd5(RandomTokenGenerator.generate());
        String accessKey = AesEncrypt.composeAccessKey(usernameMd5, randomKeyMd5, passwordMd5);
        authorityInfo.setAccessKey(accessKey);
        authorityInfo.setAccessKeyLatest(LocalDateTime.now());
        authorityInfoService.updateUser(authorityInfo);

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ApmsConst.RANDOM_KEY, randomKeyMd5);
        return returnMap;
    }

}
