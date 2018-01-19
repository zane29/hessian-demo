package ooopen.hessian;


import com.caucho.hessian.server.HessianServlet;

public class HelloImp extends HessianServlet implements Hello {

    @Override
    public void sayHello(User user) {
        System.out.println("sayHello:" + user);
    }

    @Override
    public User getCurUser() {
        User user = new User();
        user.setName("HessionService");
        user.setAge(1);
        return user;
    }
}
