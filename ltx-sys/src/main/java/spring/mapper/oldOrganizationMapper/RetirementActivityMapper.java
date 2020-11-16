package spring.mapper.oldOrganizationMapper;

import spring.entity.oldOrganization.RetirementActivity;
import spring.mappers.Mapper;

/**
 * @Author 向加佳
 * @Date 10:45 2020/11/12
 **/
public interface RetirementActivityMapper extends Mapper<RetirementActivity> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);
}
