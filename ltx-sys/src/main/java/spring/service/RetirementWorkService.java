package spring.service;

import spring.entity.RetirementWork;

public interface RetirementWorkService extends BaseService<RetirementWork>  {

    /**
     *重名验证
     * @param card
     * @return
     */
    RetirementWork selectWorks( String card);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteWoIds( Long [] ids);
}
