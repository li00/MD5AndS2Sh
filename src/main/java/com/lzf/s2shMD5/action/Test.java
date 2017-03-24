package com.lzf.s2shMD5.action;

import com.lzf.s2shMD5.model.User;
import com.lzf.s2shMD5.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Test {
        @Autowired
        private IUserService iUserService;
        public void getUser(){
            User u = iUserService.Users(10);
            System.out.println("id="+u.getId()+"\tname="+u.getName());
        }
}
