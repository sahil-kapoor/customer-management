package cn.javis.apms.server.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.repository.AuthorityInfoRepository;
import cn.javis.apms.server.service.AuthorityInfoService;
import cn.javis.apms.server.service.exception.AuthorityInfoDuplicatedException;
import cn.javis.apms.server.service.exception.AuthorityInfoExpiredException;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;

@Service
public class AuthorityInfoSeriviceImpl implements AuthorityInfoService {

    final private AuthorityInfoRepository authoInfoRepository;
    private final long ACCESS_KEY_EXPIRE_SECOND = 3;

    Map<String, AuthorityInfo> userInfoMapByUsernameMd5 = new HashMap<String, AuthorityInfo>();

    @Autowired
    public AuthorityInfoSeriviceImpl(AuthorityInfoRepository userInfoRepository) {
        this.authoInfoRepository = userInfoRepository;
        for (AuthorityInfo authorityInfo : userInfoRepository.fetchAll()) {
            userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);
        }
    }

    @Override
    public void createUser(AuthorityInfo authorityInfo) throws AuthorityInfoDuplicatedException {
        if (!isUserInfoValid(authorityInfo)) {
            throw new AuthorityInfoDuplicatedException();
        }
        authoInfoRepository.save(authorityInfo);
        userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);
    }

    @Override
    public AuthorityInfo updateUser(AuthorityInfo authorityInfo) {
        authorityInfo = authoInfoRepository.update(authorityInfo);
        userInfoMapByUsernameMd5.put(authorityInfo.getUsernameMd5(), authorityInfo);
        return authorityInfo;

    }

    @Override
    public void deleteUser(AuthorityInfo authorityInfo) {
        authoInfoRepository.delete(authorityInfo);
        userInfoMapByUsernameMd5.remove(authorityInfo.getUsernameMd5());
    }

    @Override
    public void updateAccessKey(String usernameMd5, String newAccessKey) throws AuthorityInfoNotExistException,
            AuthorityInfoExpiredException {
        AuthorityInfo authorityInfo = getUser(usernameMd5);
        authorityInfo.setAccessKey(newAccessKey);
        authoInfoRepository.update(authorityInfo);
    }

    @Override
    public String getAccessKey(String usernameMd5) throws AuthorityInfoNotExistException, AuthorityInfoExpiredException {
        AuthorityInfo authorityInfo = getUser(usernameMd5);
        return authorityInfo.getAccessKey();
    }

    private boolean isUserInfoValid(AuthorityInfo authorityInfo) {
        if (authorityInfo.getUsername() != null && authorityInfo.getUsernameMd5() != null
                && authorityInfo.getPasswordMd5() != null && authorityInfo.getAccessKey() != null) {
            if (userInfoMapByUsernameMd5.containsKey(authorityInfo.getUsernameMd5())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public AuthorityInfo getUser(String usernameMd5) throws AuthorityInfoNotExistException,
            AuthorityInfoExpiredException {
        AuthorityInfo authorityInfo = userInfoMapByUsernameMd5.get(usernameMd5);
        if (authorityInfo != null) {
            LocalDateTime lastAccesss = authorityInfo.getAccessKeyLatest();
            if (lastAccesss != null
                    && lastAccesss.plusSeconds(ACCESS_KEY_EXPIRE_SECOND).compareTo(LocalDateTime.now()) < 0) {
                authorityInfo.setAccessKeyLatest(null);
                authorityInfo = updateUser(authorityInfo);
                throw new AuthorityInfoExpiredException();
            }
            authorityInfo.setAccessKeyLatest(LocalDateTime.now());
            authorityInfo = updateUser(authorityInfo);
            return authorityInfo;
        }
        throw new AuthorityInfoNotExistException();
    }
}
