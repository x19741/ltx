package spring.service.oldOrganizationService;

import spring.entity.oldOrganization.RetirementCourse;
import spring.service.BaseService;

/**
 * @author 向加佳
 * @description
 * @date 15:16 2020/11/12
 **/
public interface RetirementCourseService extends BaseService<RetirementCourse> {
    /**
     * 删除
     * @param ids
     * @return
     */
    int deleteByIds1(int[] ids);
}
