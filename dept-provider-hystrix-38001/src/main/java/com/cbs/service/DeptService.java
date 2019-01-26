package com.cbs.service;

import com.cbs.entities.Dept;
import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
