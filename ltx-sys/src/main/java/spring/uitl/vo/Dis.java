package spring.uitl.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Dis implements Serializable {

    @ApiModelProperty(value = "名字")
    private String staffName;

    @ApiModelProperty(value = "性别")
    private Integer staffSex;

    @ApiModelProperty(value = "教工卡号")
    private String staffCard;

}
