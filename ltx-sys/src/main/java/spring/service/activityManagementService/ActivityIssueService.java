package spring.service.activityManagementService;

import spring.entity.activityManagement.ActivityManagement;
import spring.service.BaseService;

/**
 * @author 向加佳
 * @description
 * @date 16:52 2020/11/12
 **/
public interface ActivityIssueService extends BaseService<ActivityManagement> {

    /**
     * 删除
     * @param ids
     * @return
     */
    int deleteByIds1(int[] ids);
}
