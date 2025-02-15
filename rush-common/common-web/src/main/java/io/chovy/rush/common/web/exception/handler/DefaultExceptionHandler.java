package io.chovy.rush.common.web.exception.handler;

import io.chovy.rush.common.web.msg.Resp;

public class DefaultExceptionHandler extends AbstractExceptionHandler<Resp<String>> {

    @Override
    protected Resp<String> getResult(Integer errCode, String errMsg) {
        return Resp.fail(errCode, errMsg);
    }
}
