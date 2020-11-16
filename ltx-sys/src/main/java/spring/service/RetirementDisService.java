package spring.service;

import spring.entity.RetirementDis;

public interface RetirementDisService extends BaseService<RetirementDis> {

    RetirementDis selectWithout(String card);

    int deleteDiIdss(Long [] ids);

    int addw(Long dis);

    RetirementDis selectOnes(Long ids);

    int alter (RetirementDis change);
}
