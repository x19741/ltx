package spring.entity.oldOrganization;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author 向加佳
 * @Description 老年文艺团体-活动人员中间
 * @Date 10:40 2020/11/12
 **/
@Data
@Table(name="retirement_activityAndPeople")
public class RetirementActivityPeopleMiddle {

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
