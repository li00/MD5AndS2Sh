package com.lzf.s2shMD5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/19.
 */
public class BaseDaoImp<T> extends HibernateDaoSupport implements IBaseDao<T> {
    private Class<T> cla;

    public Class<T> getClASS() {
        if(cla == null ) {
            ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass(); //获取当前new的对象的泛型的父类类型
            cla= (Class<T>)pt.getActualTypeArguments()[0];  //获取第一个类型参数的真实类型
        }
        return cla;
    }

    @Resource(name = "sessionFactory")
    public void getHibernateSession(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 获取session
     * @return
     */
    private Session getSession(){
        return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
    }

    public void add(T t) {
        this.getSessionFactory().getCurrentSession().save(t);
    }

    public void delete(int id) {
        T t = Users(id);
        this.getHibernateTemplate().delete(t);
    }

    public T getUser(String name,String hql) {
        return (T)this.getSession().createQuery(hql).setParameter(0,name).uniqueResult();
    }

    public T getU(String hql,String name) {
        return (T)this.getSession().createQuery(hql).setParameter(0,name).uniqueResult();
    }

    public T Users(int id) {
        return this.getHibernateTemplate().load(getClASS(),id);
    }
}
