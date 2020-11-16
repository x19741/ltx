package spring.entity.oldOrganization;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 向加佳
 * @Description 老年文艺管理-档案人员
 * @Date 10:37 2020/11/12
 **/
@Data
@Table(name="retirement_archives_people")
public class RetirementArchivesPeople {
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
}
