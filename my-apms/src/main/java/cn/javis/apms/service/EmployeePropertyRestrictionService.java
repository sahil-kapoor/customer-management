package cn.javis.apms.service;

import cn.javis.apms.domain.PropertyRestriction;

public interface EmployeePropertyRestrictionService {

    PropertyRestriction find(Long id);

    PropertyRestriction update(PropertyRestriction restriction);

    PropertyRestriction save(PropertyRestriction restriction);

}
