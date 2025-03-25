package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 根据id删除部门数据
     * @param id
     */
    void delete(Integer id);



    /**
     * 新增部门数据
     * @param dept
     */
    void save(Dept dept);

    /**
     * 修改部门数据
     * @param dept
     */
    void update(Dept dept);

    Dept getById(Integer id);
}
