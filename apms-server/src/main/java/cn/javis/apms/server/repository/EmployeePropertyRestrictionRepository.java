package cn.javis.apms.server.repository;

import cn.javis.apms.server.domain.PropertyRestriction;

public interface EmployeePropertyRestrictionRepository {

    PropertyRestriction find(Long ids);

    Long save(PropertyRestriction restriction);

    PropertyRestriction update(PropertyRestriction restriction);



}
