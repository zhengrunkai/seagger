package com.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author : 郑润楷
 * @Date : 2021-01-05 10:12
 **/
@RestController
@Api(tags = "测试接口模块",description = "主要是为了提供测试接口用")
@RequestMapping("/test")
public class TestController {
    @GetMapping("/index")
    @ApiOperation(value = "引导页接口")
    public String testResult(){
        return "Hello World";
    }
}
