package spring.entity.activityManagement;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName ActivityManagementPeopleMiddle
 * @Description 活动管理-活动发布与活动人员-中间
 * @Author 向加佳
 * @Date 2020/11/13 13:43
 */
@Data
@Table(name="retirement_activityManagementAndPeople")
public class ActivityManagementPeopleMiddle {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "activity_id")
    @ApiModelProperty(value = "活动ID")
    private int activityId;

    @Column(name = "people_id")
    @ApiModelProperty(value = "人员ID")
    private int peopleId;
}
