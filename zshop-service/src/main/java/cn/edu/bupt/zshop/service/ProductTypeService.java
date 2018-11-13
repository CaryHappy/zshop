package cn.edu.bupt.zshop.service;

import cn.edu.bupt.zshop.common.exception.ProductTypeExistExcaption;
import cn.edu.bupt.zshop.pojo.ProductType;

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

    /**
     * 添加商品类型
     *  判断商品类型名称是否已经存在，
     *      如果存在则抛异常，如果不存在则保存
     * */
    public void add(String name) throws ProductTypeExistExcaption;

    /**
     * 根据Id查找商品类型
     * */
    public ProductType findById(int id);

    /**
     * 修改商品的类型名称
     * */
    void modifyName(int id, String name) throws ProductTypeExistExcaption;

    /**
     * 根据Id删除商品类型
     *  判断是否存在该商品类型的商品，如果存在则抛出异常
     * */
    void removeById(int id);

    /**
     * 修改商品类型的状态
     * */
    void modifyStatus(int id);
}
