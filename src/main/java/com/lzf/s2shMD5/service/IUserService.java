package com.lzf.s2shMD5.service;

import com.lzf.s2shMD5.model.User;

/**
 * Created by Administrator on 2017/3/19.
 */
public interface IUserService {
    void add(User user,String name,String passwd);
    void delete(int id);
    boolean getUser(String name,String hql,String passwd,String validate);
    User getU(String name,String hql);
}
