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
@Table(name="retirement_party")
public class RetirementParty {

    @Id
    @Column(name = "party_id")
    private Long id;

    @Column(name = "party_name")
    @ApiModelProperty(value="名字")
    private String partyName;

    @Column(name = "party_sex")
    @ApiModelProperty(value="性别")
    private Integer partySex;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "party_parvenu")
    @ApiModelProperty(value="出生年月")
    private Date partyParvenu;

    @Column(name = "party_nation")
    @ApiModelProperty(value="民族")
    private String partyNation ;

    @Column(name = "party_native")
    @ApiModelProperty(value="籍贯")
    private String partyNative;

    @Column(name = "party_marriage")
    @ApiModelProperty(value="婚姻")
    private String partyMarriage;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "party_admitted")
    @ApiModelProperty(value="入党时间")
    private Date partyAdmitted;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "party_become")
    @ApiModelProperty(value="转正时间")
    private Date partyBecome ;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "party_job")
    @ApiModelProperty(value="参加工作时间")
    private Date partyJob ;

    @Column(name = "party_place")
    @ApiModelProperty(value="入党时所在支部")
    private String partyPlace;

    @Column(name = "party_member")
    @ApiModelProperty(value="转正时所在支部")
    private String partyMember;

    @Column(name = "party_intro")
    @ApiModelProperty(value="入党介绍人")
    private String partyIntro;

    @Column(name = "party_places")
    @ApiModelProperty(value="所在支部")
    private String partyPlaces;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "party_entrance")
    @ApiModelProperty(value="进入党支部时间")
    private Date partyEntrance ;

    @Column(name = "party_present")
    @ApiModelProperty(value="现任党内职务")
    private String partyPresent    ;

    @Column(name = "party_education")
    @ApiModelProperty(value="最高学历")
    private String partyEducation  ;

    @Column(name = "party_degree")
    @ApiModelProperty(value="最高学位")
    private String partyDegree;

    @Column(name = "party_duty")
    @ApiModelProperty(value="退休前工作单位及职务")
    private String partyDuty ;

    @Column(name = "party_address")
    @ApiModelProperty(value="户籍所在地")
    private String partyAddress    ;

    @Column(name = "party_current")
    @ApiModelProperty(value="现居住地址")
    private String partyCurrent;

    @Column(name = "party_number")
    @ApiModelProperty(value="身份证号码")
    private String partyNumber  ;

    @Column(name = "party_phone")
    @ApiModelProperty(value="联系电话")
    private String partyPhone  ;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "flow_date")
    @ApiModelProperty(value="流出日期")
    private Date flowDate    ;

    @Column(name = "flow_out")
    @ApiModelProperty(value="外出类型")
    private String flowOut     ;

    @Column(name = "flow_activity")
    @ApiModelProperty(value="活动证号码")
    private String flowActivity;

    @Column(name = "flow_linkman")
    @ApiModelProperty(value="流动支部联系人")
    private String flowLinkman;

    @Column(name = "flow_into")
    @ApiModelProperty(value="流入地（单位）")
    private String flowInto;

    @Column(name = "flow_direction")
    @ApiModelProperty(value="外出流向")
    private String flowDirection;

    @Column(name = "flow_cause")
    @ApiModelProperty(value="外出原因")
    private String flowCause;

    @Column(name = "flow_condition")
    @ApiModelProperty(value="与党组织联系情况")
    private String flowCondition;

    @Column(name = "flow_way")
    @ApiModelProperty(value="流动支部联系方式")
    private String flowWay;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "flow_format")
    @ApiModelProperty(value="失去联系日期")
    private Date flowFormat;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "flow_abroad")
    @ApiModelProperty(value="出国日期")
    private Date flowAbroad;

    @Column(name = "flow_pillar")
    @ApiModelProperty(value="出国后与组织联系情况")
    private String flowPillar;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "flow_home")
    @ApiModelProperty(value="出国日期")
    private Date flowHome;

    @Column(name = "flow_analysis")
    @ApiModelProperty(value="出国原因")
    private String flowAnalysis;

    @Column(name = "flow_manage")
    @ApiModelProperty(value="党籍处理方式")
    private String flowManage;

    @Column(name = "flow_live")
    @ApiModelProperty(value="恢复组织生活情况")
    private String flowLive;

    @Column(name = "flow_province")
    @ApiModelProperty(value = "省")
    private String flowProvince;

    @Column(name = "flow_city")
    @ApiModelProperty(value = "市")
    private String flowCity;

    @Column(name = "flow_district")
    @ApiModelProperty(value = "区")
    private String flowDistrict;

    @Column(name = "flow_provinces")
    @ApiModelProperty(value = "省")
    private String flowProvinces;

    @Column(name = "flow_citys")
    @ApiModelProperty(value = "市")
    private String flowCitys;

    @Column(name = "flow_districts")
    @ApiModelProperty(value = "区")
    private String flowDistricts;

    @Column(name = "flow_picture")
    @ApiModelProperty(value = "照片")
    private String flowPicture;

    @Column(name = "flow_card")
    @ApiModelProperty(value = "教工卡号")
    private String flowCard;
}
