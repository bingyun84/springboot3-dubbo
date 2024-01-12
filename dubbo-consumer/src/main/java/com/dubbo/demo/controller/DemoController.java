package com.dubbo.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.demo.api.DemoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * @Author: huangzh
 * @Date: 2024/1/11 11:04
 * @Description: 添加描述
 */

@RestController
@RequestMapping(value = "/demo")
//@Slf4j
public class DemoController {
    @Reference
    private DemoService service;

    @GetMapping("/getDemoDto")
    public String getDemoDto(@RequestParam Integer id, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }
        String zhangsan = service.sayHello("zhangsan");
        if (zhangsan != null){
            return zhangsan;
        }
//        DemoDto demoDto = service.getDemoDto(id);
//
//        if (demoDto != null){
//            return demoDto.toString();
//        }
        return "not find data";
    }
}
