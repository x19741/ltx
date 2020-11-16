package spring.mapper.activityManagementMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.activityManagement.ActivityManagementPeople;
import spring.mappers.Mapper;

import java.util.List;

/**
 * @author 向加佳
 * @description 活动管理-活动人员
 * @date 13:36 2020/11/13
 **/
public interface ActivityManagementPeopleMapper extends Mapper<ActivityManagementPeople> {

    /**增加人员信息
     *
     * @param items
     * @return
     */
    int addPeople(ActivityManagementPeople items);

    /**
     * 批量删除人员信息
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);

    /**
     * 根据活动ID查询人员信息
     * @param activityId
     * @return
     * @param pageSize
     * @param pageNumber
     */
    List<ActivityManagementPeople> selectByPrimaryKey1(@Param("activityId") Integer activityId,
                                                       @Param("pageSize") Integer pageSize,
                                                       @Param("pageNumber") Integer pageNumber);

    ActivityManagementPeople count(@Param("activityId") Integer activityId);
}
