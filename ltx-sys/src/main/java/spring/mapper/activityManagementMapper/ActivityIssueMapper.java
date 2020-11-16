package spring.mapper.activityManagementMapper;

import spring.entity.activityManagement.ActivityManagement;
import spring.mappers.Mapper;

/**
 * @author 向加佳
 * @description
 * @date 16:49 2020/11/12
 **/
public interface ActivityIssueMapper extends Mapper<ActivityManagement> {

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteDsIds(int []ids);

}
