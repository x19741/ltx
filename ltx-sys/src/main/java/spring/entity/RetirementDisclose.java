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
@Table(name="retirement_disclose")
public class RetirementDisclose {

    @Id
    @Column(name = "disclose_id")
    private Long id;

    @Column(name = "disclose_name")
    @ApiModelProperty(value="名字")
    private String discloseName;

    @Column(name = "disclose_sex")
    @ApiModelProperty(value="性别")
    private Integer discloseSex;

    @Column(name = "disclose_card")
    @ApiModelProperty(value="教工卡号")
    private String discloseCard;

    @Column(name = "disclose_identity")
    @ApiModelProperty(value="身份证号")
    private String discloseIdentity;

    @Column(name = "disclose_state")
    @ApiModelProperty(value="状态")
    private Integer discloseState;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "disclose_date")
    @ApiModelProperty(value="出生年月")
    private Date discloseDate;

    @Column(name = "disclose_nation")
    @ApiModelProperty(value="民族")
    private String discloseNation;

    @Column(name = "disclose_politics")
    @ApiModelProperty(value="政治面貌")
    private String disclosePolitics;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "disclose_enter")
    @ApiModelProperty(value="参加工作时间")
    private Date discloseEnter;

    @Column(name = "disclose_education")
    @ApiModelProperty(value="最高学历")
    private String discloseEducation;

    @Column(name = "disclose_degree")
    @ApiModelProperty(value="最高学位")
    private String discloseDegree;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "disclose_admitted")
    @ApiModelProperty(value="入党时间")
    private Date discloseAdmitted;

    @Column(name = "disclose_picture")
    @ApiModelProperty(value="图片")
    private String disclosePicture;

    @Column(name = "disclose_address")
    @ApiModelProperty(value="地址")
    private String discloseAddress;

    @Column(name = "disclose_addressa")
    @ApiModelProperty(value="地址1")
    private String discloseAddressa;

    @Column(name = "disclose_addressb")
    @ApiModelProperty(value="地址2")
    private String discloseAddressb;

    @Column(name = "disclose_addressc")
    @ApiModelProperty(value="地址3")
    private String discloseAddressc;

    @Column(name = "disclose_default")
    @ApiModelProperty(value="默认")
    private Integer discloseDefault;












}
