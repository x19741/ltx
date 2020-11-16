package spring.entity.activityManagement;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName ActivityManagementSummarize
 *  活动管理-活动总结
 * @Author 向加佳
 * @Date 2020/11/14 11:35
 */
@Data
@Table(name="retirement_activityManagement_summarize")
public class ActivityManagementSummarize {

    @Id
    @Column(name = "summarize_id")
    private Long summarizeId;

    @Column(name = "activity_id")
    @ApiModelProperty(value = "活动ID")
    private String activityId;

    @Column(name = "summarize_content")
    @ApiModelProperty(value = "活动内容与安排")
    private String summarizeContent;

    @Column(name = "summarize_harvest")
    @ApiModelProperty(value = "活动收获与经验")
    private String summarizeHarvest;

    @Column(name = "summarize_question")
    @ApiModelProperty(value = "存在的问题")
    private String summarizeQuestion;

    @Column(name = "summarize_matter")
    @ApiModelProperty(value = "注意事项")
    private String summarizeMatter;

    @Column(name = "summarize_suggest")
    @ApiModelProperty(value = "改进的建议")
    private String summarizeSuggest;
}
