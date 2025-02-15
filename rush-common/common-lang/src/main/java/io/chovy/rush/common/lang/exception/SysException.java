package io.chovy.rush.common.lang.exception;

public class SysException extends BaseException {

    private static final long serialVersionUID = 1L;

    public SysException(Integer errCode, String errMsg) {
        super(errCode, errMsg);
    }

    public SysException(Integer errCode, String errMsg, Throwable e) {
        super(errCode, errMsg, e);
    }
}
