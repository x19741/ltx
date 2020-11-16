package spring.entity.activityManagement;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName ActivityManagementPeople
 * @Description 活动管理-人员
 * @Author 向加佳
 * @Date 2020/11/13 13:27
 */
@Data
@Table(name="retirement_activityManagement_people")
public class ActivityManagementPeople {

    //报名数量
    private Long applyCount;



    @Id
    @Column(name = "people_id")
    private int peopleId;

    @Column(name = "people_name")
    @ApiModelProperty(value = "人员姓名")
    private String peopleName;

    @Column(name = "people_sex")
    @ApiModelProperty(value = "性别")
    private int peopleSex;

    @Column(name = "people_cardNumber")
    @ApiModelProperty(value = "教工卡号")
    private String peopleCardNumber;

    @Column(name = "people_job")
    @ApiModelProperty(value = "职务")
    private String peopleJob;

    @Column(name = "people_class")
    @ApiModelProperty(value = "职级")
    private String peopleClass;

    @Column(name = "people_jobName")
    @ApiModelProperty(value = "职称")
    private String peopleJobName;

    @Column(name = "people_work")
    @ApiModelProperty(value = "原工作单位")
    private String peopleWork;

    @Column(name = "people_phone")
    @ApiModelProperty(value = "联系方式")
    private String peoplePhone;

    @Column(name = "people_identity")
    @ApiModelProperty(value = "身份证")
    private String peopleIdentity;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "people_beginDate")
    @ApiModelProperty(value="活动开始日期 ")
    private Date peopleBeginDate ;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "people_endDate")
    @ApiModelProperty(value="活动结束日期")
    private Date peopleEndDate ;

    @Column(name = "people_status")
    @ApiModelProperty(value = "人员状态")
    private String peopleStatus;
}
