package com.xiaojingge.varbook.exception;

/**
 * 自定义异常
 *
 * @author lijing
 * @date 2023-10-23
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误信息
     */
    private String msg;

    public BizException() {
    }

    public BizException(String msg) {
        super(msg);
    }

    /**
     * 自定义异常如何不打印异常堆栈
     * 重写以下方法
     *
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}