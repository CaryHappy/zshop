package cn.edu.bupt.zshop.service;

import cn.edu.bupt.zshop.pojo.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： Cary Chen
 * Date： 2018-11-04 下午 9:30
 * Description： <描述>
 */
public interface ProductTypeService {


    /**
     * 查找所有商品类型信息
     * */
    public List<ProductType> findAll();
}
