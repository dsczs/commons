package com.penglecode.common.support;

/**
 * 通用返回结果类
 *
 * @param <T>
 * @author pengpeng
 * @version 1.0
 * @date 2014年6月13日 上午8:59:37
 */
public class Result<T> {

    private boolean success;

    private String retCode;

    private String msg;

    private T retObj;

    public Result() {
        super();
    }

    public Result(boolean success, String retCode, String msg, T retObj) {
        super();
        this.success = success;
        this.retCode = retCode;
        this.msg = msg;
        this.retObj = retObj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRetObj() {
        return retObj;
    }

    public void setRetObj(T retObj) {
        this.retObj = retObj;
    }

}
