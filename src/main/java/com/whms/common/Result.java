package com.whms.common;

import lombok.Data;

@Data
public class Result {
    private int status;
    private String msg;
    private long total;
    private Object data;

    public static Result tip(int status, String msg){return result(status, msg, 0, null);}
    public static Result fail(){
        return result(400, "失败", 0L, null);
    }
    public static Result success(){
        return result(200, "成功", 0L, null);
    }
    public static Result success(Object data, long total){
        return result(200, "成功", total, data);
    }
    public static Result result(int status, String msg, long total, Object data){
        Result result = new Result();
        result.setStatus(status);
        result.setMsg(msg);
        result.setTotal(total);
        result.setData(data);
        return result;
    }
}
