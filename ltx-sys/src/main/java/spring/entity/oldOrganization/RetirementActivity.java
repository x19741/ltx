package spring.entity.oldOrganization;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author 向加佳
 * @Description  老年文艺团体-活动
 * @Date 10:39 2020/11/12
 **/
@Data
@Table(name="retirement_activity")
public class RetirementActivity {
    @Id
    @Column(name = "activity_id")
    private Long id;

    @Column(name = "activity_name")
    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @Column(name = "activity_number")
    @ApiModelProperty(value = "活动人数")
    private Long activityNumber ;

    @Column(name = "activity_maxnumber")
    @ApiModelProperty(value = "活动人数上限")
    private Long activityMaxNumber ;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_beginDate")
    @ApiModelProperty(value="活动开始日期 ")
    private Date activityBeginDate ;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "activity_endDate")
    @ApiModelProperty(value="活动结束日期")
    private Date activityEndDate ;

    @Column(name = "activity_content")
    @ApiModelProperty(value = "活动内容")
    private String activityContent ;

    @Column(name = "activity_status")
    @ApiModelProperty(value = "活动状态")
    private int activityStatus ;

    @Column(name = "activity_address")
    @ApiModelProperty(value = "活动地址")
    private String activityAddress ;
}
