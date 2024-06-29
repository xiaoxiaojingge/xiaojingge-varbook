package com.xiaojingge.varbook.common.response;

import com.xiaojingge.varbook.enums.ResultCodeEnum;

/**
 * @Description: API返回参数
 * @Author: lijing
 * @CreateTime: 2023-01-03 15:52
 */
public class ApiResult {

    /**
     * 消息内容
     */
    private String message;

    /**
     * 响应码：参考`ResultCode`
     */
    private Integer code;

    /**
     * 响应中的数据
     */
    private Object data;


    public static ApiResult fail(String message) {
        return new ApiResult(ResultCodeEnum.FAILURE.getCode(), message, null);
    }

    public static ApiResult fail(Integer code, String message) {
        return new ApiResult(code, message, null);
    }

    public static ApiResult ok() {
        return new ApiResult(ResultCodeEnum.SUCCESS.getCode(), "OK", null);
    }

    public static ApiResult ok(Object data) {
        return new ApiResult(ResultCodeEnum.SUCCESS.getCode(), "OK", data);
    }


    public static ApiResult build(Integer code, String msg, Object data) {
        return new ApiResult(ResultCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static ApiResult ok(String message, Object data) {
        return new ApiResult(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }


    public static ApiResult ok(Integer code, String message) {
        return new ApiResult(code, message);
    }

    public static ApiResult ok(Integer code, String message, Object data) {
        return new ApiResult(code, message, data);
    }

    public ApiResult() {
    }

    public static ApiResult build(Integer code, String msg) {
        return new ApiResult(code, msg, null);
    }

    public ApiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public ApiResult(Object data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = "OK";
        this.data = data;
    }

    public ApiResult(String message) {
        this(ResultCodeEnum.SUCCESS.getCode(), message, null);
    }

    public ApiResult(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ApiResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
