package spring.service.impl.activityManagementImpl;

import spring.entity.activityManagement.ActivityManagementSummarize;
import spring.mapper.activityManagementMapper.ActivityManagementSummarizeMapper;
import spring.mappers.Mapper;
import spring.service.activityManagementService.ActivityManagementSummarizeService;
import spring.service.impl.BaseServiceImpl;

import javax.annotation.Resource;

/**
 * @ClassName ActivityManagementSummarizeServiceImpl
 * @Description 活动管理-活动总结
 * @Author 向加佳
 * @Date 2020/11/14 11:42
 */
public class ActivityManagementSummarizeServiceImpl extends BaseServiceImpl<ActivityManagementSummarize> implements ActivityManagementSummarizeService {

    @Resource
    private ActivityManagementSummarizeMapper activityManagementSummarizeMapper;

    @Override
    public Mapper<ActivityManagementSummarize> getMapper() {
        return activityManagementSummarizeMapper;
    }

 /*   @Override
    public List<RetirementActivityPeople> selectByPrimaryKey1(Integer activityId, Integer pageSize, Integer pageNumber) {
        return null;
    }*/
}
