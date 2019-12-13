package serviceimpl;

import entity.Admininfo;
import mapper.AdmininfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdmininfoService;
@Service
public class AdmininfoServiceImpl implements AdmininfoService {

    @Autowired
    AdmininfoMapper aim;

    @Override
    public int deleteByPrimaryKey(Integer adId) {
        return aim.deleteByPrimaryKey(adId);
    }

    @Override
    public int insert(Admininfo record) {
        return aim.insert(record);
    }

    @Override
    public int insertSelective(Admininfo record) {
        return aim.insertSelective(record);
    }

    @Override
    public Admininfo selectByPrimaryKey(Integer adId) {
        return aim.selectByPrimaryKey(adId);
    }

    @Override
    public Admininfo selectByUsername(String adName) {
        return aim.selectByUsername(adName);
    }

    @Override
    public int updateByPrimaryKeySelective(Admininfo record) {
        return aim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admininfo record) {
        return aim.updateByPrimaryKey(record);
    }
}
