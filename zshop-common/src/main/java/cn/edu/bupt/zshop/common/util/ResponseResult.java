package cn.edu.bupt.zshop.common.util;

import cn.edu.bupt.zshop.common.constant.ResponseStatusConstant;

/**
 * author： Cary Chen
 * Date： 2018-11-11 下午 5:35
 * Description： 响应结果
 */
public class ResponseResult {

    //状态码
    private int status;

    //消息
    private String message;

    //数据
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //成功的方法
    public static ResponseResult success(Object data){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS, "success", data);
    }

    public static ResponseResult success(String message){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS, message, null);
    }

    public static ResponseResult success(){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS, "success", null);
    }

    //失败的方法
    public static ResponseResult fail(Object data){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_FAILURE, "failure", data);
    }

    public static ResponseResult fail(String message){
        return new ResponseResult(ResponseStatusConstant.RESPONSE_STATUS_FAILURE, message, null);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
