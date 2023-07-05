package com.wzl.common.config.exception;

import com.wzl.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 全局异常处理，执行的方法
	 */
	@ExceptionHandler(Exception.class)
	public Result error(Exception e){
		e.printStackTrace();
		return Result.fail().message("执行全局异常处理");
	}
	/**
	 * 特定异常处理，执行的方法
	 */
	@ExceptionHandler(ArithmeticException.class)
	public Result error(ArithmeticException e){
		e.printStackTrace();
		return Result.fail().message("执行特定异常处理");
	}
}
