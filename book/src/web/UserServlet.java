package web;

import bean.User;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserServiceImpl userService = new UserServiceImpl();


    /**
     * 实现登录请求。。。。
     *blalalala
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //
        User loginUser = userService.login(new User(null, user.getUsername(), user.getPassword(), null));
        System.out.println(loginUser);

        if (loginUser == null) {
            //用户名或密码错误
            //把错误信息，回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 实现注册请求
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //检查验证码是否正确
        if ("abcd".equalsIgnoreCase(code)) {
            //检查用户名是否存在
            if (userService.existsUsername(user.getUsername())) {
                //用户名已存在
                req.setAttribute("msg", "用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名不存在，可以注册
                userService.registerUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //验证码错误
            //把回显信息保存在request域中
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
