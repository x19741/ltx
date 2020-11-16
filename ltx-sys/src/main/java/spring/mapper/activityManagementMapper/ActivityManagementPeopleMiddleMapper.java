package spring.mapper.activityManagementMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.activityManagement.ActivityManagementPeople;

/**
 * @author 向加佳
 * @description 活动发布-活动发布与活动人员-中间
 * @date 13:45 2020/11/13
 **/
public interface ActivityManagementPeopleMiddleMapper {
    /**
     * 增加中间表ID
     * @param activityId
     * @param items
     * @return
     */
    int addId(Integer activityId, ActivityManagementPeople items);


    /**
     * 批量删除
     * @param activityId
     * @param ids
     * @return
     */
    int deleteId(Integer activityId,@Param("array") int[] ids);
}
