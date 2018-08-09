package com.baizhi.service.impl;

import com.baizhi.aspect.LogAnnotation;
import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Machenike on 2018/7/30.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @LogAnnotation(name = "登录")
    public Admin login(Admin admin) {
        Admin result = adminDAO.login(admin.getName(), admin.getPassword());
        return result;
    }
}
