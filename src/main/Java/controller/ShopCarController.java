package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import serviceimpl.ProductinfoServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopCarController {

    @Autowired
    JedisPool jedisPool;

    @Autowired
    ProductinfoServiceImpl psi;

    @RequestMapping("/addCar")
    public String addCar(@RequestParam String pid,@RequestParam String username){
        /**
         * 购物车存储结构:
         * redis的hmset存储:hmset是一个map集合,该集合的key存储username(用户名)
         * value存储一个map集合,其中这个map集合的key存储pid(商品唯一标识),
         * value存储的是用户购物车每个商品的数量
         */

        //获取jedis对象
        Jedis jedis = jedisPool.getResource();

        /**
         * 判断用户购物车是否有商品:hgetAll通过用户名得到value
         * 1.如果value不为空,说明有商品,直接添加
         * 2.如果value为空,需要创建一个map集合
         */

        Map<String, String> map = jedis.hgetAll(username);
        if(map.isEmpty()){
            map = new HashMap<String, String>();
            map.put(pid,"1");

            //存入redis里面
            String hmset = jedis.hmset(username, map);
        }else{
            if(map.containsKey(pid)){
                map.put(pid,String.valueOf(Integer.parseInt(map.get(pid))+1));

                //存入redis里面
                jedis.hmset(username,map);
            }else{
                map.put(pid,"1");

                //存入redis里面
                jedis.hmset(username,map);
            }
        }
        return "";
    }

    @RequestMapping("/getCar")
    public List<Productinfo> getCar(@RequestParam String username){
        //获取jedis对象
        Jedis jedis = jedisPool.getResource();
        Map<String, String> map = jedis.hgetAll(username);
        List<Productinfo> list = new ArrayList<Productinfo>();
        if(!map.isEmpty()){
            for(Map.Entry<String,String> entry : map.entrySet()){
                Productinfo pi = psi.selectByPrimaryKey(Integer.parseInt(entry.getKey()));
                pi.setpNum(Integer.parseInt((entry.getValue())));
                list.add(pi);
            }
        }return list;
    }

    @RequestMapping("/removeItems")
    public void removeItems(@RequestParam String pid,@RequestParam String username){
        //获取jedis对象
        Jedis jedis = jedisPool.getResource();
        Map<String, String> map = jedis.hgetAll(username);
        map.remove(pid);

        //先在redis删除然后再添加,否则就算在map里面移除,也无法替换redis里面内容
        jedis.del(username);
        jedis.hmset(username,map);
    }

    @RequestMapping("reduceItemsNum")
    public void reduceItemsNum(@RequestParam String pid,@RequestParam String username,@RequestParam String pnum){
        //获取jedis对象
        Jedis jedis = jedisPool.getResource();
        Map<String, String> map = jedis.hgetAll(username);
        if(Integer.parseInt(pnum)>=1){
            map.remove(pid);
            map.put(pid,pnum);
            jedis.del(username);
            jedis.hmset(username,map);
        }else{
            map.remove(pid);
            jedis.del(username);
            jedis.hmset(username,map);
        }
    }

    @RequestMapping("/removeItems")
    public void removeItems(@RequestParam String pid,@RequestParam String username,@RequestParam String pnum){
        //获取jedis对象
        Jedis jedis = jedisPool.getResource();
        Map<String, String> map = jedis.hgetAll(username);
        map.remove(pid);
        map.put(pid,pnum);
        jedis.del(username);
        jedis.hmset(username,map);
    }
}
