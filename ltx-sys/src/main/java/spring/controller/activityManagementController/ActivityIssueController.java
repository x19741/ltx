package spring.controller.activityManagementController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.activityManagement.ActivityManagement;
import spring.exception.CustomException;
import spring.service.activityManagementService.ActivityIssueService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ActivityIssueController
 * @Description 活动管理-活动发布
 * @Author 向加佳
 * @Date 2020/11/12 16:42
 */
@RestController
@Api(description = "活动管理-活动发布")
@RequestMapping("/activityIssue")
public class ActivityIssueController {

    private Logger log = Logger.getLogger(ActivityIssueController.class);

    @Autowired
    private ActivityIssueService activityIssueService;

    @LogOperation(code = "2", name = "活动发布查询", description = "活动发布查询")
    @ApiOperation(value = "活动发布查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "活动表") @RequestBody ActivityManagement item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return activityIssueService.show(item, pageNumber, pageSize);
    }

    @LogOperation(code = "2", name = "新增活动发布", description = "新增活动发布")
    @ApiOperation(value = "新增活动发布")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "活动表") @RequestBody List<ActivityManagement> items) throws Exception {
        try {
            List<ActivityManagement> list = new ArrayList<>();
            for (ActivityManagement item : items) {
                list.add(item);
            }
            int i;
            i = activityIssueService.inserts(list);
            if (i <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "activityId") Integer activityId) throws Exception {
        try {
            return JsonUtil.sucess("成功", activityIssueService.selectByPrimaryKey(activityId));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }


    @LogOperation(code = "2", name = "修改活动", description = "修改活动")
    @ApiOperation(value = "修改活动")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "活动表") @RequestBody ActivityManagement item) throws Exception {
        try {
            if (activityIssueService.updateBeanByPrimaryKeySelective(item) <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("添加成功！", activityIssueService.selectByPrimaryKey(item.getActivityId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除活动")
    @LogOperation(code = "2",name = "删除活动",description = "删除活动")
    @PostMapping("/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "活动ID")  @RequestParam int[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+activityIssueService.deleteByIds1(ids)+"个数据。",null);
    }
}
