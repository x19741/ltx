package spring.service.oldOrganizationService;

import spring.entity.oldOrganization.RetirementActivity;
import spring.service.BaseService;

/**
 * @author 向加佳
 * @description
 * @date 13:48 2020/11/12
 **/
public interface RetirementActivityService extends BaseService<RetirementActivity> {
    /**
     * 删除
     * @param ids
     * @return
     */
    int deleteByIds1(int[] ids);
}
