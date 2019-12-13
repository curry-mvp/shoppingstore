package serviceimpl;

import entity.WebInfo;
import mapper.WebInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.WebInfoService;

import java.util.List;

@Service
public class WebInfoServiceImpl implements WebInfoService {
    @Autowired
    WebInfoMapper wim;

    @Override
    public int insert(WebInfo wi) {
        return wim.insert(wi);
    }

    @Override
    public List<WebInfo> selectAll() {
        return wim.selectAll();
    }

    @Override
    public WebInfo selectByVisitTime(String visittime) {
        return wim.selectByVisitTime(visittime);
    }

    @Override
    public int update(WebInfo wi) {
        return wim.update(wi);
    }
}
