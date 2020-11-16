package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementDisclose;
import spring.exception.CustomException;
import spring.service.RetirementDiscloseService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "离退休基本信息管理-家庭地址管理")
@RequestMapping("/site")
public class RetirementDiscloseController {

    private Logger log = Logger.getLogger(RetirementDiscloseController.class);

    @Resource
    private RetirementDiscloseService retirementDiscloseService;

    @LogOperation(code = "2", name = "家庭地址查询", description = "家庭地址查询")
    @ApiOperation(value = "家庭地址查询")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "家庭地址表") @RequestBody RetirementDisclose item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementDiscloseService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementDiscloseService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增家庭地址管理", description = "新增家庭地址管理")
    @ApiOperation(value = "新增家庭地址管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "家庭地址管理") @RequestBody List<RetirementDisclose> items) throws Exception {
        try {
            List<RetirementDisclose> list = new ArrayList<>();
            for (RetirementDisclose item : items) {
                list.add(item);
            }
            int i;
            i = retirementDiscloseService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改家庭地址管理", description = "修改家庭地址管理")
    @ApiOperation(value = "修改建党管理")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "家庭地址管理") @RequestBody RetirementDisclose item) throws Exception {
        try {
            if (retirementDiscloseService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementDiscloseService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除家庭信息")
    @LogOperation(code = "2",name = "删除家庭信息",description = "删除家庭信息")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "删除家庭信息id")  @PathVariable Long[] ids ) throws Exception {
        return JsonUtil.sucess("删除了"+retirementDiscloseService.deleteDsIds(ids)+"个数据。",null);
    }

    @ApiOperation(value = "根据教工卡号判断是否重复")
    @LogOperation(code = "2",name = "根据教工卡号判断是否重复",description = "根据教工卡号判断是否重复")
    @PostMapping("/getbyName/{discloseCard}")
    @ResponseBody
    public String selectName(@ApiParam(value = "根据教工卡号判断是否重复")  @PathVariable String discloseCard ) throws Exception {
        RetirementDisclose retirementDisclose=retirementDiscloseService.selectName(discloseCard);
        if(retirementDisclose==null)
            return JsonUtil.sucess("没有重复教工卡号。",null);
        else
            return JsonUtil.sucess("有重复教工卡号。",null);
    }

}
