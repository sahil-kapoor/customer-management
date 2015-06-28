package cn.javis.apms.server.controller;

import java.util.List;

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
import cn.javis.apms.server.domain.Customer;
import cn.javis.apms.server.domain.UserInfo;
import cn.javis.apms.server.dto.ReturnInfo;
import cn.javis.apms.server.helper.AesCryptUtils;
import cn.javis.apms.server.service.AuthorityInfoService;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/customer")
public class CustomerInfoController {
    @Autowired
    private AuthorityInfoService authorityInfoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCustomerInfo(@RequestParam(value = "usernameMd5") String usernameMd5)
            throws AuthorityInfoNotExistException, JsonProcessingException, CryptionFailException,
            StringWrongFormatException {
        AuthorityInfo authoInfo = authorityInfoService.getUser(usernameMd5);
        UserInfo userInfo = authoInfo.getUserInfo();
        List<Customer> customers = userInfo.getCustomers();
        authorityInfoService.updateUser(authoInfo);
        return AesCryptUtils.encrypt(customers, authoInfo);
    }

    @RequestMapping(value = "/single", method = RequestMethod.POST)
    public ReturnInfo updateCustomerInfo(@RequestParam(value = "usernameMd5") String usernameMd5,
            @RequestBody String content) throws AuthorityInfoNotExistException, CryptionFailException,
            StringWrongFormatException {
        AuthorityInfo authoInfo = authorityInfoService.getUser(usernameMd5);
        UserInfo userInfo = authoInfo.getUserInfo();
        Customer customer = AesCryptUtils.decrypt(content, Customer.class, authoInfo);
        userInfo.addCustomer(customer);
        authorityInfoService.updateUser(authoInfo);
        return ReturnInfo.newInstance(ReturnCode.SUCCESS);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ReturnInfo updateCustomerInfoList(@RequestParam(value = "usernameMd5") String usernameMd5,
            @RequestBody String content) throws AuthorityInfoNotExistException, CryptionFailException,
            StringWrongFormatException {
        AuthorityInfo authoInfo = authorityInfoService.getUser(usernameMd5);
        UserInfo userInfo = authoInfo.getUserInfo();
        List<Customer> customers = AesCryptUtils.decryptList(content, Customer.class, authoInfo);
        userInfo.addCustomers(customers);
        authorityInfoService.updateUser(authoInfo);
        return ReturnInfo.newInstance(ReturnCode.SUCCESS);
    }
}
