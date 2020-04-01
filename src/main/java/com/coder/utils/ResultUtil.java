package com.coder.utils;

import java.io.Serializable;

import lombok.Data;

/**
 * 接口返回数据格式
 *
 * @author A
 * @date 2020年2月12日14:39:41
 */
@Data
public class ResultUtil<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "操作成功";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    private T data;

    public ResultUtil() {

    }

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public void error500(String message) {
        this.message = message;
        this.code = ConstantUtil.SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
    }

    public void success(String message) {
        this.message = message;
        this.code = ConstantUtil.SC_OK_200;
        this.success = true;
    }

    public static ResultUtil<Object> error(String msg) {
        return error(ConstantUtil.SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static ResultUtil<Object> error(int code, String msg) {
        ResultUtil<Object> r = new ResultUtil<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public static ResultUtil<Object> ok(String msg) {
        ResultUtil<Object> r = new ResultUtil<Object>();
        r.setSuccess(true);
        r.setCode(ConstantUtil.SC_OK_200);
        r.setMessage(msg);
        return r;
    }

    public static ResultUtil<Object> ok(Object data) {
        ResultUtil<Object> r = new ResultUtil<Object>();
        r.setSuccess(true);
        r.setCode(ConstantUtil.SC_OK_200);
        r.setData(data);
        return r;
    }
}
