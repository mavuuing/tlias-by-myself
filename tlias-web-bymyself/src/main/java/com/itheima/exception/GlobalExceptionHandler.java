package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //@RestControllerAdvice => @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class) //捕获所有异常
    public Result exceptionHandler(Exception ex){
        ex.printStackTrace();//打印异常信息
        return Result.error("对不起，操作失败，请联系管理员");
    }

}
