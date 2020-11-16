package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementHappy;
import spring.exception.CustomException;
import spring.service.RetirementHappyService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "离退休基本信息管理-生日提醒管理")
@RequestMapping("/birthday")
public class RetirementHappyController {

    private Logger log = Logger.getLogger(RetirementHappyController.class);

    @Resource
    private RetirementHappyService retirementHappyService;

    @LogOperation(code = "2", name = "生日提醒查询", description = "生日提醒查询")
    @ApiOperation(value = "生日提醒查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "生日提醒表") @RequestBody RetirementHappy item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementHappyService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementHappyService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增生日提醒管理", description = "新增生日提醒管理")
    @ApiOperation(value = "新增生日提醒管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "家庭地址管理") @RequestBody List<RetirementHappy> items) throws Exception {
        try {
            List<RetirementHappy> list = new ArrayList<>();
            for (RetirementHappy item : items) {
                list.add(item);
            }
            int i;
            i = retirementHappyService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改生日提醒管理", description = "修改家生日提醒管理")
    @ApiOperation(value = "修改生日提醒管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "生日提醒管理") @RequestBody RetirementHappy item) throws Exception {
        try {
            if (retirementHappyService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementHappyService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除生日提醒信息")
    @LogOperation(code = "2",name = "删除生日提醒信息",description = "删除生日提醒信息")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "删除家庭信息id")  @PathVariable Long[] ids ) throws Exception {
        //删除权限
        return JsonUtil.sucess("删除了"+retirementHappyService.deleteHaIds(ids)+"个数据。",null);
    }

    @ApiOperation(value = "教工卡号判断是否重复")
    @LogOperation(code = "2",name = "教工卡号判断是否重复",description = "教工卡号判断是否重复")
    @PostMapping("/selectday/{card}")
    @ResponseBody
    public String selectParty(@ApiParam(value = "教工卡号判断是否重复")  @PathVariable String card ) throws Exception {
        RetirementHappy retirementDisclose=retirementHappyService.selectFete(card);
        if(retirementDisclose==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("重复教工卡号。",null);
    }

}
