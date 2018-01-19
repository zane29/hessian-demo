package ooopen.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import ooopen.hessian.Hello;
import ooopen.hessian.User;

import java.net.MalformedURLException;

public class Client {

    public static void main(String[] args) {
        String url = "http://localhost:9011/" + Hello.class.getName();
        HessianProxyFactory factory = new HessianProxyFactory();
        //设置是否允许重载方法。允许：true
        factory.setOverloadEnabled(true);
        try {
            Hello hello = (Hello) factory.create(Hello.class, url);
            System.out.println(hello.getCurUser());
            User user = hello.getCurUser();
            //服务端打印出：sayHello:User{name='HessionServer', age=1}
            hello.sayHello(user);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
