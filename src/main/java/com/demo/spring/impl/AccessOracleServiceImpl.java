package com.demo.spring.impl;

import com.demo.spring.api.DataBaseDao;
import org.springframework.stereotype.Service;

/**
 * @author haishen
 * @date 2019/3/21
 */
@Service
public class AccessOracleServiceImpl implements DataBaseDao {

    @Override
    public void select() {
        System.out.println("oracle.table 查询！");
    }

    @Override
    public void insert() {
        System.out.println("oracle.table 写入！");
    }


    @Override
    public void delete() {
        System.out.println("oracle.table 删除!");
    }


}
