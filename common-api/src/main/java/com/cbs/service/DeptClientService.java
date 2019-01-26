package com.cbs.service;

import com.cbs.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * @author zzyy
 * @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口
 * <p>
 * 新建
 * <p>
 * 一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @date 2018年4月21日
 */
//@FeignClient(value = "DEPT-PROVIDER")
@FeignClient(value = "DEPT-PROVIDER", fallbackFactory = DeptClientServiceFallbackFactory.class)
@Component
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);
}
