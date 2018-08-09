package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Machenike on 2018/8/5.
 */
public interface UserDAO {
    List<User> showAll();

    void changeStatus(@Param("id") String id, @Param("status") int status);

    List<UserDTO> selectUserMapCountByMale();

    List<UserDTO> selectUserMapCountByFemale();
}
