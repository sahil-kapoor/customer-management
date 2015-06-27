package cn.javis.apms.server.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.common.ReturnCode;
import cn.javis.apms.common.aes.exception.CryptionFailException;
import cn.javis.apms.common.helper.exception.StringWrongFormatException;
import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.domain.UserInfo;
import cn.javis.apms.server.dto.ReturnInfo;
import cn.javis.apms.server.helper.AesEncryptUtils;
import cn.javis.apms.server.service.AuthorityInfoService;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;

@RestController
@RequestMapping(value = "/userinfo")
public class UserInfoController {
    @Autowired
    private AuthorityInfoService authorityService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam(value = "usernameMd5") String usernameMd5)
            throws AuthorityInfoNotExistException, IOException, CryptionFailException, StringWrongFormatException {
        AuthorityInfo authoInfo = authorityService.getUser(usernameMd5);
        UserInfo userInfo = authoInfo.getUserInfo();
        String result = AesEncryptUtils.encrypt(userInfo, authoInfo);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ReturnInfo updateUserInfo(@RequestParam(value = "usernameMd5") String usernameMd5,
            @RequestBody String content) throws AuthorityInfoNotExistException, IOException, CryptionFailException, StringWrongFormatException {
        AuthorityInfo authoInfo = authorityService.getUser(usernameMd5);
        UserInfo oldUserInfo = authoInfo.getUserInfo();
        UserInfo userInfo = AesEncryptUtils.decrypt(content, UserInfo.class, authoInfo);
        oldUserInfo.update(userInfo);
        authorityService.updateUser(authoInfo);
        return new ReturnInfo(ReturnCode.SUCCESS);
    }
}
