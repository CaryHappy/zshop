package cn.edu.bupt.zshop.service.impl;

import cn.edu.bupt.zshop.common.constant.ProductTypeConstant;
import cn.edu.bupt.zshop.common.exception.ProductTypeExistExcaption;
import cn.edu.bupt.zshop.dao.ProductTypeDao;
import cn.edu.bupt.zshop.pojo.ProductType;
import cn.edu.bupt.zshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author： Cary Chen
 * Date： 2018-11-05 下午 7:05
 * Description： <描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ProductType> findAll() {
        return productTypeDao.selectAll();
    }

    @Override
    public void add(String name) throws ProductTypeExistExcaption {
        ProductType productType = productTypeDao.selectByName(name);
        if(null != productType){
            throw new ProductTypeExistExcaption("商品类型已存在");
        }
        productTypeDao.insert(name, ProductTypeConstant.PRODUCT_TYPE_ENABLE);
    }

    @Override
    public ProductType findById(int id) {
        return productTypeDao.selectById(id);
    }

    @Override
    public void modifyName(int id, String name) throws ProductTypeExistExcaption {
        ProductType productType = productTypeDao.selectByName(name);
        if(null != productType){
            throw new ProductTypeExistExcaption("商品类型已存在");
        }
        productTypeDao.updateName(id, name);
    }

    @Override
    public void removeById(int id) {
        productTypeDao.deleteById(id);
    }

    @Override
    public void modifyStatus(int id) {
        ProductType productType = findById(id);
        int status = productType.getStatus();
        if(productType.getStatus() == ProductTypeConstant.PRODUCT_TYPE_ENABLE){
            status = ProductTypeConstant.PRODUCT_TYPE_DIDSABLE;
        }else{
            status = ProductTypeConstant.PRODUCT_TYPE_ENABLE;
        }
        productTypeDao.updateStatus(id, status);
    }

}
