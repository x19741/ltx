package spring.controller.activityManagementController;//package spring.controller.activityManagementController;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import spring.config.logs.LogOperation;
//import spring.entity.oldOrganization.RetirementActivityPeople;
//import spring.service.activityManagementService.ActivityManagementSummarizeService;
//
//import java.util.List;
//
///**
// * @ClassName ActivityManagementSummarizeController
// * @Description 活动管理-活动总结
// * @Author 向加佳
// * @Date 2020/11/14 11:39
// */
//@RestController
//@Api(description = "活动管理-活动总结")
//@RequestMapping("/activityManagementSummarize")
//public class ActivityManagementSummarizeController {
//
//    @Autowired
//    private ActivityManagementSummarizeService activityManagementSummarizeService;
//
//    @LogOperation(code = "2", name = "查看活动总结", description = "查看活动总结")
//    @ApiOperation(value = "查看活动总结")
//    @PostMapping("/lookPeople")
//    @ResponseBody
//    public List<RetirementActivityPeople> lookPeople(@ApiParam(value = "活动ID") @RequestParam(value = "activityId") Integer activityId,
//                                                     @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
//                                                     @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
//        return ActivityManagementSummarizeService.selectByPrimaryKey1(activityId, pageNumber, pageSize);
//    }
//}
