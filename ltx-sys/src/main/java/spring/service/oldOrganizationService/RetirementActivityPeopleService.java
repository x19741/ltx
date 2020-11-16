package spring.service.oldOrganizationService;

import spring.entity.oldOrganization.RetirementActivityPeople;
import spring.service.BaseService;

import java.util.List;

/**
 * @author chen
 */
public interface RetirementActivityPeopleService extends BaseService<RetirementActivityPeople> {
    /**
     * 根据活动ID查询人员信息
     * @param activityId
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<RetirementActivityPeople> selectByPrimaryKey1(Integer activityId, Integer pageSize, Integer pageNumber);

    /**
     * 根据活动ID增加人员信息
     * @param items
     * @param activityId
     * @return
     */
    boolean addPeople(RetirementActivityPeople items, Integer activityId);


    /**
     * 根据活动ID删除人员信息
     * @param ids
     * @param activityId
     * @return
     */
    boolean deleteByIds1(int[] ids, Integer activityId);
}
