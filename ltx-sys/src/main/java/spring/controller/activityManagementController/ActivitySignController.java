package spring.controller.activityManagementController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.dto.ActivitySignDTO;
import spring.entity.activityManagement.ActivityManagement;
import spring.service.activityManagementService.ActivitySignService;

import java.util.List;

/**
 * @ClassName ActivitySignController
 * @Description 活动管理-活动签到
 * @Author 向加佳
 * @Date 2020/11/13 15:26
 */
@RestController
@Api(description = "活动管理-活动签到")
@RequestMapping("/activitySign")
public class ActivitySignController {

    private Logger log = Logger.getLogger(ActivitySignController.class);

    @Autowired
    private ActivitySignService activitySignService;

    @LogOperation(code = "2", name = "活动签到查询", description = "活动签到查询")
    @ApiOperation(value = "活动签到查询")
    @PostMapping("/get")
    @ResponseBody
    public List<ActivitySignDTO> select(@ApiParam(value = "活动表")  @RequestBody List<ActivityManagement> activity
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return activitySignService.selectSign(activity, pageNumber, pageSize);
    }
}
