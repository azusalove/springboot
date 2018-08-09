package com.baizhi.service.impl;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Machenike on 2018/7/30.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<Menu> showAll() {
        return menuDAO.showAll();
    }
}
