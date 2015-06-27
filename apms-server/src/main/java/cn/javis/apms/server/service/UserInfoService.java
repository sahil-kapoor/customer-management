package cn.javis.apms.server.service;

import cn.javis.apms.server.domain.crypt.UserInfo;
import cn.javis.apms.server.service.exception.UserInfoDuplicatedException;
import cn.javis.apms.server.service.exception.UserInfoNotExistException;

public interface UserInfoService {

    void createUser(UserInfo userInfo) throws UserInfoDuplicatedException;

    void updateUser(UserInfo userInfo);

    void deleteUser(UserInfo userInfo);

    // when parse data
    String getAccessKey(String username) throws UserInfoNotExistException;

    // when first log in
    void updateAccessKey(String username, String newAccessKey);

}
