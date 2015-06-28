package cn.javis.apms.server.repository;

import java.util.List;

import cn.javis.apms.server.domain.AuthorityInfo;

public interface AuthorityInfoRepository {

    void save(AuthorityInfo authorityInfo);

    AuthorityInfo update(AuthorityInfo authorityInfo);

    void delete(AuthorityInfo authorityInfo);

    List<AuthorityInfo> fetchAll();
}
