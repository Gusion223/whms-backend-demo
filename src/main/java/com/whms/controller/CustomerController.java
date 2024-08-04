package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Customer;
import com.whms.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("/list")
    public Result listAll(){
        return Result.success(customerService.list(), customerService.count());
    }

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<Customer> page = new Page<>();
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("cname") != null){
            wrapper.like(Customer::getCname, query.getParams().get("cname"));
        }
        page.setCurrent(query.getPageIndex()).setSize(query.getPageSize());
        IPage result = customerService.page(page, wrapper);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addCustomer(@RequestBody Customer customer) {
        try{
            Boolean res = customerService.save(customer);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "用户名已存在, 请重新填写一个新的用户名", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateCustomer(@RequestBody Customer customer){
        try{
            Boolean res = customerService.updateById(customer);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteCustomer(@RequestBody Customer customer){
        System.out.println("remove customer id:"+customer.getCid());
        Boolean res = customerService.removeById(customer.getCid());
        if(res) return Result.success();
        else return Result.fail();
    }
}
