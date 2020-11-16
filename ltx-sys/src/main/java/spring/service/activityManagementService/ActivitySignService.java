package spring.service.activityManagementService;

import spring.dto.ActivitySignDTO;
import spring.entity.activityManagement.ActivityManagement;

import java.util.List;

/**
 * @author 向加佳
 * @description 活动管理-活动签到
 * @date 15:33 2020/11/13
 **/
public interface ActivitySignService {
    /**
     * 查询活动管理-活动签到
     * @param activityId
     * @param pageNumber
     * @param pageSize
     * @return
     **/
    List<ActivitySignDTO> selectSign(List<ActivityManagement> activity, Integer pageNumber, Integer pageSize);
}
