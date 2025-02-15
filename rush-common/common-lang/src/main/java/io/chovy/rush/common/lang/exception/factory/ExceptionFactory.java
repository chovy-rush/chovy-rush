package io.chovy.rush.common.lang.exception.factory;

import io.chovy.rush.common.lang.exception.BizException;
import io.chovy.rush.common.lang.exception.SysException;
import io.chovy.rush.common.lang.exception.code.BaseErrorCode;

public class ExceptionFactory {

    public static BizException bizException(BaseErrorCode errCode, Object... agrs) {
        return new BizException(errCode.getCode(), String.format(errCode.getMsg(), agrs));
    }

    public static BizException bizException(Integer errCode, String errMsg) {
        return new BizException(errCode, errMsg);
    }

    public static SysException sysException(BaseErrorCode errCode, Object... agrs) {
        return new SysException(errCode.getCode(), String.format(errCode.getMsg(), agrs));
    }

    public static SysException sysException(Integer errCode, String errMsg) {
        return new SysException(errCode, errMsg);
    }
}
