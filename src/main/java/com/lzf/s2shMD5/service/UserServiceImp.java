package com.lzf.s2shMD5.service;

import com.lzf.s2shMD5.dao.IUserDao;
import com.lzf.s2shMD5.model.User;
import com.lzf.s2shMD5.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/19.
 */
@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    public void add(User u,String name,String passwd) {
        User user = new User(name,MD5.md5(passwd,name));
        iUserDao.add(user);
    }

    public void delete(int id) {
        iUserDao.delete(id);
    }

    public boolean getUser(String name,String hql,String passwd) {
        User u = this.iUserDao.getUser(name,hql);
        if(u!=null){
            String pwd = MD5.md5(passwd,name);
            if(u.getPassword().equals(pwd)){
                ActionContext.getContext().getSession().put("user", name);
                return true;
            }else {
                ActionContext.getContext().put("msg", "用户名与密码输入不一致！");
                return false;
            }
        }else {
         return false;
        }
    }

    public User getU(String name, String hql) {
        return iUserDao.getU(hql,name);
    }
}
