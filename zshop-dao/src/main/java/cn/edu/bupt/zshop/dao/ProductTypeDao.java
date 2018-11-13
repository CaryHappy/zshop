package cn.edu.bupt.zshop.dao;

import cn.edu.bupt.zshop.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author： Cary Chen
 * Date： 2018-11-04 下午 8:59
 * Description： <描述>
 */
public interface ProductTypeDao {
    /**
     * 查找所有商品类型
     */
    public List<ProductType> selectAll();

    /**
     * 根据id查找商品类型
     */
    public ProductType selectById(int id);

    /**
     * 根据名称查找商品类型
     */
    public ProductType selectByName(String name);

    /**
     * 插入新的商品类型
     * */
    public void insert(@Param("name")String name, @Param("status")int status);

    /**
     * 更新商品名
     * */
    public void updateName(@Param("id") int id, @Param("name") String name);

    /**
     * 更新商品状态
     * */
    public void updateStatus(@Param("id") int id, @Param("status") int status);

    /**
     * 根据Id删除
     * */
    public void deleteById(int id);

    List<ProductType> selectByStatus(int status);

}
