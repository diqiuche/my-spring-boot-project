package io.renren.modules.api.controller;


import io.renren.common.utils.Result;
import io.renren.modules.api.annotation.AuthIgnore;
import io.renren.modules.api.annotation.LoginUser;
import io.renren.modules.api.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API测试接口
 *
 * @author ChunLiang Hu
 * @email davichi2009@gmail.com
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
@Api("测试接口")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @AuthIgnore
    @GetMapping("userInfo")
    @ApiOperation(value = "获取用户信息")
//    @ApiImplicitParam(paramType = "header", name = "token", value = "token", required = true)
    public Result userInfo(@LoginUser UserEntity user) {
        return Result.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    @ApiOperation(value = "忽略Token验证测试")
    public Result notToken() {
        return Result.ok().put("msg", "无需token也能访问。。。");
    }
}
