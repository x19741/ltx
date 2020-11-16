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
@Table(name="retirement_happy")
public class RetirementHappy {

    @Id
    @Column(name = "happy_id")
    private Long id;

    @Column(name = "happy_name")
    @ApiModelProperty(value = "姓名")
    private String happyName;

    @Column(name = "happy_sex")
    @ApiModelProperty(value = "性别")
    private Integer happySex;

    @Column(name = "happy_age")
    @ApiModelProperty(value = "年龄")
    private Integer happyAge;

    @Column(name = "happy_card")
    @ApiModelProperty(value = "教工卡号")
    private String happyCard;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "happy_date")
    @ApiModelProperty(value = "出生年月")
    private Date happyDate;

    @Column(name = "happy_relation")
    @ApiModelProperty(value = "联系方式")
    private String happyRelation;
}
