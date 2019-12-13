package controller;

import entity.Productinfo;
import entity.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ProductinfoService;
import serviceimpl.WebInfoServiceImpl;

import java.util.List;

@RestController
public class NavigatorAndShowProductsController {

    @Autowired
    ProductinfoService psi;

    @Autowired
    WebInfoServiceImpl wsi;

    @RequestMapping("/selectAllP_type")
    public List<String> selectAllP_type(){
        return psi.selectAllP_type();
    }

    @RequestMapping("/selectAllProductsByP_type")
    List<Productinfo> selectAllProductsByP_type(@RequestParam String p_type,@RequestParam Integer page){
        return psi.selectAllProductsByP_type(p_type,page);
    }

    @RequestMapping("/getWebData")
    public List<WebInfo> selectAll(){
        return wsi.selectAll();
    }
}
