package spring.controller.client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import spring.exception.CustomException;
import spring.service.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.util.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * 流程模型Model操作相关
 * Created by chenhai on 2017/5/23.
 */
@Api(description = "流程模型Model操作相关", tags = {"web-client-activitimodeler"})
@RestController
@RequestMapping("models")
public class ModelController {
   /* @Resource
    private ModelService modelService;

    *//**
     * 新建一个空模型
     *
     * @return
     * @throws UnsupportedEncodingException
     *//*
    @ApiOperation(value = "新建一个空模型")
    @PostMapping(value = "newModel")
    public ResponseEntity<?> newModel(@RequestParam(value = "modelName") String modelName,
                                   @RequestParam(value = "description") String description,
                                   @RequestParam(value = "key") String key,
                                   @RequestParam(value = "category") String category) throws UnsupportedEncodingException {
        HashMap<String, Object> responseBody = modelService.newModel(modelName, description, key,category);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    *//**
     * 获取所有模型
     *
     * @return
     *//*
    @ApiOperation(value = "获取所有模型")
    @GetMapping("/getAll")
    public ResponseEntity<?> modelList() {
        HashMap<String, Object> responseBody = modelService.modelList();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    *//**
     * 按照种类获取所有模型
     *
     * @return
     *//*
    @ApiOperation(value = "按照种类获取所有模型")
    @GetMapping("/getbycategory")
    public ResponseEntity<?> modelByCategory(@RequestParam(value="category",required = false)  String category) {
        HashMap<String, Object> responseBody = modelService.modelByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    *//**
     * 删除模型
     *
     * @param modelId
     * @return
     *//*
    @ApiOperation(value = "删除模型")
    @PostMapping("delete")
    public String deleteModel(@RequestParam(value="modelId")  String modelId) {
        HashMap<String, Object> responseBody = modelService.deleteModel(modelId);
        try{
            return JsonUtil.sucess("成功",null);
        }catch (CustomException ce){
            return JsonUtil.error("失败。");
            //return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        }
    }

    *//**
     * 发布模型为流程定义
     *
     * @param modelId
     * @return
     *//*
    @ApiOperation(value = "发布模型为流程定义")
    @PostMapping("deploy/{modelId}")
    public ResponseEntity<?> deploy(@PathVariable("modelId") String modelId) {
        HashMap<String, Object> responseBody = modelService.deployModel(modelId);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @ApiOperation(value = "上传一个已有模型")
    @PostMapping(value = "/uploadFile")
    public ResponseEntity<?> deployUploadedFile(@RequestParam("modelFile") MultipartFile modelFile) {
        HashMap<String, Object> responseBody = modelService.uploadModel(modelFile);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }*/
}
