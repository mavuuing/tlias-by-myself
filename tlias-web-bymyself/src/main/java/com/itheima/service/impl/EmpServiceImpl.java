package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    /**
     * 分页查询
     * @param page
     * @param pageSize
     */
//    public PageBean page(Integer page, Integer pageSize){
////方式一：
////        Integer count = empMapper.count(); //获得总记录数
////         Integer start = (page - 1) * pageSize;//获得起始索引
////       List<Emp> empList = empMapper.page(start,pageSize);
////       return  new PageBean(count, empList);
//
//        //方式二：PageHelper
//        //1.设置分页参数
//        PageHelper.startPage(page,pageSize);
//        //2.执行查询
//        List<Emp> empList = empMapper.list();
//        Page<Emp> p =(Page<Emp>) empList; //本来是List，强转成Page
//        //3.封装PageBean对象
//        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
//        return pageBean;
//    }

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
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end){
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p =(Page<Emp>) empList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
    /**
     * 按照id批量删除
     * @param ids
     */
     public void delete(List<Integer> ids){
        empMapper.delete(ids);
    }

    /**
     * 新增员工
     * @param emp
     */
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
    /**
     * 按照id查询
     * @param id
     * @return
     */
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }
    /**
     * 修改员工
     * @param emp
     */
    public void update(Emp emp){
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    /**
     * 登录
     * @param emp
     * @return
     */
   public Emp login(Emp emp){
        return empMapper.getByUsernameAndPassword(emp);
   }
}
