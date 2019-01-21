package com.cbs.service.impl;

import java.util.List;
import com.cbs.dao.DeptDao;
import com.cbs.entities.Dept;
import com.cbs.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        System.out.println(dao.findAll());
        return dao.findAll();
    }

}
