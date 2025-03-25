package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

//    /**
//     * 分页查询
//     * @param page 页码
//     * @param pageSize 每页显示的条数
//     * @return
//     */
//    @GetMapping("/emps")
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("分页查询 page = {},pageSize = {}",page,pageSize);
//        //调用service查询数据
//        PageBean pageBean= empService.page(page,pageSize);
//        return Result.success(pageBean);
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
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end){
        log.info("条件分页查询参数: page={}, pageSize={}, name={}, gender={}, begin={}, end={}",
                page, pageSize, name, gender, begin, end);  // ← 添加日志
        PageBean pageBean= empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    /**
     * 按照id批量删除
     * @param ids
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success(ids);
    }

    /**
     * 新增员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，参数：{}",emp);
        empService.save(emp);
        return Result.success();
    }
    /**
     * 按照id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询员工信息...");
        Emp emp=empService.getById(id);
        return Result.success(emp);
    }
/**
 * 修改员工
 * @param emp
 * @return
 */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }


}
