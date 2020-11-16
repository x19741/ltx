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
 * @Description 老年文艺团体-课程
 * @Date 10:43 2020/11/12
 **/
@Data
@Table(name = "retirement_course")
public class RetirementCourse {
    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    @ApiModelProperty(value = "课程名称")
    private String courseName;

    @Column(name = "course_number")
    @ApiModelProperty(value = "课程人数")
    private int courseNumber;

    @Column(name = "course_maxnumber")
    @ApiModelProperty(value = "课程人数上限")
    private int courseMaxNumber;

    @Column(name = "course_partyMember")
    @ApiModelProperty(value = "流动党员人数")
    private int coursePartyMember;

    @Column(name = "course_teacher")
    @ApiModelProperty(value = "任课老师")
    private String courseTeacher;

    @Column(name = "course_address")
    @ApiModelProperty(value = "任课地点")
    private String courseAddress;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "course_beginDate")
    @ApiModelProperty(value="课程开始日期")
    private Date courseBeginDate;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(name = "course_endDate")
    @ApiModelProperty(value="课程结束日期")
    private Date courseEndDate;

    @Column(name = "course_content")
    @ApiModelProperty(value = "课程内容")
    private String courseContent;

    @Column(name = "course_synopsis")
    @ApiModelProperty(value = "课程简介")
    private String courseSynopsis;

    @JSONField(format = "yyyy")
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy", timezone = "GMT+8")
    @Column(name = "course_schoolYear")
    @ApiModelProperty(value="学年")
    private Date courseSchoolYear;

    @Column(name = "course_semester")
    @ApiModelProperty(value = "学期")
    private String courseSemester;

    @Column(name = "course_status")
    @ApiModelProperty(value = "状态")
    private int courseStatus;
}
