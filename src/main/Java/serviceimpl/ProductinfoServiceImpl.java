package serviceimpl;

import entity.Productinfo;
import mapper.ProductinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductinfoService;

import java.util.List;

@Service
public class ProductinfoServiceImpl implements ProductinfoService {

    @Autowired
    ProductinfoMapper pfm;

    @Override
    public List<String> selectAllP_type() {
        return pfm.selectAllP_type();
    }

    @Override
    public List<Productinfo> selectAllProductsByP_type(String p_type,Integer page) {
        return pfm.selectAllProductsByP_type(p_type,page);
    }

    @Override
    public List<Productinfo> selectupProducts() {
        return pfm.selectupProducts();
    }

    @Override
    public List<Productinfo> selectdownProduct() {
        return pfm.selectdownProduct();
    }

    @Override
    public List<Productinfo> selectOnOrders() {
        return pfm.selectOnOrders();
    }

    @Override
    public List<Productinfo> selectUpOrders() {
        return pfm.selectUpOrders();
    }

    @Override
    public int deleteByPrimaryKey(Integer pId) {
        return pfm.deleteByPrimaryKey(pId);
    }

    @Override
    public int insert(Productinfo record) {
        return pfm.insert(record);
    }

    @Override
    public int insertSelective(Productinfo record) {
        return pfm.insertSelective(record);
    }

    @Override
    public Productinfo selectByPrimaryKey(Integer pId) {
        return pfm.selectByPrimaryKey(pId);
    }

    @Override
    public int updateByPrimaryKeySelective(Productinfo record) {
        return pfm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Productinfo record) {
        return pfm.updateByPrimaryKey(record);
    }
}
