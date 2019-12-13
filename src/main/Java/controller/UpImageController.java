package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import serviceimpl.ProductinfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class UpImageController {

    @Autowired
    ProductinfoServiceImpl pisi;

    @RequestMapping("/addProducts")
    public   String addProducts(@RequestParam String p_code, @RequestParam String p_name, @RequestParam String p_type, @RequestParam String brand, @RequestParam String p_num, @RequestParam String price, @RequestParam String intro, @RequestParam(value = "pic") MultipartFile multipartFile, HttpServletRequest request) throws IOException{
        System.out.println("++++++++++++++"+p_code);
        //获取文件名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println("上传的文件名:"+originalFilename);

        //获取不会重复的毫秒数
        long l = System.currentTimeMillis();
        //新名字
        String newName = l + originalFilename;
        System.out.println("毫秒数+原文件名:"+newName);

        //图片的输入流名字
        InputStream inputStream = multipartFile.getInputStream();

        //存到数据库中的路径
        String ljPath = "/image/" + newName;
        System.out.println("我是存在数据库的图片路径"+ljPath);

        //项目根目录
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("我是项目根目录realPath  "+realPath);

        String lsPath = realPath + ljPath;
        System.out.println("图片在项目中的完整路径:"+lsPath);

        File isFile = new File(realPath + "\\image\\");
        if (!isFile.exists()) {
            isFile.mkdir();
        }

        //不为空时
        if (!multipartFile.isEmpty()) {
            FileOutputStream lsStream = new FileOutputStream(lsPath);
            int len = 0;
            while ((len = inputStream.read()) != -1) {
                lsStream.write(len);
            }
            lsStream.flush();
            lsStream.close();
            inputStream.close();
        }

        Productinfo pi=new Productinfo();
        pi.setpCode(Integer.parseInt(p_code));
        pi.setpName(p_name);
        pi.setpType(p_type);
        pi.setBrand(brand);
        pi.setpNum(Integer.parseInt(p_num));
        pi.setPrice(Double.parseDouble(price));
        pi.setIntro(intro);
        pi.setPic(ljPath);
        pi.setStatus(0);
        int index=pisi.insertSelective(pi);
        if(index>0){
            return "ok";
        }
        return  "no";
    }
}
