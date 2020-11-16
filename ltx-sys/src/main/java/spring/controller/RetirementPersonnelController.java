package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementDis;
import spring.entity.RetirementPersonnel;
import spring.exception.CustomException;
import spring.service.RetirementDisService;
import spring.service.RetirementPersonnelService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;

@RestController
@Api(description = "离退休基本信息管理-人员管理")
@RequestMapping("/essential")
@Validated
public class RetirementPersonnelController {

    private Logger log = Logger.getLogger(RetirementPartyController.class);

    @Resource
    private RetirementPersonnelService retirementPersonnelService;

    @Autowired
    private RetirementDisService retirementDisService;

    RetirementDis retirementDis = new RetirementDis();

    @LogOperation(code = "2", name = "人员管理查询", description = "人员管理查询")
    @ApiOperation(value = "人员管理查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "人员管理表") @RequestBody RetirementPersonnel item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementPersonnelService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementPersonnelService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "人员管理新增", description = "人员管理新增")
    @ApiOperation(value = "人员管理新增")
    @PostMapping("/adds")
    @ResponseBody
    /*public String adds(@ApiParam(value = "党建管理") @RequestBody List<RetirementPersonnel> items) throws Exception {
        try {
            List<RetirementPersonnel> list = new ArrayList<>();
            for (RetirementPersonnel item : items) {
                list.add(item);
            }
            int i;
            i = retirementPersonnelService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }*/

    public String added(@RequestBody RetirementPersonnel snaps) {
        int result = retirementPersonnelService.added(snaps);
        if (result > 0) {
            retirementDisService.addw(snaps.getId());//新增一条离世信息
            return JsonUtil.sucess("添加数据成功!", null);
        }
        return JsonUtil.sucess("添加数据失败！", null);
    }

    @ApiOperation(value = "根据教工卡号判断是否重复")
    @LogOperation(code = "2", name = "根据教工卡号判断是否重复", description = "根据教工卡号判断是否重复")
    @PostMapping("/getbyName/{card}")
    @ResponseBody
    public String selectName(@ApiParam(value = "根据教工卡号判断是否重复") @PathVariable String card) throws Exception {
        RetirementPersonnel retirementPersonnel = retirementPersonnelService.selectCaid(card);
        if (retirementPersonnel == null)
            return JsonUtil.sucess("没有重复教工卡号。", null);
        else
            return JsonUtil.sucess("有重复教工卡号。", null);
    }

    @LogOperation(code = "2", name = "修改人员管理", description = "修改人员管理")
    @ApiOperation(value = "修改人员管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "修改人员管理") @RequestBody RetirementPersonnel item) throws Exception {
        try {
            if (retirementPersonnelService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementPersonnelService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "批量删除人员")
    @LogOperation(code = "2", name = "批量删除人员", description = "批量删除人员")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String remove(@ApiParam(value = "人员ids") @PathVariable Long[] ids) {
        return JsonUtil.sucess(String.valueOf("删除了" + retirementPersonnelService.deleteByIdss(ids)) + "个数据。", null);
    }

}
