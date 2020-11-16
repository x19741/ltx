package spring.mapper.oldOrganizationMapper;

import org.apache.ibatis.annotations.Param;
import spring.entity.oldOrganization.RetirementActivityPeople;
import spring.mappers.Mapper;

import java.util.List;

/**
 * @author 向加佳
 * @description
 * @date 15:06 2020/11/12
 **/
public interface RetirementActivityPeopleMapper extends Mapper<RetirementActivityPeople> {

    /**
     * 根据活动ID查询人员信息
     * @param activityId
     * @return
     * @param pageSize
     * @param pageNumber
     */
    List<RetirementActivityPeople> selectByPrimaryKey1(@Param("activityId") Integer activityId,
                                                       @Param("pageSize") Integer pageSize,
                                                       @Param("pageNumber") Integer pageNumber);

    /**增加人员信息
     *
     * @param items
     * @return
     */
    int addPeople(RetirementActivityPeople items);

    /**
     * 批量删除人员信息
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);
}
