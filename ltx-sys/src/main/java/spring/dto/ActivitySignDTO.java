package spring.dto;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName ActivitySignDTO
 * @Description 活动管理-活动签到搜索
 * @Author 向加佳
 * @Date 2020/11/13 19:12
 */
@Data
public class ActivitySignDTO {

    //活动ID
    private Long activityId;
    //活动名称
    private String activityName;
    //活动类型
    private String activityGenre;
    //活动开始时间
    private Date activityBeginDate;
    //活动结束时间
    private Date activityEndDate;
    //活动地址
    private String activityAddress;
    //报名数量
    private Long applyCount;
    //签到数量
    private Long signCount;

}
