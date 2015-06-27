package cn.javis.apms.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.repository.AuthorityInfoRepository;
import cn.javis.apms.server.service.AuthorityInfoService;
import cn.javis.apms.server.service.exception.AuthorityInfoDuplicatedException;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;

@Service
public class AuthorityInfoSeriviceImpl implements AuthorityInfoService {

    final private AuthorityInfoRepository userInfoRepository;

    Map<String, AuthorityInfo> userInfoMapByUsernameMd5 = new HashMap<String, AuthorityInfo>();

    @Autowired
    public AuthorityInfoSeriviceImpl(AuthorityInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
        for (AuthorityInfo authorityInfo : userInfoRepository.fetchAll()) {
            userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);
        }
    }

    @Override
    public void createUser(AuthorityInfo authorityInfo) throws AuthorityInfoDuplicatedException {
        if (!isUserInfoValid(authorityInfo)) {
            throw new AuthorityInfoDuplicatedException();
        }
        userInfoRepository.save(authorityInfo);
        userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);
    }

    @Override
    public void updateUser(AuthorityInfo authorityInfo) {
        userInfoRepository.update(authorityInfo);
        userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);

    }

    @Override
    public void deleteUser(AuthorityInfo authorityInfo) {
        userInfoRepository.delete(authorityInfo);
        userInfoMapByUsernameMd5.remove(authorityInfo.getUsernameMd5());
    }

    @Override
    public void updateAccessKey(String usernameMd5, String newAccessKey) throws AuthorityInfoNotExistException {
        AuthorityInfo authorityInfo = getUser(usernameMd5);
        authorityInfo.setAccessKey(newAccessKey);
        userInfoRepository.update(authorityInfo);
    }

    @Override
    public String getAccessKey(String usernameMd5) throws AuthorityInfoNotExistException {
        AuthorityInfo authorityInfo = getUser(usernameMd5);
        return authorityInfo.getAccessKey();
    }

    private boolean isUserInfoValid(AuthorityInfo authorityInfo) {
        if (authorityInfo.getUsername() != null && authorityInfo.getUsernameMd5() != null && authorityInfo.getPasswordMd5() != null
                && authorityInfo.getAccessKey() != null) {
            if (userInfoMapByUsernameMd5.containsKey(authorityInfo.getUsernameMd5())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public AuthorityInfo getUser(String usernameMd5) throws AuthorityInfoNotExistException {
        AuthorityInfo authorityInfo = userInfoMapByUsernameMd5.get(usernameMd5);
        if (authorityInfo != null) {
            return authorityInfo;
        }
        throw new AuthorityInfoNotExistException();

    }
}
