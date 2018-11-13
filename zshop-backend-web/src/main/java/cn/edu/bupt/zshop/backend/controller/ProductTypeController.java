package cn.edu.bupt.zshop.backend.controller;

import cn.edu.bupt.zshop.common.constant.PaginationConstant;
import cn.edu.bupt.zshop.common.constant.ResponseStatusConstant;
import cn.edu.bupt.zshop.common.exception.ProductTypeExistExcaption;
import cn.edu.bupt.zshop.common.util.ResponseResult;
import cn.edu.bupt.zshop.pojo.ProductType;
import cn.edu.bupt.zshop.service.ProductTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String findAll(Integer pageNum, Model model){
        if(ObjectUtils.isEmpty(pageNum)){
            pageNum = PaginationConstant.PAGE_NUM;
        }
        //设置分页
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);

        //查找所有商品类型
        List<ProductType> productTypes = productTypeService.findAll();

        //将查询出的结果封装到PageInfo对象中
        PageInfo<ProductType> pageInfo = new PageInfo<>(productTypes);
        //pageInfo.getPageNum(); //取得当前页码
        //pageInfo.getPages();    //总共有多少页
        //pageInfo.getNextPage(); //获取下一页
        //pageInfo.getPrePage();  //获取上一页
        //pageInfo.getList();

        model.addAttribute("pageInfo", pageInfo);
        return "productTypeManager";
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult add(String name){
        ResponseResult result = new ResponseResult();
        try {
            productTypeService.add(name);
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_SUCCESS);
            result.setMessage("添加成功");
        } catch (ProductTypeExistExcaption e) {
            result.setStatus(ResponseStatusConstant.RESPONSE_STATUS_FAILURE);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ResponseResult findById(int id){
        ProductType productType =  productTypeService.findById(id);
        return ResponseResult.success(productType);
    }

    @RequestMapping("/modifyName")
    @ResponseBody
    public ResponseResult modifyName(int id, String name){
        try {
            productTypeService.modifyName(id, name);
            return ResponseResult.success("修改商品类型成功");
        } catch (ProductTypeExistExcaption e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
    }

    @RequestMapping("/removeById")
    @ResponseBody
    public ResponseResult removeById(int id){
        productTypeService.removeById(id);
        return ResponseResult.success();
    }

    @RequestMapping("/modifyStatus")
    @ResponseBody
    public ResponseResult modifyStatus(int id){
        productTypeService.modifyStatus(id);
        return ResponseResult.success();
    }

}
