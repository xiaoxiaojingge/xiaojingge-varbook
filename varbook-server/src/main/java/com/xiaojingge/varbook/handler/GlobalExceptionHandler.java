package com.xiaojingge.varbook.handler;

import com.xiaojingge.varbook.common.response.ApiResult;
import com.xiaojingge.varbook.enums.ResultCodeEnum;
import com.xiaojingge.varbook.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author lijing
 * @date 2024-06-29
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BizException.class)
    public ApiResult handleServiceException(BizException e) {
        log.error(e.getMessage(), e);
        return ApiResult.fail(e.getMessage());
    }


    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception e, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestUri, e);
        return ApiResult.fail(ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

}
