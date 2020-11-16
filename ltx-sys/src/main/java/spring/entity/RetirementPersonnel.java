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
@Table(name = "retirement_personnel")
public class RetirementPersonnel {

    @Id
    @Column(name = "staff_id")
    private Long id;

    @Column(name = "staff_name")
    @ApiModelProperty(value = "名字")
    private String staffName;

    @Column(name = "staff_sex")
    @ApiModelProperty(value = "性别")
    private Integer staffSex;

    @Column(name = "staff_identity")
    @ApiModelProperty(value = "身份证")
    private String staffIdentity;

    @Column(name = "staff_card")
    @ApiModelProperty(value = "教工卡号")
    private String staffCard;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_date")
    @ApiModelProperty(value = "出生年月")
    private Date staffDate;

    @Column(name = "staff_nation")
    @ApiModelProperty(value = "民族")
    private String staffNation;

    @Column(name = "staff_native")
    @ApiModelProperty(value = "出生地")
    private String staffNative;

    @Column(name = "staff_politics")
    @ApiModelProperty(value = "政治面貌")
    private String staffPolitics;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_time")
    @ApiModelProperty(value = "参加工作时间")
    private Date staffTime;

    @Column(name = "staff_official")
    @ApiModelProperty(value = "最高学历")
    private String staffOfficial;

    @Column(name = "staff_highest")
    @ApiModelProperty(value = "最高学位")
    private String staffHighest;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_enter")
    @ApiModelProperty(value = "入党时间")
    private Date staffEnter;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_become")
    @ApiModelProperty(value = "转正时间")
    private Date staffBecome;

    @Column(name = "staff_branch")
    @ApiModelProperty(value = "目前所在支部")
    private String staffBranch;

    @Column(name = "staff_duty")
    @ApiModelProperty(value = "目前党内职务")
    private String staffDuty;

    @Column(name = "staff_places")
    @ApiModelProperty(value = "曾留学哪个国家")
    private String staffPlaces;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_retire")
    @ApiModelProperty(value = "离退休时间")
    private Date staffRetire;

    @Column(name = "staff_phone")
    @ApiModelProperty(value = "固定电话")
    private String staffPhone;

    @Column(name = "staff_number")
    @ApiModelProperty(value = "手机号码")
    private String staffNumber;

    @Column(name = "staff_ageduty")
    @ApiModelProperty(value = "离退休前职务")
    private String staffAgeduty;

    @Column(name = "staff_rank")
    @ApiModelProperty(value = "离退休前职级")
    private String staffRank;

    @Column(name = "staff_professional")
    @ApiModelProperty(value = "离退休前职称")
    private String staffProfessional;

    @Column(name = "staff_treatment")
    @ApiModelProperty(value = "享受级别待遇")
    private String staffTreatment;

    @Column(name = "staff_category")
    @ApiModelProperty(value = "离退休类别")
    private String staffCategory;

    @Column(name = "staff_unit")
    @ApiModelProperty(value = "离退休前单位")
    private String staffUnit;

    @Column(name = "staff_condition")
    @ApiModelProperty(value = "婚姻状况")
    private String staffCondition;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_marriage")
    @ApiModelProperty(value = "结婚时间")
    private Date staffMarriage;

    @Column(name = "staff_provide")
    @ApiModelProperty(value = "养老信息")
    private String staffProvide;

    @Column(name = "staff_solitude")
    @ApiModelProperty(value = "是否独具")
    private Integer staffSolitude;

    @Column(name = "staff_disability")
    @ApiModelProperty(value = "是否残疾")
    private Integer staffDisability;

    @Column(name = "staff_incapacitation")
    @ApiModelProperty(value = "是否失能")
    private Integer staffIncapacitation;

    @Column(name = "staff_cadre")
    @ApiModelProperty(value = "是否军转干部")
    private Integer staffCadre;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "staff_same")
    @ApiModelProperty(value = "去世时间")
    private Date staffSame;

    @Column(name = "staff_address")
    @ApiModelProperty(value = "家庭住址")
    private String staffAddress;

    @Column(name = "staff_experience")
    @ApiModelProperty(value = "是否具有海外留学经历")
    private Integer staffExperience;

    @Column(name = "staff_prove")
    @ApiModelProperty(value = "国外生存证明")
    private String staffProve;

    @Column(name = "staff_allopatric")
    @ApiModelProperty(value = "异地定居地及生存证明")
    private String staffAllopatric;

    @Column(name = "staff_photo")
    @ApiModelProperty(value = "照片")
    private String staffPhoto;

    @Column(name = "family_fname")
    @ApiModelProperty(value = "家庭主要姓名")
    private String familyFname;

    @Column(name = "family_relation")
    @ApiModelProperty(value = "关系")
    private String familyRelation;

    @Column(name = "family_unit")
    @ApiModelProperty(value = "工作单位及职务")
    private String familyUnit;

    @Column(name = "family_phone")
    @ApiModelProperty(value = "联系电话")
    private String familyPhone;

    @Column(name = "family_address")
    @ApiModelProperty(value = "家庭地址")
    private String familyAddress;

    @Column(name = "family_name")
    @ApiModelProperty(value = "紧急联系姓名")
    private String familyName;

    @Column(name = "family_self")
    @ApiModelProperty(value = "与本人关系")
    private String familySelf;

    @Column(name = "family_relatio")
    @ApiModelProperty(value = "紧急联系电话")
    private String familyRelatio;

    @Column(name = "family_permanent")
    @ApiModelProperty(value = "常住住址")
    private String familyPermanent;

    @Column(name = "family_names")
    @ApiModelProperty(value = "紧急联系姓名1")
    private String familyNames;

    @Column(name = "family_selfs")
    @ApiModelProperty(value = "与本人关系1")
    private String familySelfs;

    @Column(name = "family_relatios")
    @ApiModelProperty(value = "紧急联系电话1")
    private String familyRelatios;

    @Column(name = "family_permanents")
    @ApiModelProperty(value = "常住住址1")
    private String familyPermanents;

    @Column(name = "family_fnameq")
    @ApiModelProperty(value = "家庭主要姓名1")
    private String familyFnameq;

    @Column(name = "family_relationq")
    @ApiModelProperty(value = "关系1")
    private String familyRelationq;

    @Column(name = "family_unitq")
    @ApiModelProperty(value = "工作单位及职务1")
    private String familyUnitq;

    @Column(name = "family_phoneq")
    @ApiModelProperty(value = "联系电话1")
    private String familyPhoneq;

    @Column(name = "family_addressq")
    @ApiModelProperty(value = "家庭地址1")
    private String familyAddressq;

    @Column(name = "family_fnamew")
    @ApiModelProperty(value = "家庭主要姓名2")
    private String familyFnamew;

    @Column(name = "family_relationw")
    @ApiModelProperty(value = "关系2")
    private String familyRelationw;

    @Column(name = "family_unitw")
    @ApiModelProperty(value = "工作单位及职务2")
    private String familyUnitw;

    @Column(name = "family_phonew")
    @ApiModelProperty(value = "联系电话2")
    private String familyPhonew;

    @Column(name = "family_addressw")
    @ApiModelProperty(value = "家庭地址2")
    private String familyAddressw;

    @Column(name = "family_fnamee")
    @ApiModelProperty(value = "家庭主要姓名3")
    private String familyFnamee;

    @Column(name = "family_relatione")
    @ApiModelProperty(value = "关系3")
    private String familyRelatione;

    @Column(name = "family_unite")
    @ApiModelProperty(value = "工作单位及职务3")
    private String familyUnite;

    @Column(name = "family_phonee")
    @ApiModelProperty(value = "联系电话3")
    private String familyPhonee;

    @Column(name = "family_addresse")
    @ApiModelProperty(value = "家庭地址3")
    private String familyAddresse;

/*    @ApiModelProperty(value = "家庭对象")
    private List<RetirementFamily> retirementFamily;

//    @ApiModelProperty(value = "紧急联系人对象")
//    private List<RetirementReFamily> retirementReFamily;*/

    @Column(name = "family_province")
    @ApiModelProperty(value = "省")
    private String familyProvince;

    @Column(name = "family_city")
    @ApiModelProperty(value = "市")
    private String familyCity;

    @Column(name = "family_district")
    @ApiModelProperty(value = "区")
    private String familyDistrict;

    @Column(name = "staff_state")
    @ApiModelProperty(value = "离世状态")
    private Integer staffState;

}
