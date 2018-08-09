package com.baizhi.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Machenike on 2018/8/5.
 */
public interface UserService {
    List<User> showAll();

    void active(String id);

    void freeze(String id);

    JSONObject queryUserMapCount();
}
