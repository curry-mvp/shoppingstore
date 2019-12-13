package mapper;

import entity.WebInfo;

import java.util.List;

public interface WebInfoMapper {
int insert(WebInfo wi);
List<WebInfo> selectAll();
WebInfo selectByVisitTime(String visittime);
int update(WebInfo wi);

}
