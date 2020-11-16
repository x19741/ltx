package spring.service;

import spring.entity.RetirementRelation;

public interface RetirementRelationService extends BaseService<RetirementRelation> {

    int deleteRela(Long [] ids);
}
