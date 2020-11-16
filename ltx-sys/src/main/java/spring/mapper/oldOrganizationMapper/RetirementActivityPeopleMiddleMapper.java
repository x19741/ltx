package spring.mapper.oldOrganizationMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.oldOrganization.RetirementActivityPeople;

/**
 * @Author 向加佳
 * @Date 10:53 2020/11/12
 **/
public interface RetirementActivityPeopleMiddleMapper {

    /**
     * 增加中间表ID
     * @param activityId
     * @param items
     * @return
     */
    int addId(Integer activityId,RetirementActivityPeople items);


    /**
     * 批量删除
     * @param activityId
     * @param ids
     * @return
     */
    int deleteId(Integer activityId,@Param("array") int[] ids);
}
