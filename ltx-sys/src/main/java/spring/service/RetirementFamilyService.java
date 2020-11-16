package spring.service;

import spring.entity.RetirementFamily;

public interface RetirementFamilyService extends BaseService<RetirementFamily>{

    /**
     * 重名验证
     * @param card
     * @return
     */
    RetirementFamily selectFamily(String card);

    /**
     *批量删除
     * @param ids
     * @return
     */
    int deleteFaIds(Long [] ids);
}
