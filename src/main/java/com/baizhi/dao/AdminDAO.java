package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Machenike on 2018/7/30.
 */
public interface AdminDAO {
    Admin login(@Param("name") String name, @Param("password") String password);
}
