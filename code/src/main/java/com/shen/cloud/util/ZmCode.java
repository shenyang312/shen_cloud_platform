package com.shen.cloud.util;

import com.shen.cloud.base.SYObject;

/**
 * create by emmet
 * create at 11/09/2017
 * 系统返回枚举
 */
public class ZmCode extends SYObject {

    public static final ZmCode OK = new ZmCode("00", "操作成功");
    public static final ZmCode FAIL = new ZmCode("09", "失败");
    public static final ZmCode ERR = new ZmCode("10", "系统异常");
    public static final ZmCode ERR_PARAM = new ZmCode("11", "参数异常");
    public static final ZmCode ERR_SIGN = new ZmCode("12", "系统验签异常");
    public static final ZmCode ERR_DB = new ZmCode("13", "数据库异常");
    public static final ZmCode TOKEN_EXPIRED = new ZmCode("14", "系统token失效");
    public static final ZmCode TIME_OUT = new ZmCode("99", "系统请求超时");
    public static final ZmCode ORDER_NONE = new ZmCode("15","无此订单数据");
    public static final ZmCode ORDER_ERROR = new ZmCode("16","订单异常");
    public static final ZmCode BACKAMT_ERROR = new ZmCode("17","退款金额不对");
    public static final ZmCode TRANSAMT_OVERRUN = new ZmCode("18","催款金额超标");
    public static final ZmCode ORDER_STATUS = new ZmCode("19","订单状态异常");
    public static final ZmCode TRANSFLOW_NONE = new ZmCode("20","查不到流水");
    public static final ZmCode TRANSFLOW_MORE = new ZmCode("21","查到多条流水");
    public static final ZmCode DETAIL_NONE= new ZmCode("22","无详情单记录");
    public static final ZmCode CARDARG2_ERROR = new ZmCode("23","CVN2错误");
    public static final ZmCode CARDARG3_ERROR = new ZmCode("24","有效期错误");
    public static final ZmCode CANCEL_ERROR = new ZmCode("25","只能取消执行中或是待执行的订单");
    public static final ZmCode CUSTOMER_NONE = new ZmCode("26","找不到对应的客户号");
    public static final ZmCode ACCOUNT_ERR = new ZmCode("27","账户异常");
    public static final ZmCode ORDER_REPAYING = new ZmCode("28","订单正在执行,无法取消");
    public static final ZmCode TOKEN_ERR = new ZmCode("29","token验证失败");
    public static final ZmCode VERSION_ERR = new ZmCode("30","版本号格式错误");
    public static final ZmCode EXPEN_EXCEED = new ZmCode("31","结算费用不可大于上级渠道");
    public static final ZmCode DATA_ERR = new ZmCode("32","查询数据有异");
    private String code;
    private String desc;

    public ZmCode() {}
    public ZmCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean codeEquals(String respCode) {
        return this.code.equals(respCode);
    }
}
