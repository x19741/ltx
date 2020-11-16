package spring.service;

import spring.entity.RetirementParty;

public interface RetirementPartyService extends BaseService<RetirementParty> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deletePaIds(Long []ids);

    /**
     * 教工卡号重命名
     * @param card
     * @return
     */
    RetirementParty selectParty (String card);
}
