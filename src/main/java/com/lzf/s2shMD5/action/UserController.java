package com.lzf.s2shMD5.action;
import com.lzf.s2shMD5.model.User;
import com.lzf.s2shMD5.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/19.
 */
@Controller
public class UserController extends ActionSupport{
    private User user;
    private String name;
    private String password;
    private String validate;

    @Autowired
    private IUserService iUserService;

    /**
     * 跳转到注册页面
     * @return
     */
    public String reg(){
        return"success";
    }

    /**
     * 用户注册
     * @return
     */
    public String doReg(){
        //非空判断
        if((name!=null&&password!=null)&&!name.equals("")&&!password.equals("")) {
            User u = new User();
            iUserService.add(u, name, password);
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 登陆
     * @return
     */
    public String login(){
        String hql = "from User where name=?";
        //先从session找该用户是否一登陆或这是异地登陆
        if(ActionContext.getContext().getSession().get("user")!=null){
            ActionContext.getContext().put("msg","该用户已登陆！");
            return "error";
        }else if (iUserService.getUser(name, hql, password, validate)) {
                return "success";
            } else {
            return "error";
        }
    }

    /**
     * 用户退出
     * @return
     */
    public String loginOut(){
        ActionContext.getContext().getSession().clear();
        return "success";
    }

    /**
     * 用ajax来判断注册该用户名是否已存在
     * @return
     */
    public void ajax()throws IOException{
        String hql = "from User where name=?";
        User u = iUserService.getU(name,hql);
        HttpServletResponse resp = ServletActionContext.getResponse();
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(u.getName());
        System.out.println(u.getName()+"====");
    }

    /**
     * 测试缓存用
     * @return
     */
    public String testCache(){
        User u = iUserService.Users(12);
        System.out.println(u.getName()+"\t"+u.getPassword());
        return SUCCESS;
    }

    public String excute(){
        return SUCCESS;
    }
    //以下皆为属性封装方法========================================
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
