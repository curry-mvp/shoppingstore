package mapper;

import entity.Productinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductinfoMapper {
    List<String> selectAllP_type();

    List<Productinfo> selectAllProductsByP_type(@Param(value = "p_type") String p_type,@Param(value = "page") Integer page);

    List<Productinfo> selectupProducts();

    List<Productinfo> selectdownProduct();

    List<Productinfo> selectOnOrders();

    List<Productinfo> selectUpOrders();

    int deleteByPrimaryKey(Integer pId);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}