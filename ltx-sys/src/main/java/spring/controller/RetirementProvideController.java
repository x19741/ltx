package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementProvide;
import spring.exception.CustomException;
import spring.service.RetirementProvideService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("provide")
@Api(description="离退休基本信息管理-养老管理")
public class RetirementProvideController {

    @Autowired
    private RetirementProvideService retirementProvideService;

    @LogOperation(code = "2", name = "养老管理查询", description = "养老管理查询")
    @ApiOperation(value = "养老管理查询")
    @PostMapping("/refer")
    @ResponseBody
    public ReType select(@ApiParam(value = "养老管理表") @RequestBody RetirementProvide item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementProvideService.show(item,pageNumber,pageSize);
    }

 /*   @LogOperation(code = "2", name = "养老管理查询", description = "养老管理查询")
    @ApiOperation(value = "养老管理查询")
    @PostMapping("/refer")
    @ResponseBody
    public ReType getUnderways(@ApiParam(value = "养老管理查询") @RequestBody RetirementProvide item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return retirementProvideService.getUnderways(item, pageNumber, pageSize);
    }*/

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementProvideService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "养老管理新增", description = "养老管理新增")
    @ApiOperation(value = "养老管理新增")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "养老管理") @RequestBody List<RetirementProvide> items) throws Exception {
        try {
            List<RetirementProvide> list = new ArrayList<>();
            for (RetirementProvide item : items) {
                list.add(item);
            }
            int i;
            i = retirementProvideService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改养老管理", description = "修改养老管理")
    @ApiOperation(value = "修改养老管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "修改养老管理") @RequestBody RetirementProvide item) throws Exception {
        try {
            if (retirementProvideService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementProvideService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "根据id删除数据")
    @LogOperation(code = "2",name = "根据id删除数据",description = "根据id删除数据")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "人员id")  @PathVariable Long[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+retirementProvideService.deletePrIdss(ids)+"个数据。",null);
    }

    @ApiOperation(value = "教工卡号是否重复")
    @LogOperation(code = "2",name = "教工卡号是否重复",description = "教工卡号是否重复")
    @PostMapping("/getbyName/{card}")
    @ResponseBody
    public String selectName(@ApiParam(value = "教工卡号是否重复")  @PathVariable String card ) throws Exception {
        RetirementProvide retirementProvide=retirementProvideService.selectOld(card);
        if(retirementProvide==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("有重复教工卡号。",null);
    }


}
