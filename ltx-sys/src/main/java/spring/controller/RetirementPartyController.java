package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementParty;
import spring.exception.CustomException;
import spring.service.RetirementPartyService;
import spring.util.JsonUtil;
import spring.util.ReType;

import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "党建管理-党员管理")
@RequestMapping("/party")
public class RetirementPartyController {

    private Logger log = Logger.getLogger(RetirementPartyController.class);

    @Autowired
    private RetirementPartyService retirementPartyService;

    @LogOperation(code = "2", name = "党建管理查询", description = "党建管理查询")
    @ApiOperation(value = "党建管理查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "党建表") @RequestBody RetirementParty item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementPartyService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementPartyService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增党建管理", description = "新增党建管理")
    @ApiOperation(value = "新增党建管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "党建管理") @RequestBody List<RetirementParty> items) throws Exception {
        try {
            List<RetirementParty> list = new ArrayList<>();
            for (RetirementParty item : items) {
                list.add(item);
            }
            int i;
            i = retirementPartyService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改建党管理", description = "修改建党管理")
    @ApiOperation(value = "修改建党管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "建党管理") @RequestBody RetirementParty item) throws Exception {
        try {
            if (retirementPartyService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementPartyService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除党建")
    @LogOperation(code = "2",name = "删除党建",description = "删除党建")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "党建id")  @PathVariable Long[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+retirementPartyService.deletePaIds(ids)+"个数据。",null);
    }

    @ApiOperation(value = "教工卡号判断是否重复")
    @LogOperation(code = "2",name = "教工卡号判断是否重复",description = "教工卡号判断是否重复")
    @PostMapping("/selectpard/{card}")
    @ResponseBody
    public String selectParty(@ApiParam(value = "教工卡号判断是否重复")  @PathVariable String card ) throws Exception {
        RetirementParty retirementDisclose=retirementPartyService.selectParty(card);
        if(retirementDisclose==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("重复教工卡号。",null);
    }

}
