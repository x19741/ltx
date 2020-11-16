package spring.service.activityManagementService;

import spring.entity.activityManagement.ActivityManagementPeople;
import spring.service.BaseService;

import java.util.List;

/**
 * @author 向加佳
 * @description 活动管理-活动人员
 * @date 13:32 2020/11/13
 **/
public interface ActivityManagementPeopleService extends BaseService<ActivityManagementPeople> {
    /**
     * 根据活动ID增加人员信息
     * @param items
     * @param activityId
     * @return
     */
    boolean addPeople(ActivityManagementPeople items, Integer activityId);

    /**
     * 根据活动ID删除人员信息
     * @param ids
     * @param activityId
     * @return
     */
    boolean deleteByIds1(int[] ids, Integer activityId);

    /**
     * 根据活动ID查询人员信息
     * @param activityId
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<ActivityManagementPeople> selectByPrimaryKey1(Integer activityId, Integer pageSize, Integer pageNumber);
}
