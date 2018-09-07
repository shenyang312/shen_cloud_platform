package com.shen.cloud.entity;

/**
 * create by emmet
 * create at 11/09/2017
 * 通用返回对象
 */
public class ZmResult<T> {
    private String respCode;//response code, use EmmetCode
    private String respDesc;//response desc
    private T respData;//response java object

    public ZmResult(String respCode, String respDesc) {
        this(respCode, respDesc, null);
    }

    public ZmResult(String respCode, String respDesc, T respData) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.respData = respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }
}
