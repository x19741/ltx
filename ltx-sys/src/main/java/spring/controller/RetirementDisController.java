package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementDis;
import spring.exception.CustomException;
import spring.service.RetirementDisService;
import spring.util.JsonUtil;
import spring.util.ReType;

@RestController
@Api(description = "离退休基本信息管理-离世管理")
@RequestMapping("/position")
public class RetirementDisController {

    private Logger log = Logger.getLogger(RetirementDisController.class);

    @Autowired
    private RetirementDisService retirementDisService;


    @LogOperation(code = "2", name = "查看离世信息", description = "查看离世信息")
    @ApiOperation(value = "查看离世信息")
    @PostMapping("/get")
    @ResponseBody
    public ReType lookPeople(@ApiParam(value = "人员表") @RequestBody RetirementDis item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementDisService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String selectOne(@ApiParam(value = "id") @RequestParam(value = "id") Long id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementDisService.selectOnes(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

/*    @LogOperation(code = "2", name = "新增查离世信息管理", description = "新增离世信息管理")
    @ApiOperation(value = "新增离世信息管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "离世信息管理") @RequestBody List<RetirementDis> items) throws Exception {
        try {
            List<RetirementDis> list = new ArrayList<>();
            for (RetirementDis item : items) {
                list.add(item);
            }
            int i;
            i = retirementDisService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }*/

    @LogOperation(code = "2", name = "修改离世信息管理", description = "修改离世信息管理")
    @ApiOperation(value = "修改离世信息管理")
    @PostMapping("/edit")
    @ResponseBody
 /*   public String edit(@ApiParam(value = "修改离世信息管理") @RequestBody RetirementDis item) throws Exception {
        try {
            if (retirementDisService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementDisService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }*/

    public String edit(@ApiParam(value = "修改离世信息管理") @RequestBody RetirementDis item) throws Exception {
        try {
            if (retirementDisService.alter(item) <= 0)
                throw new CustomException("失败");
           /* return JsonUtil.sucess("添加成功！", retirementDisService.selectByPrimaryKey(item.getId()));*/
            return  JsonUtil.sucess("修改成功！",null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }


    @ApiOperation(value = "删除离世信息管理")
    @LogOperation(code = "2", name = "删除离世信息管理", description = "删除离世信息管理")
    @PostMapping("gitBy/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "离世信息ID") @RequestParam Long [] ids) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了" + retirementDisService.deleteDiIdss(ids) + "个数据。", null);
    }

}
