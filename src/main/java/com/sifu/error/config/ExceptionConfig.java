package com.sifu.error.config;

import com.sifu.error.exception.LogicException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sifu
 * @version 1.0
 * @date 2017/12/17
 */
@ControllerAdvice
public class ExceptionConfig {
    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String LOGIC_ERROR_VIEW = "logic_error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = LogicException.class)
    public ModelAndView logicError(HttpServletRequest req, Exception e)throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",req.getRequestURL());
        mav.setViewName(LOGIC_ERROR_VIEW);
        return mav;
    }
}
