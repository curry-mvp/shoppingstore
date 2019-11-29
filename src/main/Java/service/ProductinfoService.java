package service;

import entity.Productinfo;
import entity.Userinfo;

import java.util.List;

public interface ProductinfoService {
    List<String> selectAllP_type();

    List<Productinfo> selectAllProductsByP_type(String p_type);

    int deleteByPrimaryKey(Integer pId);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);
}
