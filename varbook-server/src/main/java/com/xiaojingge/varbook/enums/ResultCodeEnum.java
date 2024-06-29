package com.xiaojingge.varbook.enums;

/**
 * @Description: 返回码枚举
 * @Author: lijing
 * @CreateTime: 2023-01-03 15:54
 */
public enum ResultCodeEnum {

    // 成功
    SUCCESS(200, "SUCCESS"),

    // 失败
    FAILURE(400, "FAILURE"),

    // 接口不存在
    NOT_FOUND(404, "接口不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private int code;
    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
