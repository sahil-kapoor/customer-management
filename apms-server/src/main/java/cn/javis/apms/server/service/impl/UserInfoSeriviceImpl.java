package cn.javis.apms.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.common.ApmsErrorCode;
import cn.javis.apms.server.domain.crypt.UserInfo;
import cn.javis.apms.server.repository.UserInfoRepository;
import cn.javis.apms.server.service.UserInfoService;
import cn.javis.apms.server.service.exception.UserInfoDuplicatedException;
import cn.javis.apms.server.service.exception.UserInfoNotExistException;

@Service
public class UserInfoSeriviceImpl implements UserInfoService {

    final private UserInfoRepository userInfoRepository;

    Map<String, UserInfo> userInfoMapByName = new HashMap<String, UserInfo>();

    @Autowired
    public UserInfoSeriviceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
        for (UserInfo userInfo : userInfoRepository.fetchAll()) {
            userInfoMapByName.put(userInfo.getUsername(), userInfo);
        }
    }

    @Override
    public void createUser(UserInfo userInfo) throws UserInfoDuplicatedException {
        if (!isUserInfoValid(userInfo)) {
            throw new UserInfoDuplicatedException(ApmsErrorCode.USER_DUPLICATED);
        }
        userInfoRepository.save(userInfo);
        userInfoMapByName.put(userInfo.getUsername(), userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoRepository.update(userInfo);
        userInfoMapByName.put(userInfo.getUsername(), userInfo);

    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        userInfoRepository.delete(userInfo);
        userInfoMapByName.remove(userInfo.getUsername());
    }

    @Override
    public void updateAccessKey(String username, String newAccessKey) {
        UserInfo userInfo = userInfoMapByName.get(username);
        if (userInfo != null) {
            userInfo.setAccessKey(newAccessKey);
            userInfoRepository.update(userInfo);
        }
    }

    @Override
    public String getAccessKey(String username) throws UserInfoNotExistException {
        UserInfo userInfo = userInfoMapByName.get(username);
        if (userInfo != null) {
            return userInfo.getAccessKey();
        }
        throw new UserInfoNotExistException(ApmsErrorCode.USER_NOT_EXIST);
    }

    private boolean isUserInfoValid(UserInfo userInfo) {
        if (userInfo.getUsername() != null && userInfo.getUsernameMd5() != null && userInfo.getPasswordMd5() != null
                && userInfo.getAccessKey() != null) {
            if (userInfoMapByName.containsKey(userInfo.getUsername())) {
                return false;
            }
            return true;
        }
        return false;
    }

}
