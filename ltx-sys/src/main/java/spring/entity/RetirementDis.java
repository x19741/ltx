package spring.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import spring.uitl.vo.Dis;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "retirement_die")
public class RetirementDis extends Dis {

    @Id
    @Column(name = "die_id")
    private Long id;

    @ApiModelProperty(value = "名字")
    @Column(name = "die_name")
    private String dieName;

    @ApiModelProperty(value = "性别")
    @Column(name = "die_sex")
    private Integer dieSex;

    @ApiModelProperty(value = "年龄")
    @Column(name = "die_age")
    private Integer dieAge;

    @ApiModelProperty(value = "教工卡号")
    @Column(name = "die_card")
    private String dieCard;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "离世时间")
    @Column(name = "die_leave")
    private Date dieLeave;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "告别仪式时间")
    @Column(name = "die_farewell")
    private Date dieFarewell;

    @ApiModelProperty(value = "告别仪式地点")
    @Column(name = "die_address")
    private String dieAddress;

    @ApiModelProperty(value = "辞世原因")
    @Column(name = "die_away")
    private String dieAway;

}
