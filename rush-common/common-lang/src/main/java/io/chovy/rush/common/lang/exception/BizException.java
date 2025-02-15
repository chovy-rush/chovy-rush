package io.chovy.rush.common.lang.exception;

public class BizException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BizException(Integer errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public BizException(Integer errCode, String errMsg, Throwable e) {
        super(errCode, errMsg, e);
    }
}
