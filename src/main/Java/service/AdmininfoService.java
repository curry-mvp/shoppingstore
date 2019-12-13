package service;

import entity.Admininfo;

public interface AdmininfoService {
    int deleteByPrimaryKey(Integer adId);

    int insert(Admininfo record);

    int insertSelective(Admininfo record);

    Admininfo selectByPrimaryKey(Integer adId);

    Admininfo selectByUsername(String adName);

    int updateByPrimaryKeySelective(Admininfo record);

    int updateByPrimaryKey(Admininfo record);
}
