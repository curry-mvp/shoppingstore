package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductinfoService;

import java.util.List;

@RestController
public class NavigatorAndShowProductsController {

    @Autowired
    ProductinfoService psi;

    @RequestMapping("/selectAllP_type")
    public List<String> selectAllP_type(){
        System.out.println("abc");
        return psi.selectAllP_type();
    }
}
