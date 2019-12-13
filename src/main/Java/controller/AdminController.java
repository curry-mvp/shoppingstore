package controller;

import entity.Admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceimpl.AdmininfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    AdmininfoServiceImpl asi;

    @RequestMapping("/adminlogin")
    public String toString(@RequestParam String adName, @RequestParam String password, HttpServletRequest request) {
        Admininfo ai = new Admininfo();
        ai.setAdName(adName);
        ai.setAdPassword("password");
        HttpSession session = request.getSession();
        session.setAttribute("admininfo", ai);
        Admininfo ai2 = new Admininfo();
        Admininfo ai3 = asi.selectByUsername(adName);
        if (ai2 != null) {
            if (password.equals(ai2.getAdPassword())) {
                return "right";
            }else{
                return "not";
            }
        }return "error";
    }
}
