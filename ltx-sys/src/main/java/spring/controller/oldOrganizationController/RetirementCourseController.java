package spring.controller.oldOrganizationController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.oldOrganization.RetirementCourse;
import spring.exception.CustomException;
import spring.service.oldOrganizationService.RetirementCourseService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 向加佳
 * @Description 老年文艺团体-课程管理
 * @Date 10:51 2020/11/12
 **/
@RestController
@Api(description = "老年文艺团体-课程管理")
@RequestMapping("/course")
public class RetirementCourseController {
    private Logger log = Logger.getLogger(RetirementCourseController.class);

    @Autowired
    private RetirementCourseService retirementCourseService;

    @LogOperation(code = "2", name = "课程管理查询", description = "课程管理查询")
    @ApiOperation(value = "课程管理查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "课程表") @RequestBody RetirementCourse item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementCourseService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementCourseService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增课程管理", description = "新增课程管理")
    @ApiOperation(value = "新增课程管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "课程管理") @RequestBody List<RetirementCourse> items) throws Exception {
        try {
            List<RetirementCourse> list = new ArrayList<>();
            for (RetirementCourse item : items) {
                list.add(item);
            }
            int i;
            i = retirementCourseService.inserts(list);
            if (i <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改课程管理", description = "修改课程管理")
    @ApiOperation(value = "修改课程管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "修改课程管理") @RequestBody RetirementCourse item) throws Exception {
        try {
            if (retirementCourseService.updateBeanByPrimaryKeySelective(item) <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("添加成功！", retirementCourseService.selectByPrimaryKey(item.getCourseId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除课程管理")
    @LogOperation(code = "2",name = "删除课程管理",description = "删除课程管理")
    @PostMapping("/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "课程ID")  @RequestParam int[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+retirementCourseService.deleteByIds1(ids)+"个数据。",null);
    }
}
