package spring.service.impl.activityManagementImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.activityManagement.ActivityManagement;
import spring.mapper.activityManagementMapper.ActivityApplyMapper;
import spring.mappers.Mapper;
import spring.service.activityManagementService.ActivityApplyService;
import spring.service.impl.BaseServiceImpl;

import javax.annotation.Resource;

/**
 * @ClassName ActivityApplyServiceImpl
 * @Description
 * @Author 向加佳
 * @Date 2020/11/13 10:59
 */
@Service
@Transactional
public class ActivityApplyServiceImpl extends BaseServiceImpl<ActivityManagement> implements ActivityApplyService {

    @Resource
    private ActivityApplyMapper activityApplyMapper;


    @Override
    public Mapper<ActivityManagement> getMapper() {
        return activityApplyMapper;
    }
}
