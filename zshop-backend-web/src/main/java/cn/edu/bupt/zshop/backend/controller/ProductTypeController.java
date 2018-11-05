package cn.edu.bupt.zshop.backend.controller;

import cn.edu.bupt.zshop.pojo.ProductType;
import cn.edu.bupt.zshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author： Cary Chen
 * Date： 2018-11-04 下午 8:37
 * Description： <描述>
 */
@Controller
@RequestMapping("/backend/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        //查找所有商品类型
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("productTypes", productTypes);
        return "productTypeManager";
    }
}
