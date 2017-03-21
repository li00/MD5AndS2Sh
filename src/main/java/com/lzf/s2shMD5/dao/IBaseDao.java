package com.lzf.s2shMD5.dao;

import com.lzf.s2shMD5.model.User;

/**
 * Created by Administrator on 2017/3/19.
 */
public interface IBaseDao<T> {
    void add(T t);
    void delete(int id);
    T getUser(String name,String hql);
    T getU(String hql,String name);
    T User(int id);
}
