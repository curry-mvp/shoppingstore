package serviceimpl;

import entity.Orderinfo;
import mapper.OrderinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderinfoService;
@Service
public class OrderinfoServiceImpl implements OrderinfoService {

    @Autowired
    OrderinfoMapper oim;

    @Override
    public int deleteByPrimaryKey(Integer oId) {
        return oim.deleteByPrimaryKey(oId);
    }

    @Override
    public int insert(Orderinfo record) {
        return oim.insert(record);
    }

    @Override
    public int insertSelective(Orderinfo record) {
        return oim.insertSelective(record);
    }

    @Override
    public Orderinfo selectByPrimaryKey(Integer oId) {
        return oim.selectByPrimaryKey(oId);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderinfo record) {
        return oim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderinfo record) {
        return oim.updateByPrimaryKey(record);
    }
}
