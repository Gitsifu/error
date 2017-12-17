package com.sifu.error.controller;

import com.sifu.error.exception.LogicException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sifu
 * @version 1.0
 * @date 2017/12/17
 */
@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String hello() throws Exception{
        throw new Exception("发生错误");
    }

    @RequestMapping("/hi")
    public String test()throws LogicException{
        throw new LogicException("发生逻辑错误");
    }
}
