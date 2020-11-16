package spring.service.impl.activityManagementImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.activityManagement.ActivityManagement;
import spring.mapper.activityManagementMapper.ActivityIssueMapper;
import spring.mappers.Mapper;
import spring.service.activityManagementService.ActivityIssueService;
import spring.service.impl.BaseServiceImpl;

import javax.annotation.Resource;

/**
 * @ClassName ActivityIssueServiceImpl
 * @Description
 * @Author 向加佳
 * @Date 2020/11/12 16:53
 */
@Service
@Transactional
public class ActivityIssueServiceImpl extends BaseServiceImpl<ActivityManagement> implements ActivityIssueService {

    @Resource
    private ActivityIssueMapper activityIssueMapper;

    @Override
    public Mapper<ActivityManagement> getMapper() {
        return activityIssueMapper;
    }

    @Override
    public int deleteByIds1(int[] ids) {
        return activityIssueMapper.deleteDsIds(ids);
    }
}
