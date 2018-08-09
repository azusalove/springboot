package com.baizhi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.aspect.LogAnnotation;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machenike on 2018/8/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> showAll() {
        return userDAO.showAll();
    }

    @Override
    @LogAnnotation(name = "激活用户")
    public void active(String id) {
        userDAO.changeStatus(id, 1);
    }

    @Override
    @LogAnnotation(name = "冻结用户")
    public void freeze(String id) {
        userDAO.changeStatus(id, 0);
    }

    @Override
    public JSONObject queryUserMapCount() {
        JSONObject jsObject = new JSONObject();
        List<UserDTO> maleList = userDAO.selectUserMapCountByMale();
        List<UserDTO> femaleList = userDAO.selectUserMapCountByFemale();
        jsObject.put("male", maleList);
        jsObject.put("female", femaleList);
        return jsObject;
    }

}
