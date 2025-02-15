package io.chovy.rush.common.web.msg;

import io.chovy.rush.common.lang.exception.code.BaseErrorCode;

public class Resp<T> extends BaseRsp {

    private T data;

    public Resp() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Resp<T> success() {
        Resp<T> resp = new Resp<>();
        resp.setState(Boolean.TRUE);
        return resp;
    }

    public static <T> Resp<T> success(T data) {
        Resp<T> resp = new Resp<>();
        resp.setState(Boolean.TRUE);
        resp.setData(data);
        return resp;
    }

    public static <T> Resp<T> fail(BaseErrorCode errorCode) {
        return fail(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> Resp<T> fail(Integer errCode, String errMsg) {
        Resp<T> resp = new Resp<>();
        resp.setState(Boolean.FALSE);
        resp.setCode(errCode);
        resp.setMessage(errMsg);
        return resp;
    }
}
