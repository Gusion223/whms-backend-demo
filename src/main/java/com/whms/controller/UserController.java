package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.User;
import com.whms.entity.bo.DayPurchaseSale;
import com.whms.service.UserService;
import com.whms.token.TokenUtil;
import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whms
 * @since 2024-03-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

//    @GetMapping("/list")
//    public Result list(HttpServletRequest request){
////        HttpSession session = request.getSession();
//        return Result.success(userService.list(), userService.count());
//    }


    @GetMapping("/get-dayPurchaseSale")
    public Result getDayPurchaseSale(){
        List<DayPurchaseSale> result = userService.listDayPurchaseSale();
        return Result.success(result, result.size());
    }

    @GetMapping("/get-totalCostSale")
    public Result getTotalCostSale(){
        return Result.success(userService.getTotalCostSale(), 1);
    }
    //新增
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        try{
            Boolean res = userService.save(user);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "用户名已存在, 请重新填写一个新的用户名", 0, null);
        }

    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody User user){
        try{
            Boolean res = userService.updateById(user);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody User user){
        System.out.println("remove user id:"+user.getId());
        Boolean res = userService.removeById(user.getId());
        if(res) return Result.success();
        else return Result.fail();
    }
    @PostMapping("/listCustomized")
    public Result pageCustomized(@RequestBody QueryParam query){
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        if(query.getParams() != null &&query.getParams().containsKey("name")){
            wrapper.eq(User::getUserName, query.getParams().get("name").toString());
        }else{
            wrapper.eq(User::getUserName, "");
        }

        IPage result = userService.page(page, wrapper);


        System.out.println("PageSize:"+query.getPageSize());
        System.out.println("PageIndex:"+query.getPageIndex());
        // 获取表中的数据个数
        System.out.println("Record Num:"+ result.getTotal());



        return Result.success(result.getRecords(), result.getTotal());

    }

    @PostMapping("/pageC")
    public Result pageC(@RequestBody QueryParam query){
        Page<User> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = userService.pageC(page);

        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/login")
    public Result userLogin(@RequestBody QueryParam query){
        try{
            List list = userService.lambdaQuery().
                    eq(User::getUserName, query.getParams().get("userName")).
                    eq(User::getPassword, query.getParams().get("password")).
                    eq(User::getUserType, query.getParams().get("userType")).
                    list();
            User user = (User) list.get(0);
            if(user!=null){
                user.setToken(TokenUtil.sign(user));
            }
            System.out.println(user);

            return user!=null? Result.success(user, 1) : Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/pageWith")
    public Result pageWith(@RequestBody QueryParam query){
        try{
            HashMap params = query.getParams();
            String nameLike = (String)params.getOrDefault("nickName","");
            Integer userType = (int)params.getOrDefault("userType",-1);
            Page<User> page = new Page<>();
            page.setCurrent(query.getPageIndex());
            page.setSize(query.getPageSize());
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper = queryWrapper.like(User::getNickName, nameLike);
            if(!userType.equals(-1)){
                queryWrapper = queryWrapper.eq(User::getUserType, userType);
            }
            IPage result = userService.page(page, queryWrapper);
            System.out.println("query params:"+params);
            System.out.println("index:"+result.getCurrent()+", total:"+result.getTotal());
            return Result.success(result.getRecords(), result.getTotal());
        }catch (Exception e){
            System.out.println(e);
            return Result.fail();
        }
    }
}
