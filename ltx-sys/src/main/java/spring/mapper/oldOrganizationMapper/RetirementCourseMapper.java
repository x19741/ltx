package spring.mapper.oldOrganizationMapper;

import spring.entity.oldOrganization.RetirementCourse;
import spring.mappers.Mapper;

/**
 * @author 向加佳
 * @description
 * @date 15:26 2020/11/12
 **/
public interface RetirementCourseMapper  extends Mapper<RetirementCourse> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);

}
