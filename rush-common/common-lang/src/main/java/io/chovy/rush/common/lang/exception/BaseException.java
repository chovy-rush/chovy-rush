package io.chovy.rush.common.lang.exception;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer errCode;

    private String errMsg;

    public BaseException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BaseException(Integer errCode, String errMsg, Throwable e) {
        super(errMsg, e);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
