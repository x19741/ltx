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
@Table(name = "retirement_family")
public class RetirementFamily {

    @Id
    @Column(name = "family_id")
    private Long id;

    @ApiModelProperty(value = "姓名")
    @Column(name="family_name")
    private String familyName;

    @ApiModelProperty(value = "性别")
    @Column(name="family_sex")
    private Integer familySex;

    @ApiModelProperty(value = "身份证")
    @Column(name="family_identity")
    private String familyIdentity;

    @ApiModelProperty(value = "教工卡号")
    @Column(name="family_card")
    private String familyCard;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "出生年月")
    @Column(name="family_date")
    private Date familyDate;

    @ApiModelProperty(value = "民族")
    @Column(name="family_nation")
    private String familyNation;

    @ApiModelProperty(value = "出生地")
    @Column(name="family_native")
    private String familyNative;

    @ApiModelProperty(value = "政治面貌")
    @Column(name="family_politics")
    private String familyPolitics;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "参加工作时间")
    @Column(name="family_time")
    private Date familyTime;

    @ApiModelProperty(value = "最高学历")
    @Column(name="family_official")
    private String familyOfficial;

    @ApiModelProperty(value = "最高学位")
    @Column(name="family_highest")
    private String familyHighest;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "入党时间")
    @Column(name="family_enter")
    private Date familyEnter;

    @ApiModelProperty(value = "家庭主要姓名")
    @Column(name="family_fnamea")
    private String familyFnamea;

    @ApiModelProperty(value = "关系")
    @Column(name="family_relationa")
    private String familyRelationa;

    @ApiModelProperty(value = "工作单位及职务")
    @Column(name="family_unita")
    private String familyUnita;

    @ApiModelProperty(value = "联系电话")
    @Column(name="family_phonea")
    private String familyPhonea;

    @ApiModelProperty(value = "家庭主要姓名")
    @Column(name="family_fnames")
    private String familyFnames;

    @ApiModelProperty(value = "关系")
    @Column(name="family_relations")
    private String familyRelations;

    @ApiModelProperty(value = "工作单位及职务")
    @Column(name="family_units")
    private String familyUnits;

    @ApiModelProperty(value = "联系电话")
    @Column(name="family_phones")
    private String familyPhones;

    @ApiModelProperty(value = "家庭主要姓名")
    @Column(name="family_fnamed")
    private String familyFnamed;

    @ApiModelProperty(value = "关系")
    @Column(name="family_relationd")
    private String familyRelationd;

    @ApiModelProperty(value = "工作单位及职务")
    @Column(name="family_unitd")
    private String familyUnitd;

    @ApiModelProperty(value = "联系电话")
    @Column(name="family_phoned")
    private String familyPhoned;

    @ApiModelProperty(value = "家庭主要姓名")
    @Column(name="family_fnamef")
    private String familyFnamef;

    @ApiModelProperty(value = "关系")
    @Column(name="family_relationf")
    private String familyRelationf;

    @ApiModelProperty(value = "工作单位及职务")
    @Column(name="family_unitf")
    private String familyUnitf;

    @ApiModelProperty(value = "联系电话")
    @Column(name="family_phonef")
    private String familyPhonef;

    @ApiModelProperty(value = "照片")
    @Column(name="pamily_file")
    private String pamilyFile;

    @ApiModelProperty(value = "状态")
    @Column(name="pamily_state")
    private Integer  pamilyState;




}
