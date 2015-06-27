package cn.javis.apms.server.service;

import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.service.exception.AuthorityInfoDuplicatedException;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;

public interface AuthorityInfoService {
    AuthorityInfo getUser(String usernameMd5) throws AuthorityInfoNotExistException;

    void createUser(AuthorityInfo authorityInfo) throws AuthorityInfoDuplicatedException;

    void updateUser(AuthorityInfo authorityInfo);

    void deleteUser(AuthorityInfo authorityInfo);

    // when parse data
    String getAccessKey(String usernameMd5) throws AuthorityInfoNotExistException;

    // when first log in
    void updateAccessKey(String usernameMd5, String newAccessKey) throws AuthorityInfoNotExistException;

}
