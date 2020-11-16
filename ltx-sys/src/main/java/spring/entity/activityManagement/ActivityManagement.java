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
 * @ClassName ActivityManagement
 * @Description 活动管理-活动
 * @Author 向加佳
 * @Date 2020/11/12 16:26
 */
@Data
@Table(name="retirement_activityManagement")
public class ActivityManagement {

    @Id
    @Column(name = "activity_id")
    private Long activityId;

    @Column(name = "activity_name")
    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @Column(name = "activity_number")
    @ApiModelProperty(value = "活动人数")
    private Long activityNumber;

    @Column(name = "activity_maxNumber")
    @ApiModelProperty(value = "活动人数上限")
    private Long activityMaxNumber;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate")
    @ApiModelProperty(value="活动开始日期")
    private Date activityBeginDate;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate")
    @ApiModelProperty(value="活动结束日期")
    private Date activityEndDate;

    @Column(name = "activity_content")
    @ApiModelProperty(value = "活动内容")
    private String activityContent;

    @Column(name = "activity_address")
    @ApiModelProperty(value = "活动地址")
    private String activityAddress;

    @Column(name = "activity_genre")
    @ApiModelProperty(value = "活动类型")
    private String activityGenre;

    @Column(name = "activity_workName")
    @ApiModelProperty(value = "工作人员姓名")
    private String activityWorkName;

    @Column(name = "activity_responsibility")
    @ApiModelProperty(value = "工作人员职责")
    private String activityResponsibility;

    @Column(name = "activity_workPhone")
    @ApiModelProperty(value = "工作人员联系电话")
    private String activityWorkPhone;

    @Column(name = "activity_workName1")
    @ApiModelProperty(value = "工作人员姓名")
    private String activityWorkName1;

    @Column(name = "activity_responsibility1")
    @ApiModelProperty(value = "工作人员职责")
    private String activityResponsibility1;

    @Column(name = "activity_workPhone1")
    @ApiModelProperty(value = "工作人员联系电话")
    private String activityWorkPhone1;

    @Column(name = "activity_workName2")
    @ApiModelProperty(value = "工作人员姓名")
    private String activityWorkName2;

    @Column(name = "activity_responsibility2")
    @ApiModelProperty(value = "工作人员职责")
    private String activityResponsibility2;

    @Column(name = "activity_workPhone2")
    @ApiModelProperty(value = "工作人员联系电话")
    private String activityWorkPhone2;

    @Column(name = "activity_workName3")
    @ApiModelProperty(value = "工作人员姓名")
    private String activityWorkName3;

    @Column(name = "activity_responsibility3")
    @ApiModelProperty(value = "工作人员职责")
    private String activityResponsibility3;

    @Column(name = "activity_workPhone3")
    @ApiModelProperty(value = "工作人员联系电话")
    private String activityWorkPhone3;

    @Column(name = "activity_status")
    @ApiModelProperty(value = "活动状态")
    private int activityStatus;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate1")
    @ApiModelProperty(value="活动开始日期1")
    private Date activityBeginDate1;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate1")
    @ApiModelProperty(value="活动结束日期1")
    private Date activityEndDate1;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate2")
    @ApiModelProperty(value="活动开始日期2")
    private Date activityBeginDate2;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate2")
    @ApiModelProperty(value="活动结束日期2")
    private Date activityEndDate2;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate3")
    @ApiModelProperty(value="活动开始日期3")
    private Date activityBeginDate3;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate3")
    @ApiModelProperty(value="活动结束日期3")
    private Date activityEndDate3;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate4")
    @ApiModelProperty(value="活动开始日期4")
    private Date activityBeginDate4;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate4")
    @ApiModelProperty(value="活动结束日期4")
    private Date activityEndDate4;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate5")
    @ApiModelProperty(value="活动开始日期5")
    private Date activityBeginDate5;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate5")
    @ApiModelProperty(value="活动结束日期5")
    private Date activityEndDate5;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate6")
    @ApiModelProperty(value="活动开始日期6")
    private Date activityBeginDate6;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate6")
    @ApiModelProperty(value="活动结束日期6")
    private Date activityEndDate6;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate7")
    @ApiModelProperty(value="活动开始日期7")
    private Date activityBeginDate7;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate7")
    @ApiModelProperty(value="活动结束日期7")
    private Date activityEndDate7;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate8")
    @ApiModelProperty(value="活动开始日期8")
    private Date activityBeginDate8;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate8")
    @ApiModelProperty(value="活动结束日期8")
    private Date activityEndDate8;

}
