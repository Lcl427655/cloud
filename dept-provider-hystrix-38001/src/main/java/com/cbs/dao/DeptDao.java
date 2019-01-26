package com.cbs.dao;

import java.util.List;
import com.cbs.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept findById(Long deptId);

    public List<Dept> findAll();
}
