package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementRelation;
import spring.exception.CustomException;
import spring.service.RetirementRelationService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "党建管理-组织关系")
@RequestMapping("/tissue")
public class RetirementRelationController {

    private Logger log = Logger.getLogger(RetirementRelationController.class);

    @Resource
    private RetirementRelationService retirementRelationService;

    @LogOperation(code = "2", name = "查询组织关系信息", description = "查询组织关系信息")
    @ApiOperation(value = "查询组织关系信息")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "组织关系表") @RequestBody RetirementRelation item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementRelationService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementRelationService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增组织关系信息", description = "新增组织关系信息")
    @ApiOperation(value = "新增组织关系信息")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "组织关系表") @RequestBody List<RetirementRelation> items) throws Exception {
        try {
            List<RetirementRelation> list = new ArrayList<>();
            for (RetirementRelation item : items) {
                list.add(item);
            }
            int i;
            i = retirementRelationService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改组织关系信息", description = "修改组织关系信息")
    @ApiOperation(value = "修改组织关系信息")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "组织关系表") @RequestBody RetirementRelation item) throws Exception {
        try {
            if (retirementRelationService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementRelationService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除组织关系信息")
    @LogOperation(code = "2",name = "删除组织关系信息",description = "删除组织关系信息")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "根据id删除组织关系信息")  @PathVariable Long[] ids ) throws Exception {
        return JsonUtil.sucess("删除了"+retirementRelationService.deleteRela(ids)+"个数据。",null);
    }


}
