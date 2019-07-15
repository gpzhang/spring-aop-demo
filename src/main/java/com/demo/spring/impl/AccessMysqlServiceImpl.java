package com.demo.spring.impl;

import com.demo.spring.api.DataBaseDao;
import org.springframework.stereotype.Service;

/**
 * @author haishen
 * @date 2019/7/15
 */
@Service
public class AccessMysqlServiceImpl implements DataBaseDao {

    @Override
    public void select() {
        System.out.println("mysql.table 查询！");
    }

    @Override
    public void insert() {
        System.out.println("mysql.table 写入！");
    }

    @Override
    public void delete() {
        System.out.println("mysql.table 删除!");
    }
}
