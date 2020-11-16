package spring.controller.oldOrganizationController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.oldOrganization.RetirementArchivesPeople;
import spring.entity.oldOrganization.RetirementCourse;
import spring.exception.CustomException;
import spring.service.oldOrganizationService.RetirementArchivesService;
import spring.service.oldOrganizationService.RetirementCourseService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.text.ParseException;
import java.util.List;

/**
 * @Author 向加佳
 * @Description 老年文艺团体-档案管理
 * @Date 10:50 2020/11/12
 **/
@RestController
@Api(description = "老年文艺团体-档案管理")
@RequestMapping("/archives")
public class RetirementArchivesController {

    private Logger log = Logger.getLogger(RetirementArchivesController.class);

    @Autowired
    private RetirementCourseService retirementCourseService;

    @Autowired
    private RetirementArchivesService retirementArchivesService;

//    @LogOperation(code = "2", name = "导出档案", description = "导出档案")
//    @ApiOperation(value = "导出档案")
//    @GetMapping("/export")
//    @ResponseBody
//    public void excel(HttpServletResponse response){
//        XSSFWorkbook wb =retirementArchivesService.show1();
//        String fileName = "档案表.xlsx";
//        OutputStream outputStream =null;
//        try {
//            fileName = URLEncoder.encode(fileName,"UTF-8");
//            //设置ContentType请求信息格式
//            response.setContentType("application/vnd.ms-excel");
//            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//            outputStream = response.getOutputStream();
//            wb.write(outputStream);
//            outputStream.flush();
//            outputStream.close();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @LogOperation(code = "2", name = "档案管理查询", description = "档案管理查询")
    @ApiOperation(value = "档案管理查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "档案表") @RequestBody RetirementCourse item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementCourseService.show(item, pageNumber, pageSize);
    }

    @LogOperation(code = "2", name = "查看学员", description = "查看学员")
    @ApiOperation(value = "查看学员")
    @PostMapping("/lookPeople")
    @ResponseBody
    public List<RetirementArchivesPeople> lookPeople(@ApiParam(value = "课程ID") @RequestParam(value = "courseId") Integer courseId,
                                                     @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                                     @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementArchivesService.selectByPrimaryKey1(courseId, pageNumber, pageSize);
    }

    @ApiOperation(value = "删除人员")
    @LogOperation(code = "2",name = "删除人员",description = "删除人员")
    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@ApiParam(value = "人员表ID")  @RequestParam int[] peopleId,
                          @ApiParam(value = "课程ID") @RequestParam(value = "courseId") Integer courseId) throws Exception {
        //删除权限
        return retirementArchivesService.deleteByIds1(peopleId,courseId);
    }

    @LogOperation(code = "2", name = "新增人员", description = "新增人员")
    @ApiOperation(value = "新增人员")
    @PostMapping("/addPeople")
    @ResponseBody
    public boolean addPeople(@ApiParam(value = "人员表") @RequestBody RetirementArchivesPeople items,
                             @ApiParam(value = "课程id") @RequestParam(value = "courseId") Integer courseId)throws ParseException {
        return retirementArchivesService.addPeople(items,courseId);
    }

    @LogOperation(code = "2", name = "修改人员", description = "修改人员")
    @ApiOperation(value = "修改人员")
    @PostMapping("/editPeople")
    @ResponseBody
    public boolean editPeople(@ApiParam(value = "修改人员") @RequestBody RetirementArchivesPeople item) throws Exception {
        return retirementArchivesService.updatePeople(item);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "peopleId") Integer peopleId) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementArchivesService.selectByPrimaryKey(peopleId));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

}
