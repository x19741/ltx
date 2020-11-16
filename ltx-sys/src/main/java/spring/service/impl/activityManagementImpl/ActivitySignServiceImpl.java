package spring.service.impl.activityManagementImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dto.ActivitySignDTO;
import spring.entity.activityManagement.ActivityManagement;
import spring.mapper.activityManagementMapper.ActivitySignMapper;
import spring.service.activityManagementService.ActivitySignService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ActivitySignServiceImpl
 * @Description 活动管理-活动签到
 * @Author 向加佳
 * @Date 2020/11/13 15:34
 */
@Service
@Transactional
public class ActivitySignServiceImpl implements ActivitySignService {

    @Resource
    private ActivitySignMapper activitySignMapper;

    @Override
    public List<ActivitySignDTO> selectSign(List<ActivityManagement> activity, Integer pageNumber, Integer pageSize) {
        return activitySignMapper.selectSign(activity,pageNumber,pageSize);
    }
}
