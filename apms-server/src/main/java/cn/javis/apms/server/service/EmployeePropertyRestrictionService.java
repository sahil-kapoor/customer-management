package cn.javis.apms.server.service;

import cn.javis.apms.server.domain.PropertyRestriction;

public interface EmployeePropertyRestrictionService {

    PropertyRestriction find(Long id);

    PropertyRestriction update(PropertyRestriction restriction);

    PropertyRestriction save(PropertyRestriction restriction);

}
