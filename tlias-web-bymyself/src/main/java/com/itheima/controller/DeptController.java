package com.itheima.controller;

import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;
    //@RequestMapping(value = "/depts" , method = RequestMethod.GET)
    /**
     * 查询所有部门数据
     * @return
     */
    @GetMapping
    public Result list(){
        log.info("查询所有部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门数据:{}",id);
        //调用service删除部门数据
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门数据
     * @param dept
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Dept dept){
        log.info("新增部门数据");
        deptService.save(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询部门数据：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门数据
     * @param dept
     * @return
     */
    @PutMapping()
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据：{}", dept);
        deptService.getById(dept.getId());
        deptService.update(dept);
        return Result.success();
    }

}
