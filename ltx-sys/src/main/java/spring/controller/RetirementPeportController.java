package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementReport;
import spring.exception.CustomException;
import spring.service.RetirementReportService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "离退休基本信息管理-待报到管理")
@RequestMapping("/without")
public class RetirementPeportController {

    private Logger log = Logger.getLogger(RetirementPeportController.class);

    @Resource
    private RetirementReportService RetirementReportService;


    @LogOperation(code = "2", name = "查看待报到管理信息", description = "查看待报到管理信息")
    @ApiOperation(value = "查看待报到管理信息")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "活动表") @RequestBody RetirementReport item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return RetirementReportService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", RetirementReportService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增待报到管理信息", description = "新增待报到管理信息")
    @ApiOperation(value = "新增待报到管理信息")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "新增待报到管理信息") @RequestBody List<RetirementReport> items) throws Exception {
        try {
            List<RetirementReport> list = new ArrayList<>();
            for (RetirementReport item : items) {
                list.add(item);
            }
            int i;
            i = RetirementReportService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改待报到管理信息", description = "修改待报到管理信息")
    @ApiOperation(value = "修改待报到管理信息")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "修改待报到管理信息") @RequestBody RetirementReport item) throws Exception {
        try {
            if (RetirementReportService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", RetirementReportService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "根据教工卡号判断是否重复")
    @LogOperation(code = "2",name = "根据教工卡号判断是否重复",description = "根据教工卡号判断是否重复")
    @PostMapping("/getbyName/{card}")
    @ResponseBody
    public String selectName(@ApiParam(value = "根据教工卡号判断是否重复")  @PathVariable String card ) throws Exception {
        RetirementReport retirementReport=RetirementReportService.selectPacket(card);
        if(retirementReport==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("有重复教工卡号。",null);
    }

    @ApiOperation(value = "删除待报到管理信息")
    @LogOperation(code = "2",name = "删除待报到管理信息",description = "删除待报到管理信息")
    @PostMapping("gitByids/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "活动ID")  @RequestParam Long [] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+RetirementReportService.deleteReIdss(ids)+"个数据。",null);
    }
}
