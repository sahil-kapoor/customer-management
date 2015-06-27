package cn.javis.apms.server.repository;

import java.util.List;

import cn.javis.apms.server.domain.crypt.UserInfo;

public interface UserInfoRepository {

    void save(UserInfo userInfo);

    void update(UserInfo userInfo);

    void delete(UserInfo userInfo);

    List<UserInfo> fetchAll();
}
