package cn.edu.bupt.zshop.common.exception;

/**
 * author： Cary Chen
 * Date： 2018-11-11 下午 5:17
 * Description： <描述>
 */
public class ProductTypeExistExcaption extends Exception{

    public ProductTypeExistExcaption() {
        super();
    }

    public ProductTypeExistExcaption(String message) {
        super(message);
    }

    public ProductTypeExistExcaption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeExistExcaption(Throwable cause) {
        super(cause);
    }
}
