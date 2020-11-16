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
@Table(name = "retirement_report")
public class RetirementReport  {

    @Id
    @Column(name = "report_id")
    private Long id;

    @ApiModelProperty(name = "姓名")
    @Column(name = "report_name")
    private String reportName;

    @ApiModelProperty(name = "教工卡号")
    @Column(name = "report_card")
    private String reportCard;

    @ApiModelProperty(name = "性别")
    @Column(name = "report_sex")
    private Integer reportSex;

    @ApiModelProperty(name = "年龄")
    @Column(name = "report_age")
    private Integer reportAge;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(name = "待报时间")
    @Column(name = "report_date")
    private Date reportDate;

    @ApiModelProperty(name = "联系方式")
    @Column(name = "report_relation")
    private String reportRelation;
}
