package com.dubbo.demo.service;

import com.dubbo.demo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Random;

/**
 * @Author: huangzh
 * @Date: 2024/1/11 11:03
 * @Description: 添加描述
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + new Random().nextInt();
    }
}
