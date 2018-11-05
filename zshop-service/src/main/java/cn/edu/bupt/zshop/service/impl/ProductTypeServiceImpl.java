package cn.edu.bupt.zshop.service.impl;

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
}
