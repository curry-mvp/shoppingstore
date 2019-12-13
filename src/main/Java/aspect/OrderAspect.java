package aspect;

import entity.Orderdetail;
import entity.Orderinfo;
import entity.Userinfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import service.OrderinfoService;
import serviceimpl.OrderDetailServiceImpl;
import serviceimpl.OrderinfoServiceImpl;
import serviceimpl.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderAspect {
    @Autowired
    OrderinfoServiceImpl osi;

    @Autowired
    OrderDetailServiceImpl odsi;

    @Autowired
    UserServiceImpl usi;

    /*
     * 前置通知
     * */
    public void beforeCheck(JoinPoint joinPoint) {
      /*  Signature sig=joinPoint.getSignature();
        //+joinPoint.getArgs()[0]
        System.out.println("before at "+sig.getName()+"and arg[0] is ");*/
    }

    /*
     *后置通知
     *无法获取返回值 。可以通过返回通知获取返回值
     *且后置通知无论方法是不是异常都会执行
     * */
    public void afterCheck(JoinPoint joinPoint) {
     /*   Signature sig=joinPoint.getSignature();
//+joinPoint.getArgs()[0]
        System.out.println("After at "+sig.getName()+"and arg[0] is ");*/
    }

    /*
     * 返回通知
     * */
    public void afterReturn(JoinPoint joinPoint, Object res) {
        if (res.toString().equals("yes")) {
            Orderinfo oi = new Orderinfo();
            Userinfo ui = new Userinfo();
            oi.setUserid(usi.selectUidByUsername((String) joinPoint.getArgs()[0]));
            oi.setStatus(0);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            oi.setOrdertime(sdf.format(date));

            //Long time = System.currentTimeMillis();
            int randomNum = (int) ((Math.random() * 9 + 1) * 100000);
            //String realNum = time+""+randomNum;
            String realNum = "" + randomNum;
            oi.setPid(Integer.parseInt(realNum));

            Orderdetail od = new Orderdetail();
            od.setpId((Integer) joinPoint.getArgs()[1]);
            od.setOdNum((Integer) joinPoint.getArgs()[2]);
            od.setOdId(Integer.parseInt(realNum));

            osi.insert(oi);
            odsi.insert(od);
        }
        Signature sig = joinPoint.getSignature();
        System.out.println("After at " + sig.getName() + "return. res= " + res);
    }

    /*
     * 异常通知
     * 注意如果这个方法的参数：假设异常类型为数学除零的异常
     * afterThrow(JoinPoint joinPoint,空指针异常类 ex) 然后我这里写了空指针异常
     * 那afterThrow这个方法就执行不了 因为类型不对
     * */
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        Signature sig = joinPoint.getSignature();
        System.out.println("After at " + sig.getName() + "Throw. message= ");
        System.out.println(ex.getMessage());
    }

    /*
     * 环绕通知
     * 环绕通知就等于整个代理过程交给你自己处理  连被代理对象的要执行的目标方法要不要执行也取决你
     * 上面几个通知比较像 处理目标方法调用的某个时刻的 处理过程
     * */
    public Object around(ProceedingJoinPoint pJoinPoint) {

        Object res = null;
        String methodName = pJoinPoint.getSignature().getName();

        System.out.println(methodName + " 执行前(前置通知)");
        try {
            res = pJoinPoint.proceed();
            System.out.println(methodName + " 执行后有结果(返回通知)");
        } catch (Throwable e) {
            System.out.println("异常通知 " + e.getMessage());
        }
        System.out.println(methodName + " 执行后(后置通知)");
        return res;
    }
}
