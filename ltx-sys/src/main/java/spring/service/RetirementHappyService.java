package spring.service;

import spring.entity.RetirementHappy;

public interface RetirementHappyService  extends BaseService<RetirementHappy>{
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteHaIds(Long []ids);

    RetirementHappy selectFete(String card);
}
