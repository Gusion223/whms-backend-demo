package com.whms.service.impl;

import com.whms.entity.Customer;
import com.whms.mapper.CustomerMapper;
import com.whms.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
