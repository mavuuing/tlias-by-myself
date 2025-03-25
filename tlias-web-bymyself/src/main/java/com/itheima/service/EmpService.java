package com.itheima.service;

import com.itheima.pojo.Emp;
import org.springframework.stereotype.Service;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
//    /**
//     * 分页查询
//     * @param page
//     * @param pageSize
//     */
//    PageBean page(Integer page, Integer pageSize);

    /**
     * 条件分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 按照id批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);
    /**
     * 按照id查询
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
