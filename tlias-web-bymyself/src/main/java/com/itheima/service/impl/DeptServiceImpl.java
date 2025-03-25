package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.pojo.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    /**
     * 查询所有部门数据
     * @return
     */
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    /**
     * 根据id删除部门数据
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        deptMapper.deleteById(id);
 int i=10/0;//模拟异常
        empMapper.deleteByDeptId(id);
    }


    /**
     * 新增部门数据
     * @param dept
     */
   public void save(Dept dept){
       //补全部门数据
       dept.setCreateTime(LocalDateTime.now());
       dept.setUpdateTime(LocalDateTime.now());
       deptMapper.save(dept);

   }
    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
   public Dept getById(Integer id) {
       log.info("根据id查询部门数据:{}",id);
       return deptMapper.getById(id);
   }
    /**
     * 修改部门数据
     * @param dept
     */
    public void update(Dept dept){
        log.info("更新参数：{}", dept);
        //根据id查询部门数据
        Dept dept1 = deptMapper.getById(dept.getId());
        //补全部门数据
        dept.setUpdateTime(LocalDateTime.now());
        //检验
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}