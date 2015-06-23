package cn.javis.apms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.repository.EmployeePropertyRestrictionRepository;
import cn.javis.apms.server.domain.PropertyRestriction;
import cn.javis.apms.service.EmployeePropertyRestrictionService;

@Service
public class EmployeePropertyRestrictionServiceImpl implements EmployeePropertyRestrictionService {
    @Autowired
    private EmployeePropertyRestrictionRepository eePropertyRestrictionRepo;

    private Map<Long, PropertyRestriction> retrictionsMapById = new HashMap<Long, PropertyRestriction>();

    @Override
    public PropertyRestriction find(Long id) {
        if (retrictionsMapById.containsKey(id)) {
            return retrictionsMapById.get(id);
        } else {
            PropertyRestriction restriction = eePropertyRestrictionRepo.find(id);
            retrictionsMapById.put(id, restriction);
            return restriction;
        }
    }

    @Override
    public PropertyRestriction update(PropertyRestriction restriction) {
        restriction = eePropertyRestrictionRepo.update(restriction);
        retrictionsMapById.put(restriction.getId(), restriction);
        return restriction;
    }

    @Override
    public PropertyRestriction save(PropertyRestriction restriction) {
        Long id = eePropertyRestrictionRepo.save(restriction);
        restriction.setId(id);
        retrictionsMapById.put(id, restriction);
        return restriction;
    }

}
