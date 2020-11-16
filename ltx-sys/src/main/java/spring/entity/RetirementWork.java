package spring.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "retirement_work")
public class RetirementWork {

    @Id
    @Column(name = "work_id")
    private Long id;

    @Column(name = "work_name")
    @ApiModelProperty(value = "姓名")
    private String workName;

    @Column(name = "work_sex")
    @ApiModelProperty(value = "性别")
    private Integer workSex;

    @Column(name = "work_card")
    @ApiModelProperty(value = "教工卡号")
    private String workCard;

    @Column(name = "work_position")
    @ApiModelProperty(value = "身份证")
    private String workPosition;

    @Column(name = "work_state")
    @ApiModelProperty(value = "状态")
    private Integer workState;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_date")
    @ApiModelProperty(value = "出生年月")
    private Date workDate;

    @Column(name = "work_nation")
    @ApiModelProperty(value = "民族")
    private String workNation;

    @Column(name = "work_politics")
    @ApiModelProperty(value = "政治面貌")
    private String workPolitics;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "参加工作时间")
    private Date workEnter;

    @Column(name = "work_education")
    @ApiModelProperty(value = "最高学历")
    private String workEducation;

    @Column(name = "work_degree")
    @ApiModelProperty(value = "最高学位")
    private String workDegree;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_admitted")
    @ApiModelProperty(value = "入党时间")
    private Date workAdmitted;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_become")
    @ApiModelProperty(value = "转正时间")
    private Date workBecome;

    @Column(name = "work_branch")
    @ApiModelProperty(value = "目前所在支部")
    private String workBranch;

    @Column(name = "work_dutuies")
    @ApiModelProperty(value = "目前党内职务")
    private String workDutuies;

    @Column(name = "work_province")
    @ApiModelProperty(value = "省")
    private String workProvince;

    @Column(name = "work_city")
    @ApiModelProperty(value = "市")
    private String workCity;

    @Column(name = "work_district")
    @ApiModelProperty(value = "区")
    private String workDistrict;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_retire")
    @ApiModelProperty(value = "离退休时间")
    private Date workRetire;

    @Column(name = "work_phone")
    @ApiModelProperty(value = "固定电话")
    private String workPhone;

    @Column(name = "work_number")
    @ApiModelProperty(value = "手机号码")
    private String workNumber;

    @Column(name = "work_ageduty")
    @ApiModelProperty(value = "离退休前职务")
    private String workAgeduty;

    @Column(name = "work_rank")
    @ApiModelProperty(value = "离退休前职级")
    private String workRank;

    @Column(name = "work_professional")
    @ApiModelProperty(value = "离退休前职称")
    private String workProfessional;

    @Column(name = "work_treatment")
    @ApiModelProperty(value = "享受级别待遇")
    private String workTreatment;

    @Column(name = "work_category")
    @ApiModelProperty(value = "离退休类别")
    private String workCategory;

    @Column(name = "work_unit")
    @ApiModelProperty(value = "离退休前单位")
    private String workUnit;

    @Column(name = "work_condition")
    @ApiModelProperty(value = "婚姻状况")
    private String workCondition;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_marriage")
    @ApiModelProperty(value = "结婚时间")
    private Date workMarriage;

    @Column(name = "work_provide")
    @ApiModelProperty(value = "养老信息")
    private String workProvide;

    @Column(name = "work_address")
    @ApiModelProperty(value = "家庭住址")
    private String workAddress;

    @Column(name = "work_namee")
    @ApiModelProperty(value = "紧急联系姓名")
    private String workNamee;

    @Column(name = "work_self")
    @ApiModelProperty(value = "与本人关系")
    private String workSelf;

    @Column(name = "work_relatio")
    @ApiModelProperty(value = "紧急联系电话")
    private String workRelatio;

    @Column(name = "work_permanent")
    @ApiModelProperty(value = "常住住址")
    private String workPermanent;

    @Column(name = "work_names")
    @ApiModelProperty(value = "紧急联系姓名1")
    private String workNames;

    @Column(name = "work_selfs")
    @ApiModelProperty(value = "与本人关系1")
    private String workSelfs;

    @Column(name = "work_relatios")
    @ApiModelProperty(value = "紧急联系电话1")
    private String workRelatios;

    @Column(name = "work_permanents")
    @ApiModelProperty(value = "常住住址1")
    private String workPermanents;

    @Column(name = "work_file")
    @ApiModelProperty(value = "照片")
    private String workFile;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_time")
    @ApiModelProperty(value = "开始时间")
    private Date workTime;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_times")
    @ApiModelProperty(value = "结束时间")
    private Date workTimes;

    @Column(name = "work_monad")
    @ApiModelProperty(value = "工作单位")
    private String workMonad;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_timea")
    @ApiModelProperty(value = "开始时间")
    private Date workTimea;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_timesa")
    @ApiModelProperty(value = "结束时间")
    private Date workTimesa;

    @Column(name = "work_monada")
    @ApiModelProperty(value = "工作单位")
    private String workMonada;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_timeb")
    @ApiModelProperty(value = "开始时间")
    private Date workTimeb;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "work_timesb")
    @ApiModelProperty(value = "结束时间")
    private Date workTimesb;

    @Column(name = "work_monadb")
    @ApiModelProperty(value = "工作单位")
    private String workMonadb;

    @Column(name = "work_concern")
    @ApiModelProperty(value = "请选择关系")
    private String workConcern;

    @Column(name = "work_concerna")
    @ApiModelProperty(value = "请选择关系")
    private String workConcerna;

    @Column(name = "work_concernb")
    @ApiModelProperty(value = "请选择关系")
    private String workConcernb;









}
