package serviceimpl;

import entity.Orderdetail;
import mapper.OrderdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderdetailMapper odm;

    @Override
    public int deleteByPrimaryKey(Integer odId) {
        return odm.deleteByPrimaryKey(odId);
    }

    @Override
    public int insert(Orderdetail record) {
        return odm.insert(record);
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return odm.insertSelective(record);
    }

    @Override
    public Orderdetail selectByPrimaryKey(Integer odId) {
        return odm.selectByPrimaryKey(odId);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetail record) {
        return odm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderdetail record) {
        return odm.updateByPrimaryKey(record);
    }
}
