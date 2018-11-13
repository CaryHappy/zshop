package cn.edu.bupt.zshop.common.constant;

/**
 * author： Cary Chen
 * Date： 2018-11-11 下午 5:38
 * Description： 响应状态码常量
 */
public interface ResponseStatusConstant {

    /**
     * 响应的状态码，1表示成功
     * */
    public static final int RESPONSE_STATUS_SUCCESS = 1;

    /**
     * 响应的状态码，2表示失败
     * */
    public static final int RESPONSE_STATUS_FAILURE = 2;

    /**
     * 响应的状态码，3表示没有权限
     * */
    public static final int RESPONSE_STATUS_NO_PERMISSION = 3;

}
