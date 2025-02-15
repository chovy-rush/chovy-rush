package io.chovy.rush.common.web.msg;

public class BaseRsp {

    private Boolean state = Boolean.TRUE;

    private Integer code = 0;

    private String message = "";

    public BaseRsp() {}

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
