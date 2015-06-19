package cn.javis.apms.repository;

import cn.javis.apms.domain.PropertyRestriction;

public interface EmployeePropertyRestrictionRepository {

    PropertyRestriction find(Long ids);

    Long save(PropertyRestriction restriction);

    PropertyRestriction update(PropertyRestriction restriction);



}
