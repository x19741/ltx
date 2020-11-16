package spring.uitl;

import lombok.Data;

import java.util.Date;

@Data
public class RetirementCourseDTO {

    private String courseName;

    private Date courseBeginDate;

    private Date courseEndDate;

    private String courseTeacher;
}
