package serviceimpl;

import entity.Userinfo;
import mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserinfoMapper uim;

    @Override
    public Userinfo selectByUsername(String username) {
        return uim.selectByUsername(username);
    }

    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return uim.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(Userinfo record) {
        return uim.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return uim.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer uId) {
        return uim.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return uim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return uim.updateByPrimaryKey(record);
    }
}
