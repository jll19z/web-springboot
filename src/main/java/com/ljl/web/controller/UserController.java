package com.ljl.web.controller;


import com.ljl.web.common.Result;
import com.ljl.web.pojo.vo.loginVo.loginVo;
import com.ljl.web.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljl
 * @since 2022-05-18
 */
@CrossOrigin
@RestController
@RequestMapping("/web/user")
public class UserController {


    @Autowired
    private StaffService staffService;

    //login
    @PostMapping("/login")
    public Result login(@RequestBody loginVo loginVo){

        String token = staffService.getToken(loginVo);
        if(token == null){
            return Result.error();
        }
        return Result.ok().data("token",token);
    }

    //info
    @GetMapping("/info")
    public Result info(){

       // String role =staffService.getRole(params);
       // String name =staffService.getName(params);
        return Result.ok().data("roles","admin").data("name","ljl").data("avatar","http://www.weixintouxiang.cn/weixin/20140607090832328.gif");
    }

}

