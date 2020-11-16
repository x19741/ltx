package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementWork;
import spring.exception.CustomException;
import spring.service.RetirementWorkService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "离退休基本信息管理-工作管理")
@RequestMapping("/work")
public class RetirementWorkController {

    private Logger log = Logger.getLogger(RetirementWorkController.class);

    @Resource
    private RetirementWorkService retirementWorkService;

    @LogOperation(code = "2", name = "工作查询", description = "工作查询")
    @ApiOperation(value = "工作查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "工作址表") @RequestBody RetirementWork item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementWorkService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementWorkService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增工作管理", description = "新增工作管理")
    @ApiOperation(value = "新增工作管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "工作管理") @RequestBody List<RetirementWork> items) throws Exception {
        try {
            List<RetirementWork> list = new ArrayList<>();
            for (RetirementWork item : items) {
                list.add(item);
            }
            int i;
            i = retirementWorkService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改工作管理", description = "修改工作管理")
    @ApiOperation(value = "修改工作管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "家庭工作管理") @RequestBody RetirementWork item) throws Exception {
        try {
            if (retirementWorkService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementWorkService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除工作信息")
    @LogOperation(code = "2",name = "删除工作信息",description = "删除工作")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "删除工作id")  @PathVariable Long[] ids ) throws Exception {
        return JsonUtil.sucess("删除了"+retirementWorkService.deleteWoIds(ids)+"个数据。",null);
    }

    @ApiOperation(value = "根据教工卡号判断是否重复")
    @LogOperation(code = "2",name = "根据教工卡号判断是否重复",description = "根据教工卡号判断是否重复")
    @PostMapping("/getbyName/{discloseCard}")
    @ResponseBody
    public String selectName(@ApiParam(value = "根据教工卡号判断是否重复")  @PathVariable String discloseCard ) throws Exception {
        RetirementWork retirementWork=retirementWorkService.selectWorks(discloseCard);
        if(retirementWork==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("有重复教工卡号。",null);
    }

}
