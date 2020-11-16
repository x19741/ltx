package spring.service;

import spring.entity.RetirementProvide;
import spring.util.ReType;

public interface RetirementProvideService extends BaseService<RetirementProvide> {
    ReType getUnderways(RetirementProvide item, Integer pageNumber, Integer pageSize);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deletePrIdss(Long [] ids);

    RetirementProvide selectOld( String card);
}
