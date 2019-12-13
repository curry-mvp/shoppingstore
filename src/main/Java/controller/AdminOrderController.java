package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceimpl.ProductinfoServiceImpl;

import java.util.List;

@RestController
public class AdminOrderController {

    @Autowired
    ProductinfoServiceImpl psi;

    @RequestMapping("/getOnProducts")
    public List<Productinfo> getOnProducts(){
        List<Productinfo> list = psi.selectupProducts();
        return list;
    }

    @RequestMapping("/downProduct")
    public String OnProduct(@RequestParam String pId){
        Productinfo pi = new Productinfo();
        pi.setpId(Integer.parseInt(pId));
        pi.setStatus(0);
        int i = psi.updateByPrimaryKeySelective(pi);
        if(i>0){
            return "yes";
        }else {
            return "no";
        }
    }

    @RequestMapping("/getdownProducts")
    public List<Productinfo> getdownProducts(){
        List<Productinfo> list = psi.selectdownProduct();
        return list;
    }

    @RequestMapping("/OnProduct")
    public String downProduct(@RequestParam String pId){
        Productinfo pi = new Productinfo();
        pi.setpId(Integer.parseInt(pId));

        pi.setStatus(1);
        int i = psi.updateByPrimaryKeySelective(pi);
        if(i>0){
            return "ok";
        }else {
            return "not";
        }
    }


}
