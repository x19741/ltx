package spring.controller.oldOrganizationController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.oldOrganization.RetirementActivity;
import spring.entity.oldOrganization.RetirementActivityPeople;
import spring.exception.CustomException;
import spring.service.oldOrganizationService.RetirementActivityPeopleService;
import spring.service.oldOrganizationService.RetirementActivityService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 向加佳
 * @Description 老年文艺团体-活动及报名管理
 * @Date 10:44 2020/11/12
 **/
@RestController
@Api(description = "老年文艺团体-活动及报名管理")
@RequestMapping("/activity")
public class RetirementActivityController {

    private Logger log = Logger.getLogger(RetirementActivityController.class);

    @Autowired
    private RetirementActivityService retirementActivityService;

    @Autowired
    private RetirementActivityPeopleService retirementActivityPeopleService;

    @ApiOperation(value = "查询单个人员ID")
    @PostMapping("/getPeopleId")
    @ResponseBody
    public String getPeopleId(@ApiParam(value = "人员ID") @RequestParam(value = "peopleId") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementActivityPeopleService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除报名管理")
    @LogOperation(code = "2",name = "删除报名管理",description = "删除报名管理")
    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@ApiParam(value = "人员表ID")  @RequestParam int[] peopleId,
                         @ApiParam(value = "活动id") @RequestParam(value = "activityId") Integer activityId) throws Exception {
        //删除权限
        return retirementActivityPeopleService.deleteByIds1(peopleId,activityId);
    }

    @LogOperation(code = "2", name = "修改报名管理", description = "修改报名管理")
    @ApiOperation(value = "修改报名管理")
    @PostMapping("/editPeople")
    @ResponseBody
    public String editPeople(@ApiParam(value = "修改报名管理") @RequestBody RetirementActivityPeople item) throws Exception {
        try {
            if (retirementActivityPeopleService.updateBeanByPrimaryKeySelective(item) <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("添加成功！", retirementActivityPeopleService.selectByPrimaryKey(item.getPeopleId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增报名管理", description = "新增报名管理")
    @ApiOperation(value = "新增报名管理")
    @PostMapping("/addPeople")
    @ResponseBody
    public boolean addPeople(@ApiParam(value = "人员表") @RequestBody RetirementActivityPeople items,
                             @ApiParam(value = "活动id") @RequestParam(value = "activityId") Integer activityId)throws ParseException {
            return retirementActivityPeopleService.addPeople(items,activityId);
    }

    @LogOperation(code = "2", name = "查看报名", description = "查看报名")
    @ApiOperation(value = "查看报名")
    @PostMapping("/lookPeople")
    @ResponseBody
    public List<RetirementActivityPeople> lookPeople(@ApiParam(value = "活动ID") @RequestParam(value = "activityId") Integer activityId,
                                                     @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                                     @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementActivityPeopleService.selectByPrimaryKey1(activityId, pageNumber, pageSize);
    }

    @LogOperation(code = "2", name = "活动查询", description = "活动查询")
    @ApiOperation(value = "活动查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "活动表") @RequestBody RetirementActivity item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementActivityService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个活动ID")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementActivityService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增活动管理", description = "新增活动管理")
    @ApiOperation(value = "新增活动管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "活动管理") @RequestBody List<RetirementActivity> items) throws Exception {
        try {
            List<RetirementActivity> list = new ArrayList<>();
            for (RetirementActivity item : items) {
                list.add(item);
            }
            int i;
            i = retirementActivityService.inserts(list);
            if (i <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改活动管理", description = "修改活动管理")
    @ApiOperation(value = "修改活动管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "修改活动管理") @RequestBody RetirementActivity item) throws Exception {
        try {
            if (retirementActivityService.updateBeanByPrimaryKeySelective(item) <= 0) {
                throw new CustomException("失败");
            }
            return JsonUtil.sucess("添加成功！", retirementActivityService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }


    @ApiOperation(value = "删除活动管理")
    @LogOperation(code = "2",name = "删除活动管理",description = "删除活动管理")
    @PostMapping("/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "课程ID")  @RequestParam int[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+retirementActivityService.deleteByIds1(ids)+"个数据。",null);
    }
}
