package io.chovy.rush.common.lang.exception.code;

public enum CommonErrCode implements BaseErrorCode {
    SYS_ERROR(400, "系统错误", "系统错误"),
    VALIDATE_ERROR(40001, "参数校验失败", "请求参数异常"),
    PARAM_BIND_ERROR(40005, "参数绑定失败", "请求参数异常"),
    ENCRYPT_PASSWORD_ERROR(40006, "密码加密失败", "密码加密异常"),
    DECRYPT_PASSWORD_ERROR(40007, "密码解析失败", "密码解析异常");

    private final Integer code;

    private final String desc;

    private final String msg;

    CommonErrCode(Integer code, String desc, String msg) {
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

    public String getMsg() {
        return this.msg;
    }
}
