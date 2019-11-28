package service;

import entity.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
        Userinfo selectByUsername(String username);

        int deleteByPrimaryKey(Integer uId);

        int insert(Userinfo record);

        int insertSelective(Userinfo record);

        Userinfo selectByPrimaryKey(Integer uId);

        int updateByPrimaryKeySelective(Userinfo record);

        int updateByPrimaryKey(Userinfo record);
}
