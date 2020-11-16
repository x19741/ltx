package spring.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="retirement_provide")
public class RetirementProvide {

    @Id
    @Column(name = "provide_id")
    private Long id;

    @Column(name="provide_sex")
    @ApiModelProperty(value = "性别")
    private Integer provideSex;

    @Column(name="provide_name")
    @ApiModelProperty(value = "姓名")
    private String provideName;

    @Column(name="provide_relation")
    @ApiModelProperty(value = "联系方式")
    private String provideRelation;

    @Column(name="provide_card")
    @ApiModelProperty(value = "教工卡号")
    private String provideCard;

    @Column(name="provide_pattern")
    @ApiModelProperty(value = "养老模式")
    private String providePattern;

    @Column(name="provide_designation")
    @ApiModelProperty(value = "养老机构名称")
    private String provideDesignation;

    @Column(name="provide_address")
    @ApiModelProperty(value = "地址")
    private String provideAddress;




}
