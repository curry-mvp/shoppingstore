package controller;

import entity.Userinfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import serviceimpl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class LoginAndRegisterController {

    @Autowired
    UserServiceImpl usi;

    @RequestMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        /*如果查询结果不为空，说明该用户已存在，不允许注册*/
        if (usi.selectByUsername(username) != null) {
            return "existed";
        } else {
            Userinfo ui = new Userinfo();
            ui.setUsername(username);
            ui.setPassword(DigestUtils.md5Hex(password.getBytes()));
            ui.setEmail(email);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ui.setRegisterTime(sdf.format(date));
            int line = usi.insert(ui);
            if (line > 0) {
                return "yes";
            } else {
                return "no";
            }
        }
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String flag, HttpServletRequest req,HttpServletResponse resp) {
        Userinfo ui = usi.selectByUsername(username);
        if(ui==null){
            return "none";
        }else{
            if(DigestUtils.md5Hex(password.getBytes()).equals(ui.getPassword())){
                    //ui.setPassword(password);

                    Cookie cookie1 = new Cookie("username",username);
                    Cookie cookie2 = new Cookie("password",password);
                    cookie1.setMaxAge(10000);
                    cookie2.setMaxAge(10000);
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
                    if(flag.equals("yes")) {
                        Cookie cookie3 = new Cookie("flag", "no");
                        cookie3.setMaxAge(50000);
                        resp.addCookie(cookie3);
                    }else{
                        Cookie cookie4 = new Cookie("flag","yes");
                        cookie4.setMaxAge(50000);
                        resp.addCookie(cookie4);


//                    Cookie[] cookies = req.getCookies();
//                    if(cookies.length>0){
//                        for(Cookie c:cookies){
//                            if(c.getName().equals(username)){
//                                c.setValue(null);
//                                c.setMaxAge(0);
//                                resp.addCookie(c);
//                            }
//                        }
//                    }

                    // req.getSession().removeAttribute(username);

                    //req.getSession().setAttribute("info",ui);
                }
                return "yes";
            }else{
                return "no";
            }
        }
    }

    @RequestMapping("/forgetpwd")
    public String forgetpwd(@RequestParam String username,@RequestParam String password,@RequestParam String password1 ) {
        if (username!=""&& password!=""&&password1!="") {
            if (!password1.equals(password)) {
                return "no";
            } else {
                Userinfo userinfo = usi.selectByUsername(username);
                String pwd = userinfo.getPassword();
                if (DigestUtils.md5Hex(password.getBytes()).equals(password1)) {
                    return "same";
                } else {
                    Integer id = userinfo.getuId();
                    Userinfo ui = new Userinfo();
                    ui.setuId(id);
                    ui.setPassword(DigestUtils.md5Hex(password.getBytes()));
                    int i = usi.updateByPrimaryKeySelective(ui);
                    if (i > 0) {
                        return "yes";
                    } else {
                        return "none";
                    }
                }
            }
        }else {
            return "null";
        }
    }
}