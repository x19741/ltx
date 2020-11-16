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
@Table(name = "retirement_relation")
public class RetirementRelation {

    @Id
    @Column(name = "relation_id")
    private Long id;

    @ApiModelProperty(value = "党员姓名")
    @Column(name = "relation_name")
    private String  relationName;

    @ApiModelProperty(value = "联系方式")
    @Column(name = "relation_mode")
    private String relationMode;

    @ApiModelProperty(value = "流动党员人数")
    @Column(name = "relation_num")
    private Integer relationNum;

    @ApiModelProperty(value = "原支部")
    @Column(name = "relation_intrinsic")
    private Integer relationIntrinsic;

    @ApiModelProperty(value = "原支部")
    @Column(name = "relation_intrinsica")
    private Integer relationIntrinsica;

    @ApiModelProperty(value = "原支部")
    @Column(name = "relation_intrinsicb")
    private Integer relationIntrinsicb;

    @ApiModelProperty(value = "原支部")
    @Column(name = "relation_intrinsicc")
    private Integer relationIntrinsicc;

    @ApiModelProperty(value = "现支部")
    @Column(name = "relation_present")
    private Integer relationPresent;

    @ApiModelProperty(value = "现支部")
    @Column(name = "relation_presenta")
    private Integer relationPresenta;

    @ApiModelProperty(value = "现支部")
    @Column(name = "relation_presentb")
    private Integer relationPresentb;

    @ApiModelProperty(value = "现支部")
    @Column(name = "relation_presentc")
    private Integer relationPresentc;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "调整时间")
    @Column(name = "relation_date")
    private Date relationDate;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "调整时间")
    @Column(name = "relation_data")
    private Date relationData;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "调整时间")
    @Column(name = "relation_datb")
    private Date relationDatb;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "调整时间")
    @Column(name = "relation_datc")
    private Date relationDatc;

    @ApiModelProperty(value = "原因详情")
    @Column(name = "relation_details")
    private String relationDetails;

    @ApiModelProperty(value = "原因详情")
    @Column(name = "relation_detaila")
    private String relationDetaila;

    @ApiModelProperty(value = "原因详情")
    @Column(name = "relation_detailb")
    private String relationDetailb;

    @ApiModelProperty(value = "原因详情")
    @Column(name = "relation_detailc")
    private String relationDetailc;

}
