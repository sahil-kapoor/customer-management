package cn.javis.apms.server.controller;

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
import cn.javis.apms.server.domain.crypt.UserInfo;
import cn.javis.apms.server.helper.crypt.RandomTokenGenerator;
import cn.javis.apms.server.service.UserInfoService;
import cn.javis.apms.server.service.exception.UserInfoDuplicatedException;

@RestController
@RequestMapping(value = "/signup", method = RequestMethod.GET)
public class SignUpController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "")
    public Map<String, String> signUp(@RequestParam(value = "username") String username,
            @RequestParam(value = "passwordMd5") String passwordMd5) throws UserInfoDuplicatedException {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);

        String usernameMd5 = StringHelper.toMd5(username);
        userInfo.setUsernameMd5(usernameMd5);

        userInfo.setPasswordMd5(passwordMd5);

        String randomKeyMd5 = StringHelper.toMd5(RandomTokenGenerator.generate());
        String accessKey = AesEncrypt.composeAccessKey(usernameMd5, randomKeyMd5, passwordMd5);
        userInfo.setAccessKey(accessKey);

        userInfoService.createUser(userInfo);

        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put(ApmsConst.ACCESS_KEY, randomKeyMd5);
        return returnMap;
    }
}
