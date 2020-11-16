package spring.entity.oldOrganization;//package spring.entity;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Date;
//
///**
// * @Author 向加佳
// * @Description 老年文艺管理-档案
// * @Date 10:40 2020/11/12
// **/
//@Data
//@Table(name = "retirement_archives")
//public class RetirementArchives {
//
//    @Id
//    @Column(name = "archives_id")
//    private Long id;
//
//    @Column(name = "archives_courseName")
//    @ApiModelProperty(value = "课程名称")
//    private String archivesCourseName;
//
//    @JSONField(format = "yyyy-MM-dd HH:mm")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
//    @Column(name = "archives_beginDate ")
//    @ApiModelProperty(value="学期开始日期 ")
//    private Date archivesBeginDate;
//
//    @JSONField(format = "yyyy-MM-dd HH:mm")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
//    @Column(name = "archives_endDate ")
//    @ApiModelProperty(value="学期结束日期 ")
//    private Date archivesEndDate;
//
//    @Column(name = "archives_semester")
//    @ApiModelProperty(value = "学期")
//    private String archivesSemester;
//
//    @Column(name = "work_id")
//    @ApiModelProperty(value = "工作表workID")
//    private Long workId;
//
//}
