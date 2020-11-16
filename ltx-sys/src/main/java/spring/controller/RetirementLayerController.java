package spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import spring.config.logs.LogOperation;
import spring.entity.RetirementLayer;
import spring.exception.CustomException;
import spring.service.RetirementLayerService;
import spring.util.JsonUtil;
import spring.util.ReType;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(description = "党建管理-党支部管理")
@RequestMapping("/branch")
public class RetirementLayerController {

    private Logger log = Logger.getLogger(RetirementLayerController.class);

    @Resource
    private RetirementLayerService retirementLayerService;

    @LogOperation(code = "2", name = "查询党支部信息", description = "查询党支部信息")
    @ApiOperation(value = "查询党支部信息")
    @PostMapping("/get")
    @ResponseBody
    public ReType select(@ApiParam(value = "党支部表") @RequestBody RetirementLayer item
            , @ApiParam(value = "页码", required = true) @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber
            , @ApiParam(value = "每页大小", required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        return retirementLayerService.show(item, pageNumber, pageSize);
    }

    @ApiOperation(value = "查询单个数据")
    @PostMapping("/getbyid")
    @ResponseBody
    public String getbyid(@ApiParam(value = "id") @RequestParam(value = "id") Integer id) throws Exception {
        try {
            return JsonUtil.sucess("成功", retirementLayerService.selectByPrimaryKey(id));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "新增党支部信息", description = "新增党支部信息")
    @ApiOperation(value = "新增党支部管理")
    @PostMapping("/adds")
    @ResponseBody
    public String adds(@ApiParam(value = "党支部表") @RequestBody List<RetirementLayer> items) throws Exception {
        try {
            List<RetirementLayer> list = new ArrayList<>();
            for (RetirementLayer item : items) {
                list.add(item);
            }
            int i;
            i = retirementLayerService.inserts(list);
            if (i <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("成功添加！" + i + "个数据。", null);
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @LogOperation(code = "2", name = "修改党支部信息", description = "修改党支部信息")
    @ApiOperation(value = "修改党支部信息")
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ApiParam(value = "党支部表") @RequestBody RetirementLayer item) throws Exception {
        try {
            if (retirementLayerService.updateBeanByPrimaryKeySelective(item) <= 0)
                throw new CustomException("失败");
            return JsonUtil.sucess("添加成功！", retirementLayerService.selectByPrimaryKey(item.getId()));
        } catch (CustomException ce) {
            return JsonUtil.error(ce.getMessage());
        }
    }

    @ApiOperation(value = "删除党支部信息")
    @LogOperation(code = "2",name = "删除党支部信息",description = "删除党支部信息")
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public String delete(@ApiParam(value = "删除党支部信息")  @PathVariable Long[] ids ) throws Exception {
        return JsonUtil.sucess("删除了"+retirementLayerService.deleteLayer(ids)+"个数据。",null);
    }


}
