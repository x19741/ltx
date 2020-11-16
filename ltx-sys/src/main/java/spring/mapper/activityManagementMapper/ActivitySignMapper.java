package spring.mapper.activityManagementMapper;

import org.apache.ibatis.annotations.Param;
import spring.dto.ActivitySignDTO;
import spring.entity.activityManagement.ActivityManagement;

import java.util.List;

/**
 * @author 向加佳
 * @description
 * @date 15:37 2020/11/13
 **/
public interface ActivitySignMapper {
    /**
     * 查询活动管理-活动签到
     * @param activityId
     * @param pageNumber
     * @param pageSize
     * @return
     **/
    List<ActivitySignDTO> selectSign(@Param("array") List<ActivityManagement> activity, Integer pageNumber, Integer pageSize);
}
