package spring.controller.activityManagementController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.activityManagement.ActivityManagementPeople;
import spring.exception.CustomException;
import spring.service.activityManagementService.ActivityApplyService;
import spring.service.activityManagementService.ActivityManagementPeopleService;
import spring.util.JsonUtil;

import java.util.List;

/**
 * @ClassName ActivityApplyController
 * @Description 活动管理-活动报名
 * @Author 向加佳
 * @Date 2020/11/13 9:27
 */
@RestController
@Api(description = "活动管理-活动报名")
@RequestMapping("/activityApply")
public class ActivityApplyController {

    private Logger log = Logger.getLogger(ActivityApplyController.class);

    @Autowired
    private ActivityApplyService activityApplyService;

    @Autowired
    private ActivityManagementPeopleService activityManagementPeopleService;

    @LogOperation(code = "2", name = "查看报名", description = "查看报名")
    @ApiOperation(value = "查看报名")
    @PostMapping("/lookPeople")
    @ResponseBody
    public List<ActivityManagementPeople> lookPeople(@ApiParam(value = "活动ID") @RequestParam(value = "activityId") Integer activityId,
                                                     @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                                     @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return activityManagementPeopleService.selectByPrimaryKey1(activityId, pageNumber, pageSize);
    }

    @LogOperation(code = "2", name = "新增活动报名", description = "新增活动报名")
    @ApiOperation(value = "新增活动报名")
    @PostMapping("/addPeople")
    @ResponseBody
    public boolean addPeople(@ApiParam(value = "人员表") @RequestBody ActivityManagementPeople items,
                             @ApiParam(value = "活动id") @RequestParam(value = "activityId") Integer activityId){
        return activityManagementPeopleService.addPeople(items,activityId);
    }

    @LogOperation(code = "2", name = "修改活动报名", description = "修改活动报名")
    @ApiOperation(value = "修改活动报名")
    @PostMapping("/editPeople")
    @ResponseBody
    public String editPeople(@ApiParam(value = "修改活动报名") @RequestBody ActivityManagementPeople item) throws Exception {
        try {
            if (activityManagementPeopleService.updateBeanByPrimaryKeySelective(item) <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("添加成功！", activityManagementPeopleService.selectByPrimaryKey(item.getPeopleId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除活动报名")
    @LogOperation(code = "2",name = "删除活动报名",description = "删除活动报名")
    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@ApiParam(value = "人员表ID")  @RequestParam int[] peopleId,
                          @ApiParam(value = "活动id") @RequestParam(value = "activityId") Integer activityId) throws Exception {
        //删除权限
        return activityManagementPeopleService.deleteByIds1(peopleId,activityId);
    }

    @ApiOperation(value = "查询单个人员ID")
    @PostMapping("/getPeopleId")
    @ResponseBody
    public String getPeopleId(@ApiParam(value = "人员ID") @RequestParam(value = "peopleId") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", activityManagementPeopleService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }
}
